package com.kba.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONArray;
import com.kba.entity.LiveContent;
import com.kba.entity.LiveType;
import com.kba.service.IIndexService;
import com.kba.service.impl.IndexService;
import com.kba.util.KBaException;
import com.kba.vo.LiveRoomDetailInfo;

/**
 * 直播页面servlet
 * @author 钟强
 * 时间：2019-1-26
 */
public class LiveIndexServlet extends KBaBaseServlet {

	private static final long serialVersionUID = 1L;
	
	private IIndexService indexService;
	
	public LiveIndexServlet(){
		indexService=new IndexService();
	}
	
	@Override
	protected void service_(String command, HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	}
	/**
	 * 去直播页面首页
	 */
	@Override
	protected void index(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			this.initPushRooms(req,resp);
			this.initLeftAllLiveType(req,resp,indexService);
			this.initAllRooms(req,resp);
			req.getRequestDispatcher("liveindex.jsp").forward(req, resp);
		} catch (KBaException e) {
			this.toError(e, resp);
		}	
	}
    
	/**
	 * 去某一直播类型的首页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toLiveTypeIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=this.getSession();
	    LiveType liveType=this.spwan(req);
	    List<LiveRoomDetailInfo> allLiveTypeLiveRoomDetailInfos=null;
	    try {
			liveType=indexService.selectSingleLiveType(liveType);
			session.setAttribute("singleLiveType", liveType);
			allLiveTypeLiveRoomDetailInfos=indexService.selectAllByLiveTypeID(liveType);
			session.setAttribute("allLiveTypeLiveRoomDetailInfos", allLiveTypeLiveRoomDetailInfos);
			req.getRequestDispatcher("live-type.jsp").forward(req, resp);
		} catch (KBaException e) {
			this.toError(e, resp);
		}

	}
	
	/**
	 * 去所有直播类型的首页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void toAllLiveTypeIndex(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=this.getSession();
		List<LiveType> liveTypes=null;
		List<LiveContent> liveContents=null;
	    try {
			liveTypes=indexService.selectAllLiveType(null);
			session.setAttribute("allLiveType", liveTypes);
			liveContents=indexService.selectAllLiveContent(null);
			session.setAttribute("allliveContents", liveContents);
			req.getRequestDispatcher("all-live-type.jsp").forward(req, resp);
		} catch (KBaException e) {
			this.toError(e, resp);
		}

	}
	
	/**
	 * 根据直播类型id查询相应所有直播内容
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectLiveContentByTypeId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter out=resp.getWriter();
		LiveContent liveContent=new LiveContent();
		liveContent.setLiveTypeId(req.getParameter("liveTypeId"));
		List<LiveContent> liveContents=null;
	    try {
	    	liveContents=indexService.selectByLiveType(liveContent);
	    	out.print(aliParseJson(liveContents));
		} catch (KBaException e) {
			this.toError(e, resp);
		}
	}
	
	/**
	 * 根据直播类型id查询相应所有直播房间信息
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void selectRoomByLiveTypeID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter out=resp.getWriter();
		LiveType liveType=this.spwan(req);

		List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
	    try {
	    	liveRoomDetailInfos=indexService.selectAllByLiveTypeID(liveType);
	    	if(liveType.getLiveTypeId().equals("0")){
	    		liveRoomDetailInfos=indexService.queryAllLiveRoomDetailInfo();
	    	}
	    	out.print(parseJson(liveRoomDetailInfos));
		} catch (KBaException e) {
			this.toError(e, resp);
		}
	}
	
	/**
     * 阿里json工具
     * 把集合List<LiveRoomDetailInfo>转化为json
     * @param products
     * @return
     */
    private String parseJson(List<LiveRoomDetailInfo> liveRoomDetailInfos) {
    	String json=JSONArray.toJSONString(liveRoomDetailInfos);
		json="{\"liveRoomDetailInfos\":"+json+"}";
		System.out.println(json);
		return json;
	}

	/**
     * 阿里json工具
     * 把集合List<LiveContent>转化为json
     * @param products
     * @return
     */
    private String aliParseJson(List<LiveContent> liveContents) {
		String json=JSONArray.toJSONString(liveContents);
		json="{\"liveContents\":"+json+"}";
		System.out.println(json);
		return json;
	}
	/**
	 * 初始化所有直播房间
	 * @param req
	 * @param resp
	 * @throws KBaException 
	 */
	private void initAllRooms(HttpServletRequest req, HttpServletResponse resp) throws KBaException  {
		HttpSession session=this.getSession();
		List<LiveRoomDetailInfo> allLiveRoomDetailInfos=null;
		allLiveRoomDetailInfos=indexService.queryAllLiveRoomDetailInfo();
		session.setAttribute("allLiveRoomDetailInfos", allLiveRoomDetailInfos);	
	}
	
	/**
	 * 初始化所有推送直播房间
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws KBaException 
	 */
	private void initPushRooms(HttpServletRequest req, HttpServletResponse resp) throws  KBaException {
		HttpSession session=this.getSession();
		List<LiveRoomDetailInfo> allPushLiveRoomDetailInfos=null;
		allPushLiveRoomDetailInfos=indexService.selectAllAllPushRoom(null);
		session.setAttribute("allPushLiveRoomDetailInfos", allPushLiveRoomDetailInfos);	
	}
	
	private LiveType spwan(HttpServletRequest req){
		LiveType liveType=new LiveType();
		liveType.setLiveTypeId(req.getParameter("liveTypeId"));
		return liveType;
	}
}
