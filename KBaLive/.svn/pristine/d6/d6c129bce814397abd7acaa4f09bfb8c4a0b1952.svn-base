package com.kba.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kba.entity.LiveContent;
import com.kba.service.IIndexService;
import com.kba.service.impl.IndexService;
import com.kba.util.KBaException;
import com.kba.vo.LiveRoomDetailInfo;
/**
 * 直播内容页面ServLet
 * @author 钟强
 * 时间：2019-1-26
 */
public class LiveContentPageServlet extends KBaBaseServlet {

	private static final long serialVersionUID = 1L;

	private IIndexService indexService;
	
	public LiveContentPageServlet(){
		indexService=new IndexService();
	}
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	this.initLeftAllLiveType(req, resp, indexService);
			this.initLiveContentPage(req, resp);
			 req.getRequestDispatcher("live-specific.jsp").forward(req, resp);
		} catch (KBaException e) {
		    this.toError(e, resp);
		}  
	}

	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}

	/**
	 * 初始化所有直播房间通过具体的直播内容iD
	 * @param req
	 * @param resp
	 * @throws KBaException 
	 * @throws IOException 
	 */
	public void initLiveContentPage(HttpServletRequest req, HttpServletResponse resp) throws KBaException{
		HttpSession session=this.getSession();
		List<LiveRoomDetailInfo> allSpecificLiveRoomDetailInfos=null;
		LiveContent liveContent=spwan(req);
		liveContent=indexService.selectSingleLiveContent(liveContent);
		session.setAttribute("liveContent", liveContent);
		allSpecificLiveRoomDetailInfos=indexService.selectAllByLiveCotentId(liveContent);
		session.setAttribute("allSpecificLiveRoomDetailInfos", allSpecificLiveRoomDetailInfos);
	}	
	
	private LiveContent spwan(HttpServletRequest req){
		LiveContent liveContent=new LiveContent();
		String liveTypeId=req.getParameter("liveContentId");
		liveContent.setLiveContentId(liveTypeId);
		return liveContent;
	}
	
}
