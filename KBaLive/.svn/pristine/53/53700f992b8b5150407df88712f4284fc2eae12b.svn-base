package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.TransformRecord;
import com.kba.service.IBackStageTransformRecordService;
import com.kba.service.impl.BackStageTransformRecordService;
import com.kba.util.KBaException;

/**
 * 响应后台查询主播收益兑换记录
 * @author 单杰
 * 时间：2019-1-24
 */

public class BackStageTransformRecordServlet extends KBaBaseServlet{
	private static final long serialVersionUID = 1L;
	 
	 private IBackStageTransformRecordService backStageTransformRecordService;
	
	 public BackStageTransformRecordServlet() {
		 this.backStageTransformRecordService=new BackStageTransformRecordService();
	 }

	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TransformRecord record=null;
		List<TransformRecord> records=null;
		try {
			records=backStageTransformRecordService.selectAll(record);
			req.setAttribute("transformrecords", records);
			req.getRequestDispatcher("transform-record.jsp").forward(req, resp);
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
