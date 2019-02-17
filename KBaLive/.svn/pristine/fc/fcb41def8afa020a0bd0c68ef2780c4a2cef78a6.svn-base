package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.GagInfo;
import com.kba.service.IBackStageGagInfoService;
import com.kba.service.impl.BackStageGagInfoService;
import com.kba.util.KBaException;
/**
 * 后台响应查询主播禁言记录
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageGagInfoServlet extends KBaBaseServlet{
	private static final long serialVersionUID = 1L;
	 
	 private IBackStageGagInfoService backStageGagInfoService;
	
	 public BackStageGagInfoServlet() {
		 this.backStageGagInfoService=new BackStageGagInfoService();
	 }
	
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		GagInfo record=null;
		List<GagInfo> records=null;
		try {
			records=backStageGagInfoService.selectAll(record);
			System.out.println(records.toString());
			req.setAttribute("gaginfos", records);
			req.getRequestDispatcher("gag-info.jsp").forward(req, resp);
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
