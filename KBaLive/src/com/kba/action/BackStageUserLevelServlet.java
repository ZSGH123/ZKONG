package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.UserLevel;
import com.kba.service.impl.BackStageUserLevelService;
import com.kba.util.KBaException;

/**
 * 后台用户等级设置
 * @author 赵科
 * 创建时间：2019-1-22
 * 修改时间：
 *
 */
public class BackStageUserLevelServlet extends KBaBaseServlet{

	private static final long serialVersionUID = 1L;
    //用户等级业务对象
	private BackStageUserLevelService userLevelService;
	
	public BackStageUserLevelServlet() {
		this.userLevelService=new BackStageUserLevelService();
	} 
	/**
	 * 用户等级设置首页
	 */
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<UserLevel> userLevels=null;
		UserLevel userLevel=this.wrap(req);
		try {
			userLevels=userLevelService.selectAllUserLevel(userLevel);
			//req.removeAttribute("userLevels");
			req.setAttribute("userLevels", userLevels);
			req.getRequestDispatcher("levelset-userlevel-index.jsp").forward(req, resp);
		} catch (KBaException e) {
			toError(e, resp);
		}
	}

	/**
	 * 通过等级名称检查等级是否存在
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkUserLevelByName(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装请求包用户等级数据
		UserLevel userLevel=this.wrap(req);
	    try {
			boolean has=userLevelService.checkUserLevelByName(userLevel);
			if(has){
				out.print("用户等级已存在");
			}else{
				out.print(true);
			}
		} catch (KBaException e) {
			toError(e, resp);
		}finally{
			
			out.close();
		}
	}

	/**
	 * 新增用户等级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertUserLevel(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装数据
		UserLevel userLevel=this.wrap(req);
		try {
			//插入数据
			System.out.println(userLevel);
			userLevel=userLevelService.insertUserLevel(userLevel);
			if(userLevel!=null){
				out.print(true);
			}else{
				out.print(false);
			}
			//req.getRequestDispatcher("managerInfoAction.do").forward(req, resp);
		} catch (KBaException e) {
			toError(e, resp);
		}finally{
			out.close();
		}
	}
	
	/**
	 * 删除用户等级
	 */
	public void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
				//out对象
				PrintWriter out=resp.getWriter();
				UserLevel userLevel=this.wrap(req);
				System.out.println(userLevel);
				try {
					//删除后台管理员
					userLevel=userLevelService.deleteUserLevel(userLevel);
					out.print(true);   
				} catch (KBaException e) {
					toError(e, resp);
				}finally{
					
					out.close();
				}
	}
	
	/**
	 * 更新操作在打开一个新页面前把数据保存到session对象中，并从session中获取数据
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void selectOfUpdate(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=this.getSession();
		UserLevel userLevel=this.wrap(req);
		try {
			userLevel=userLevelService.selectUserLevelByUserLevelID(userLevel);
			System.out.println(userLevel);
			if(userLevel!=null){
				session.setAttribute("updateOfUserLevel", userLevel);
				//req.getRequestDispatcher("manager-update.jsp").forward(req, resp);
				//resp.sendRedirect("manager-update.jsp");
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (KBaException e) {
			toError(e, resp);
		}finally{
			out.close();
		}
	}
	
	/**
	 * 取消修改用户等级信息的session对象中的等级信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void quXiao(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=this.getSession();
		session.removeAttribute("updateOfUserLevel");
		out.print(true);
	}
	
	/**
	 * 成功修改用户等级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateUserLevel(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		UserLevel userLevel=this.wrap(req);
		System.out.println(userLevel);
		try {
			userLevel=userLevelService.updateUserLevel(userLevel);
			session.removeAttribute("updateOfUserLevel");
			if(userLevel!=null){
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (KBaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	private UserLevel wrap(HttpServletRequest req) {
		UserLevel userLevel=new UserLevel();
		String uLId=req.getParameter("userLevelId");
		String uLName=req.getParameter("userLevelName");
		String uLInvest=req.getParameter("userLowInvest");
		int uLowInvest=uLInvest!=null?Integer.parseInt(uLInvest):0;
		String uHInvest=req.getParameter("userHighInvest");
		int uHighInvest=uHInvest!=null?Integer.parseInt(uHInvest):0;
		String uLRemark=req.getParameter("userLevelRemark");
		
		userLevel.setUserLevelId(uLId);
		userLevel.setUserLevelName(uLName);
		userLevel.setUserLowInvest(uLowInvest);
		userLevel.setUserHighInvest(uHighInvest);
		userLevel.setUserLevelRemark(uLRemark);
		return userLevel;
	}
}