package com.kba.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.UserInfo;
import com.kba.service.IUserService;
import com.kba.service.impl.UserService;
import com.kba.util.KBaException;
/**
 * 主播认证Action
 * @author 钟强
 * 时间：2019-1-25
 */
public class AnchorAuthenticationServlet extends KBaBaseServlet {

	private static final long serialVersionUID = 1L;

	private IUserService userService;
	
	public AnchorAuthenticationServlet(){
		userService=new UserService();
	}
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.toAnchorAuthentication(req, resp);
	}

	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}
	/**
	 * 去主播认证页面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAnchorAuthentication(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("anchor-authentication.jsp").forward(req, resp);
	}
	
	/**
	 * 去绑定手机号
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toBundlePhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.toAuthentication(req, resp, "authentication-guide.jsp", 0);
		} catch (KBaException e) {
			this.toError(e, resp);
		}
	}
	
	/**
	 * 去实名认证
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toRealNameSure(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.toAuthentication(req, resp, "id-card.jsp", 1);
		} catch (KBaException e) {
			this.toError(e, resp);
		}
	}
	
	/**
	 * 去开直播
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toOpenLive(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("anchorSet.jsp").forward(req, resp);
	}
	
	/**
	 * 根据参数去认证
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 * @throws KBaException 
	 */
	protected void toAuthentication(HttpServletRequest req, HttpServletResponse resp,String page,int operate) throws ServletException, IOException, KBaException {
		HttpSession session=getSession();
		UserInfo loginUser=(UserInfo) session.getAttribute("loginUser");
		if(loginUser==null){
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}
		UserInfo userdb=null;
		userdb=userService.selectUserByPhone(loginUser);
		if(userdb==null){
			req.getRequestDispatcher("reset-phone.jsp").forward(req, resp);
			return;
		}
		if(operate==0){
			req.getRequestDispatcher(page).forward(req, resp);
			return;
		}
		if(operate==1){//去实名认证
		   if(userdb.getUserRealName()==null){//没实名
			  req.getRequestDispatcher(page).forward(req, resp);
			  return;
		   }
		   //已实名,去开播页面
		   this.toOpenLive(req, resp);
		   return;
		}	
		 
	}
	
}
