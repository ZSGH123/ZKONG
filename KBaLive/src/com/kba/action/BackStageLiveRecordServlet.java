package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.LiveRecord;
import com.kba.service.IBackStageLiveRecordService;
import com.kba.service.impl.BackStageLiveRecordService;
import com.kba.util.KBaException;
/**
 * 后台响应查询主播直播记录
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageLiveRecordServlet extends KBaBaseServlet {
	private static final long serialVersionUID = 1L;
	 
	 private IBackStageLiveRecordService backStageLiveRecordService;
	
	 public BackStageLiveRecordServlet() {
		 this.backStageLiveRecordService=new BackStageLiveRecordService();
	 }

	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LiveRecord record=null;
		List<LiveRecord> records=null;
		try {
			records=backStageLiveRecordService.selectAllRecord(record);
			req.setAttribute("liverecords", records);
			req.getRequestDispatcher("live-record.jsp").forward(req, resp);
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
