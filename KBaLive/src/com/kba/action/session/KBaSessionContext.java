package com.kba.action.session;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.kba.entity.UserInfo;

/**
 * map以<SessionId,Session>的方式装所有的Session
 * 
 * @author 钟强 创建时间：2019-01-13 修改时间：
 */
public class KBaSessionContext {

	private static KBaSessionContext sessionContext;

	private Map<String, HttpSession> map;

	private KBaSessionContext() {
		map = new HashMap<>();
	}

	public synchronized static KBaSessionContext getSessionContext() {
		if (sessionContext == null) {
			sessionContext = new KBaSessionContext();
		}
		return sessionContext;
	}

	/**
	 * 添加session
	 * 
	 * @param session
	 */
	public synchronized void addSession(HttpSession session) {
		if (session != null)
			map.put(session.getId(), session);
	}

	/**
	 * 获取session
	 * 
	 * @param sessionId
	 * @return
	 */
	public synchronized HttpSession getSession(String sessionId) {
		if (sessionId == null)
			return null;
		return map.get(sessionId);
	}

	/**
	 * 获取session通过用户id
	 * 
	 * @param sessionId
	 * @return
	 */
	public synchronized HttpSession getSessionById(String userId) {
		if(userId==null)return null;
		Collection<HttpSession> sessions=map.values();
		for (HttpSession httpSession : sessions) {
			UserInfo user=(UserInfo) httpSession.getAttribute("loginUser");
			if(userId.equals(user.getUserId())){
				return httpSession;
			}	
		}
		return null;
	}
	
	/**
	 * 删除session
	 * 
	 * @param session
	 */
	public synchronized void delSession(HttpSession session) {
		if (session != null) {
			HttpSession removeSession = map.remove(session.getId());
			if (removeSession != null) {
				removeSession.invalidate();
			}
		}
	}

}
