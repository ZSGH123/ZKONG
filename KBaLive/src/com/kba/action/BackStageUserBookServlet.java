package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kba.entity.UserBook;
import com.kba.service.IBackStageUserBookService;
import com.kba.service.impl.BackStageUserBookService;
import com.kba.util.KBaException;

/**
 * 后台响应订阅查询
 * @author 单杰
 * 时间：2019-1-23
 */
public class BackStageUserBookServlet extends KBaBaseServlet{
	private static final long serialVersionUID = 1L;
	 
	 private IBackStageUserBookService backStageUserBookService;
	
	 public BackStageUserBookServlet() {
		 this.backStageUserBookService=new BackStageUserBookService();
	 }
	
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserBook record=null;
		List<UserBook> records=null;
		try {
			records=backStageUserBookService.selectAllBook(record);
			req.setAttribute("userbooks", records);
			req.getRequestDispatcher("user-book.jsp").forward(req, resp);
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
