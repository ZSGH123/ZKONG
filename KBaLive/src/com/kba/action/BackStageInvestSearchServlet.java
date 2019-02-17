package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.BackStageManagerInfo;
import com.kba.entity.InvestRecord;
import com.kba.service.IInvestRecordService;
import com.kba.service.impl.InvestRecordService;
import com.kba.util.KBaException;

/**
 * 响应后台充值记录查询 
 * @author 单杰
 * 时间：2019-1-22
 */

 public class BackStageInvestSearchServlet extends KBaBaseServlet {
		
	 private static final long serialVersionUID = 1L;
	 
	 private IInvestRecordService investrecordService;
	
	 public BackStageInvestSearchServlet() {
		 this.investrecordService=new InvestRecordService();
	 }
	 
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		InvestRecord record=null;
		List<InvestRecord> records=null;
		try {
			records=investrecordService.selectAllRecord(record);
			req.setAttribute("investrecords", records);
			req.getRequestDispatcher("invest-record-search.jsp").forward(req, resp);
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