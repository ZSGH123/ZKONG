package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.UserGiftRecord;
import com.kba.service.impl.BackStageUserGiftRecordService;
import com.kba.util.KBaException;

/**
 * 响应后台赠礼记录查询
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageUserGiftRecordServlet extends KBaBaseServlet {
	
	private static final long serialVersionUID = 1L;
	 
	 private BackStageUserGiftRecordService backStageUserGiftRecordService;
	
	 public BackStageUserGiftRecordServlet() {
		 this.backStageUserGiftRecordService=new BackStageUserGiftRecordService();
	 }
	 
	
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("1111");
		UserGiftRecord record=null;
		List<UserGiftRecord> records=null;
		try {
			records=backStageUserGiftRecordService.selectAll(record);
			System.out.println("2222");
			System.out.println(records);
			req.setAttribute("usergiftrecords", records);
			req.getRequestDispatcher("user-gift-record-search.jsp").forward(req, resp);
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