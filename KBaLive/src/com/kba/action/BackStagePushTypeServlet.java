package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.PushType;
import com.kba.service.impl.BackStagePushTypeService;
import com.kba.util.KBaException;
/**
 * 后台推送类型数据的处理
 * @author 单杰
 * 创建时间：2019-1-25
 * 修改时间：
 */

public class BackStagePushTypeServlet extends KBaBaseServlet{
	
	private static final long serialVersionUID = 1L;
    //推送类型业务对象
	private BackStagePushTypeService pushTypeService;
	
    public BackStagePushTypeServlet() {
		this.pushTypeService=new BackStagePushTypeService();
	}

	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PushType> pushTypes=null;
		PushType pushType=this.wrap(req);
		try {
			pushTypes=pushTypeService.selectAllPushType(pushType);
			req.removeAttribute("pushTypes");
			req.setAttribute("pushTypes", pushTypes);
			req.getRequestDispatcher("push-type-index.jsp").forward(req, resp);
		} catch (KBaException e) {
			toError(e, resp);
		}
		
	}

	/**
	 * 通过类型名称检查类型是否存在
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkPushTypeByName(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装请求包推送类型数据
		PushType pushType=this.wrap(req);
	    try {
			boolean has=pushTypeService.checkPushTypeByName(pushType);
			if(has){
				out.print("推送类型已存在");
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
	 * 新增推送类型
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertPushType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装数据
		PushType pushType=this.wrap(req);
		try {
			//插入数据
			System.out.println(pushType);
			pushType=pushTypeService.insertPushType(pushType);
			if(pushType!=null){
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
	 * 删除推送类型
	 */
	public void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
				//out对象
				PrintWriter out=resp.getWriter();
				PushType pushType=this.wrap(req);
				try {
					//删除
					pushType=pushTypeService.deletePushType(pushType);
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
		PushType pushType=this.wrap(req);
		try {
			pushType=pushTypeService.selectPushTypeByID(pushType);
			System.out.println(pushType);
			if(pushType!=null){
				session.setAttribute("updateOfPushType", pushType);
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
	 * 取消修改推送类型信息的session对象中的等级信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void quXiao(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=this.getSession();
		session.removeAttribute("updateOfPushType");
		out.print(true);
	}
	
	/**
	 * 成功修改推送类型
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePushType(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		PushType pushType=this.wrap(req);
		try {
			pushType=pushTypeService.updatePushType(pushType);
			session.removeAttribute("updateOfPushType");
			if(pushType!=null){
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
	
	private PushType wrap(HttpServletRequest req) {
		PushType pushType=new PushType();
		String pTId=req.getParameter("pushTypeId");
		String pTName=req.getParameter("pushTypeName");
		String pTPrice=req.getParameter("pushPrice");
		int pTypePrice=pTPrice!=null?Integer.parseInt(pTPrice):0;
		String pTRemark=req.getParameter("pushTypeRemark");
		
		pushType.setPushTypeId(pTId);
		pushType.setPushName(pTName);
		pushType.setPushPrice(pTypePrice);
		pushType.setPushTypeRemark(pTRemark);
		return pushType;
	}
	
}
