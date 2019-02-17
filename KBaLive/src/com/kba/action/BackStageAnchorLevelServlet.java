package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.kba.entity.AnchorLevel;
import com.kba.service.impl.BackStageAnchorLevelService;
import com.kba.util.KBaException;

/**
 * 后台主播等级数据的处理
 * @author 赵科
 * 创建时间：2019-1-22
 * 修改时间：
 */
public class BackStageAnchorLevelServlet extends KBaBaseServlet{

	private static final long serialVersionUID = 1L;
    //主播等级业务对象
	private BackStageAnchorLevelService anchorLevelService;
	
    public BackStageAnchorLevelServlet() {
		this.anchorLevelService=new BackStageAnchorLevelService();
	}
	
	/**
	 * 主播等级设置首页
	 */
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<AnchorLevel> anchorLevels=null;
		AnchorLevel anchorLevel=this.wrap(req);
		try {
			anchorLevels=anchorLevelService.selectAllAnchorLevel(anchorLevel);
			//req.removeAttribute("anchorLevels");
			req.setAttribute("anchorLevels", anchorLevels);
			req.getRequestDispatcher("levelset-anchorlevel-index.jsp").forward(req, resp);
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
	public void checkAnchorLevelByName(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装请求包主播等级数据
		AnchorLevel anchorLevel=this.wrap(req);
	    try {
			boolean has=anchorLevelService.checkAnchorLevelByName(anchorLevel);
			if(has){
				out.print("主播等级已存在");
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
	 * 新增主播等级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertAnchorLevel(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装数据
		AnchorLevel anchorLevel=this.wrap(req);
		System.out.println(req.getParameter("liveMinTotalTime"));
		System.out.println(req.getParameter("liveMaxTotalTime"));
		try {
			//插入数据
			System.out.println(anchorLevel);
			anchorLevel=anchorLevelService.insertAnchorLevel(anchorLevel);
			if(anchorLevel!=null){
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
	 * 删除主播等级
	 */
	public void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
				//out对象
				PrintWriter out=resp.getWriter();
				//List<AnchorLevel> anchorLevels=null;
				AnchorLevel anchorLevel=this.wrap(req);
				try {
					//删除后台管理员
					anchorLevel=anchorLevelService.deleteAnchorLevel(anchorLevel);
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
		AnchorLevel anchorLevel=this.wrap(req);
		try {
			anchorLevel=anchorLevelService.selectAnchorLevelByID(anchorLevel);
			System.out.println(anchorLevel);
			if(anchorLevel!=null){
				session.setAttribute("updateOfAnchorLevel", anchorLevel);
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
	 * 取消修改主播等级信息的session对象中的等级信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void quXiao(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=this.getSession();
		session.removeAttribute("updateOfAnchorLevel");
		out.print(true);
	}
	
	/**
	 * 成功修改主播等级
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateAnchorLevel(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		AnchorLevel anchorLevel=this.wrap(req);
		try {
			anchorLevel=anchorLevelService.updateAnchorLevel(anchorLevel);
			session.removeAttribute("updateOfAnchorLevel");
			if(anchorLevel!=null){
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
	
	private AnchorLevel wrap(HttpServletRequest req) {
		AnchorLevel anchorLevel=new AnchorLevel();
		String aLId=req.getParameter("anchorLevelId");
		String aLName=req.getParameter("anchorLevelName");
		String lMinTime=req.getParameter("liveMinTotalTime");
		int liveMinTime=lMinTime!=null?Integer.parseInt(lMinTime):0;
		String lMaxTime=req.getParameter("liveMaxTotalTime");
		int liveMaxTime=lMaxTime!=null?Integer.parseInt(lMaxTime):0;
		String aLRemark=req.getParameter("anchorLevelRemark");
		
		anchorLevel.setAnchorLevelId(aLId);
		anchorLevel.setAnchorLevelName(aLName);
        anchorLevel.setLiveMinTotalTime(liveMinTime);
        anchorLevel.setLiveMaxTotalTime(liveMaxTime);
		anchorLevel.setAnchorLevelRemark(aLRemark);
		return anchorLevel;
	}
    
	public static void main(String[] args) {
		AnchorLevel anchorLevel=new AnchorLevel();
		anchorLevel.setAnchorLevelName("黄金");
		anchorLevel.setLiveMinTotalTime(1000);
		anchorLevel.setLiveMaxTotalTime(2000);
		anchorLevel.setAnchorLevelRemark("1");
		BackStageAnchorLevelService anchorLevelService=new BackStageAnchorLevelService();
		try {
			anchorLevel=anchorLevelService.insertAnchorLevel(anchorLevel);
			System.out.println(anchorLevel);
		} catch (KBaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
