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
		System.out.println("请求路径:"+requestPath);
		ActionMapping mapping=new ActionMapper().isHasAction(requestPath);
		if(mapping==null){//不是请求action，放行
			chain.doFilter(request,response);
			return ;
		}
		//创建动态代理对象
		IAction actionProxy=new ActionProxy().createActionProxy(mapping);
		//使用Action代理对象来调用接口中的方法
		actionProxy.execute();	
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

}
