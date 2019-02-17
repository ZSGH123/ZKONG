package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.AnchorLevel;
import com.kba.entity.KType;
import com.kba.service.impl.BackStageKTypeService;
import com.kba.util.KBaException;

public class BackStageKTypeServlet extends KBaBaseServlet{
	private static final long serialVersionUID = 1L;
    //礼物信息业务对象
	private BackStageKTypeService kTypeService;
	
    public BackStageKTypeServlet() {
		this.kTypeService=new BackStageKTypeService();
	}
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<KType> kTypes=null;
		KType kType=this.wrap(req);
		try {
			kTypes=kTypeService.selectAllKType(kType);
			req.removeAttribute("kTypes");
			req.setAttribute("kTypes", kTypes);
			req.getRequestDispatcher("k-type-set.jsp").forward(req, resp);
		} catch (KBaException e) {
			toError(e, resp);
		}
		
	}
	
	/**
	 * 通过类型名称检查K币类型是否存在
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkKTypeByName(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装请求包主播等级数据
		KType kType=this.wrap(req);
	    try {
			boolean has=kTypeService.checkKTypeByName(kType);
			if(has){
				out.print("k币类型已存在");
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
	 * 新增k币类型
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertKType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装数据
		KType kType=this.wrap(req);
		try {
			//插入数据
			System.out.println(kType);
			kType=kTypeService.insertKType(kType);
			if(kType!=null){
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
	 * 删除k币类型
	 */
	public void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
				//out对象
				PrintWriter out=resp.getWriter();
				KType kType=this.wrap(req);
				try {
					//删除k币
					kType=kTypeService.deleteKType(kType);
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
		KType kType=this.wrap(req);
		try {
			kType=kTypeService.selectKTypeById(kType);
			if(kType!=null){
				session.setAttribute("updateOfKType", kType);
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
	 * 取消修改session对象中的礼物信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void quXiao(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=this.getSession();
		session.removeAttribute("updateOfKType");
		out.print(true);
	}
	
	/**
	 * 成功修改k币
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updateKType(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		KType kType=this.wrap(req);
		System.out.println(kType);
		try {
			kType=kTypeService.updateKType(kType);
			session.removeAttribute("updateOfKType");
			if(kType!=null){
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (KBaException e) {
			e.printStackTrace();
		}
	}
	
	private KType wrap(HttpServletRequest req) {
		KType kType=new KType();
		String kId=req.getParameter("kTypeId");
		String kName=req.getParameter("kTypeName");
		String kERate=req.getParameter("kExchangeRate");
		Double kTExchangeRate=kERate!=null?Double.parseDouble(kERate):0;
		String kWRate=req.getParameter("kWithdrawRate");
		Double kTWithdrawRate=kWRate!=null?Double.parseDouble(kWRate):0;
		
		
		kType.setkTypeId(kId);
		kType.setkTypeName(kName);
		kType.setkExchangeRate(kTExchangeRate);
		kType.setkWithdrawRate(kTWithdrawRate);
		return kType;
	}

	
	
	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
