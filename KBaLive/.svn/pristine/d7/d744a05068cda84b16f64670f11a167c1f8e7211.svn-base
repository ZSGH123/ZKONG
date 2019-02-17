package com.kba.action.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.kba.action.session.KBaSessionContext;
/**
 * session监听器
 * @author 钟强 创建时间：2019-01-19 修改时间：
 */
public class KBaSessionListener implements HttpSessionListener {
     /**
      * 存储所有会话对象
      */
	 private KBaSessionContext sessionContext;
	 /**
	  * 活动的会话数
	  */
	 private int activeSessions = 0;
	 
	 public KBaSessionListener(){
		 sessionContext=KBaSessionContext.getSessionContext();
	 }
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		activeSessions++;
		sessionContext.addSession(event.getSession());
		System.out.println("用户"+activeSessions+"上线");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		if(activeSessions>0){
			activeSessions--;
		}
		sessionContext.delSession(event.getSession());
		System.out.println("用户下线");
	}
    
	public int getActiveSession(){
		return activeSessions;
	}
}
