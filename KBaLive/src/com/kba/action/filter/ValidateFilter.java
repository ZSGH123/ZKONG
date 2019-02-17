package com.kba.action.filter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Vector;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.kba.util.KBaException;


/**
 * 验证过滤器
 * 
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class ValidateFilter implements Filter {
	/**
	 * 所有需验证的资源的集合
	 */
	private Vector<Validate> validates;

	public ValidateFilter(){
		this.validates=new Vector<Validate>();
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String filePath = filterConfig.getInitParameter("validatexmpath");
		ServletContext application = filterConfig.getServletContext();
		URL url =null;
		try {
			url = application.getResource(filePath);
			//System.out.println(url);
			this.parseXml(url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (KBaException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		String filePath = req.getServletPath();
		String method=req.getQueryString();
		// request的url,不带参数(?)
		// System.out.println(req.getRequestURL());
		if (isValidate(filePath,method)) {
			if (session.getAttribute("loginUser") == null) {
				String previouspage=req.getRequestURL()+"?"+method;
				session.setAttribute("previouspage",previouspage);
				resp.sendRedirect("login.jsp");
				return;
			}
		}
		chain.doFilter(req, resp);

	}
	
    /**
     * 判断所访问的资源和相应方法是否需要验证
     */
    private boolean isValidate(String filePath, String method) {
    	if(filePath==null) return false;
    	for(Validate validate:validates){
    		if(method!=null){
    			if(filePath.equals(validate.path)&&method.contains((validate.method))){
    				return true;
    			}
    		}else {
    			if(filePath.equals(validate.path)){
    				return true;
    			}
			}	
    	}
  		return false;
	}

	/**
     * 解析web-inf下的validate.xml
     * @param url
     * @throws MyException
     */
	@SuppressWarnings("unchecked")
	private void parseXml(URL url) throws KBaException {
		if(url==null) return ;
		SAXReader reader=new SAXReader();
		Document document=null;
		try {
			document=reader.read(url);
			Element root = document.getRootElement();
			List<Element> sub = root.elements();
			Validate validate=null;
			for (Element element : sub) {
				validate=new Validate();
				validate.method=element.attributeValue("method");
				validate.path=element.getText();
				this.validates.add(validate);
				System.out.println(validate);
			}
		} catch (DocumentException e) {
			throw new KBaException();
		}	
	}
    
	@Override
	public void destroy() {

	}
	
	/**
	 * 需验证信息
	 * @author 钟强
	 *
	 */
	private class Validate {
		/**
		 * 资源路径
		 */
		private String path;
		/**
		 * servlet中的某个方法
		 */
		private String method;
		
		public String toString(){
			return "path:"+path+" method"+method;
		}
	}
}
