package Action;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import proxy.ActionProxy;
import util.ActionMapper;
import util.ActionMapping;

public class Filterdispatcher implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		String requestPath=req.getServletPath();
		System.out.println("����·��:"+requestPath);
		ActionMapping mapping=new ActionMapper().isHasAction(requestPath);
		if(mapping==null){//��������action������
			chain.doFilter(request,response);
			return ;
		}
		//������̬�������
		IAction actionProxy=new ActionProxy().createActionProxy(mapping);
		//ʹ��Action������������ýӿ��еķ���
		actionProxy.execute();	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

}
