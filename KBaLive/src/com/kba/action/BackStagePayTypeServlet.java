package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.AnchorLevel;
import com.kba.entity.PayType;
import com.kba.service.impl.BackStagePayTypeService;
import com.kba.util.KBaException;
/**
 * 响应后台支付类型设置
 * @author 单杰 
 * 时间：2019-1-25
 */
public class BackStagePayTypeServlet extends KBaBaseServlet{
	private static final long serialVersionUID = 1L;
    //礼物信息业务对象
	private BackStagePayTypeService payTypeService;
	
    public BackStagePayTypeServlet() {
		this.payTypeService=new BackStagePayTypeService();
	}
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<PayType> payTypes=null;
		PayType payType=this.wrap(req);
		try {
			payTypes=payTypeService.selectAllPayType(payType);
			req.removeAttribute("payTypes");
			req.setAttribute("payTypes", payTypes);
			req.getRequestDispatcher("pay-type-set.jsp").forward(req, resp);
		} catch (KBaException e) {
			toError(e, resp);
		}
	}
	/**
	 * 新增支付类型
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void insertPayType(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		//封装数据
		PayType payType=this.wrap(req);
		try {
			//插入数据
			payType=payTypeService.insertPayType(payType);
			if(payType!=null){
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
	 * 删除支付类型
	 */
	public void delete(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
				//out对象
				PrintWriter out=resp.getWriter();
				PayType payType=this.wrap(req);
				System.out.println(payType);
				try {
					//删除支付类型
					payType=payTypeService.deletePayType(payType);
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
		PayType payType=this.wrap(req);
		try {
			payType=payTypeService.selectPayTypeById(payType);
			System.out.println(payType);
			if(payType!=null){
				session.setAttribute("updateOfPayType", payType);
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
	 * 通过等级名称检查等级是否存在
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void checkPayTypeByName(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException, KBaException{
		PrintWriter out=resp.getWriter();
		//封装请求包主播等级数据
		PayType payType=this.wrap(req);
	    try {
			boolean has=payTypeService.checkPayTypeByName(payType);
			if(has){
				out.print("支付类型已存在");
			}else{
				out.print(true);
			}
		}finally{
			out.close();
		}
	}
	
	/**
	 * 取消修改session对象中的支付类型
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void quXiao(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=this.getSession();
		session.removeAttribute("updateOfPayType");
		out.print(true);
	}
	
	/**
	 * 成功修改礼物信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	public void updatePayType(HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException{
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		PayType payType=this.wrap(req);
		try {
			payType=payTypeService.updatePayType(payType);
			session.removeAttribute("updateOfPayType");
			if(payType!=null){
				out.print(true);
			}else{
				out.print(false);
			}
		} catch (KBaException e) {
			e.printStackTrace();
		}
	}
	
	private PayType wrap(HttpServletRequest req) {
		PayType payType=new PayType();
		String pId=req.getParameter("payTypeId");
		String pName=req.getParameter("payTypeName");
		String pRemark=req.getParameter("payTypeRemark");
		
		payType.setPayTypeId(pId);;
		payType.setPayTypeName(pName);
		payType.setPayTypeRemark(pRemark);
		return payType;
	}


	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	

}