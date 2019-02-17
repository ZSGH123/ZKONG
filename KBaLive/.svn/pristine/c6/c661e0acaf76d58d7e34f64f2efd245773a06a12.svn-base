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
import javax.servlet.http.HttpSession;

import com.kba.action.session.KBaSessionContext;
/**
 * 登陆时-踢人下线过滤器
 * @author 钟强
 * 创建时间：2019-01-19
 * 修改时间：
 */
public class LoginFilter implements Filter {
	/**
     * 存储所有会话对象
     */
	 private KBaSessionContext sessionContext;
	 
    public LoginFilter(){
    	 sessionContext=KBaSessionContext.getSessionContext();
    }
	
	@Override
	public void destroy() {
	
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		    HttpServletRequest request =  (HttpServletRequest)req;
	        HttpServletResponse response =  (HttpServletResponse)resp;
	        String localIp = request.getRemoteAddr();//获取本地ip
	        HttpSession session = null;
	        String userId = (String)request.getParameter("userId"); 
	        if(userId!=null)
	        {
	            session = sessionContext.getSessionById(userId);
	        }
	        String loginedIp = null;
	        if(session!=null)
	        {
	            loginedIp = (String)session.getAttribute("loginIp");//获取已登录者ip
	        }
	        if(loginedIp!=null && !localIp.equals(loginedIp)){
	            sessionContext.delSession(session);//踢人--找到并销毁Session
	            request.setAttribute("msg", "您的账号已在其它ip登录,您被踢下线了!");
	            request.getRequestDispatcher("login.jsp").forward(request, response);
	        }else{
	            chain.doFilter(request, response);//放行
	        }	
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("登陆过滤器一初始化");
	}
 
	
}
