package com.kba.entity;

import java.util.Date;

/**
 * 实体类：主播信息
 * @author 赵科
 * 时间：2019-1-13
 */
public class AnchorInfo {

	private String anchorId; //主播编号
	private String userId;   //用户编号
	private String liveRoomId; //直播间编号
	private Date registeredAnchorTime; //主播注册时间
	private String anchorInfoRemark;  //主播信息备注
	public String getAnchorId() {
		return anchorId;
	}
	@Override
	public String toString() {
		return "主播信息 [主播编号=" + anchorId + ", 用户编号=" + userId + ", 直播间编号=" + liveRoomId
				+ ", 主播注册事件=" + registeredAnchorTime + ", 主播信息备注=" + anchorInfoRemark
				+ ", toString()=" + super.toString() + "]";
	}
	public void setAnchorId(String anchorId) {
		this.anchorId = anchorId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLiveRoomId() {
		return liveRoomId;
	}
	public void setLiveRoomId(String liveRoomId) {
		this.liveRoomId = liveRoomId;
	}
	public Date getRegisteredAnchorTime() {
		return registeredAnchorTime;
	}
	public void setRegisteredAnchorTime(Date registeredAnchorTime) {
		this.registeredAnchorTime = registeredAnchorTime;
	}
	public String getAnchorInfoRemark() {
		return anchorInfoRemark;
	}
	public void setAnchorInfoRemark(String anchorInfoRemark) {
		this.anchorInfoRemark = anchorInfoRemark;
	}
}
