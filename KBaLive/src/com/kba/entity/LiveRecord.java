package com.kba.entity;

import java.util.Date;


/**
 * 直播纪录
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class LiveRecord {
    private String liveRecordId;//	直播记录编号
    private String userId;//用户编号
    private Date onLiveTime;//	开播时间
    private Date offLiveTime;//	关播时间
    private  String liveRecordRemark;//直播记录备注
	@Override
	public String toString() {
		return "直播记录[直播记录编号=" + liveRecordId + ", 用户编号=" + userId + ", 开播时间=" + onLiveTime
				+ ", 关播时间=" + offLiveTime + ", 直播记录备注=" + liveRecordRemark + "]";
	}
	public String getLiveRecordId() {
		return liveRecordId;
	}
	public void setLiveRecordId(String liveRecordId) {
		this.liveRecordId = liveRecordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Date getOnLiveTime() {
		return onLiveTime;
	}
	public void setOnLiveTime(Date onLiveTime) {
		this.onLiveTime = onLiveTime;
	}
	public Date getOffLiveTime() {
		return offLiveTime;
	}
	public void setOffLiveTime(Date offLiveTime) {
		this.offLiveTime = offLiveTime;
	}
	public String getLiveRecordRemark() {
		return liveRecordRemark;
	}
	public void setLiveRecordRemark(String liveRecordRemark) {
		this.liveRecordRemark = liveRecordRemark;
	}
    
    
}
