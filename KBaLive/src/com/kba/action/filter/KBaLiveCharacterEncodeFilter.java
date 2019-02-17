package com.kba.action.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 过滤器解决字符编码问题
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class KBaLiveCharacterEncodeFilter implements Filter {
    /**
     * 编码
     */
	private String encode;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		req.setCharacterEncoding(this.encode);
		resp.setContentType("text/html;charset="+this.encode);
		String method=req.getMethod();
		if("get".equals(method.toLowerCase())){//如果是get方式，把原始request进行装饰
			req=new DecorateRequest(req, this.encode);
		}
		//过滤链机制
		chain.doFilter(req, resp);	
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.encode=config.getInitParameter("encoding");
		System.out.println("过滤器被初始化"+encode);	
	}


}
