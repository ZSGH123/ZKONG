package com.kba.vo;

import com.kba.entity.AnchorInfo;
import com.kba.entity.LiveContent;
import com.kba.entity.LiveRoom;
import com.kba.entity.LiveType;
import com.kba.entity.PushList;
import com.kba.entity.UserInfo;

/**
 * 直播房间信息细节
 * @author 钟强
 * 创建时间：2019-01-22 
 * 修改时间：
 * @author 钟强 创建时间：2019-01-22 修改时间
 */
public class LiveRoomDetailInfo {
	private LiveRoom liveRoom; //直播间信息
	private AnchorInfo anchorInfo;//主播信息
	private UserInfo userInfo;//用户信息
	private LiveContent liveContent;//直播内容
	private LiveType liveType;//直播类型
	private PushList pushList;//推送类型
	public LiveRoom getLiveRoom() {
		return liveRoom;
	}
	public void setLiveRoom(LiveRoom liveRoom) {
		this.liveRoom = liveRoom;
	}
	public AnchorInfo getAnchorInfo() {
		return anchorInfo;
	}
	public void setAnchorInfo(AnchorInfo anchorInfo) {
		this.anchorInfo = anchorInfo;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public LiveContent getLiveContent() {
		return liveContent;
	}
	public void setLiveContent(LiveContent liveContent) {
		this.liveContent = liveContent;
	}
	public LiveType getLiveType() {
		return liveType;
	}
	public void setLiveType(LiveType liveType) {
		this.liveType = liveType;
	}
	
	public PushList getPushList() {
		return pushList;
	}
	public void setPushList(PushList pushList) {
		this.pushList = pushList;
	}
	@Override
	public String toString() {
		return "直播间详细细节 [直播间=" + liveRoom + ", 主播信息=" + anchorInfo + ", 用户信息=" + userInfo
				+ ", 制播类容=" + liveContent +", 推送列表=" + pushList + ", 直播类型=" + liveType + "]";
	}
	
	
}
