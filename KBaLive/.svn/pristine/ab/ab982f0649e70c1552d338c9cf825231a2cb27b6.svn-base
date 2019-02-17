package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.AnchorInfo;
import com.kba.entity.UserInfo;
import com.kba.service.impl.BackStageAnchorInfoService;
import com.kba.service.impl.UserService;
import com.kba.util.KBaException;

/**
 * 响应整个后台首页
 * @author 赵科
 * 创建时间：2019-1-17
 * 修改时间：
 */
public class BackStageIndexServlet extends KBaBaseServlet{

	private static final long serialVersionUID = 1L;
    //用户业务
	private UserService userService;
	//主播信息业务
	private BackStageAnchorInfoService anchorInfoService;
	
	public BackStageIndexServlet(){
		this.userService=new UserService();
		this.anchorInfoService=new BackStageAnchorInfoService();
	}
	/**
	 * 后台首页方法
	 */
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		UserInfo user=null;
		AnchorInfo anchor=null;
		//用户总数集合
		List<UserInfo> users=null;
		//主播总数集合
		List<AnchorInfo> anchors=null;
		try {
			users=userService.selectAllUser(user);
			anchors=anchorInfoService.selectAllAnchorInfo(anchor);
			session.setAttribute("anchors", anchors.size());
			session.setAttribute("users", users.size());
			if(session.getAttribute("page")==null){
			  req.getRequestDispatcher("index.jsp").forward(req, resp);
			}else{
				resp.sendRedirect(session.getAttribute("page").toString());
				session.removeAttribute("page");
			}
		} catch (KBaException e) {
			this.toError(e, resp);
		}
	}

	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
