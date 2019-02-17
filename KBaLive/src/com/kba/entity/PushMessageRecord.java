package com.kba.entity;

import java.util.Date;

/**
 * 推送消息记录
 * @author 杨智能
 *时间：2019-1-13
 */
public class PushMessageRecord {

	private String pushMessageRecordId;//推送消息记录编号
	
	private String liveRoomId;//直播间编号
	
	private String pushTypeId;//推送类型编号
	
	private int pushDuration;//推送时长
	
	private int pushMessageResult;//推送消息结果
	
	private Date pushMessageTime;//推送时间
	
	private String pushMessageRecordRemark;//推送消息记录备注
	
	public String getPushMessageRecordId() {
		return pushMessageRecordId;
	}

	public void setPushMessageRecordId(String pushMessageRecordId) {
		this.pushMessageRecordId = pushMessageRecordId;
	}

	public String getLiveRoomId() {
		return liveRoomId;
	}

	public void setLiveRoomId(String liveRoomId) {
		this.liveRoomId = liveRoomId;
	}

	public String getPushTypeId() {
		return pushTypeId;
	}

	public void setPushTypeId(String pushTypeId) {
		this.pushTypeId = pushTypeId;
	}

	public int getPushDuration() {
		return pushDuration;
	}

	public void setPushDuration(int pushDuration) {
		this.pushDuration = pushDuration;
	}

	public int getPushMessageResult() {
		return pushMessageResult;
	}

	public void setPushMessageResult(int pushMessageResult) {
		this.pushMessageResult = pushMessageResult;
	}

	public Date getPushMessageTime() {
		return pushMessageTime;
	}

	public void setPushMessageTime(Date pushMessageTime) {
		this.pushMessageTime = pushMessageTime;
	}

	public String getPushMessageRecordRemark() {
		return pushMessageRecordRemark;
	}

	public void setPushMessageRecordRemark(String pushMessageRecordRemark) {
		this.pushMessageRecordRemark = pushMessageRecordRemark;
	}

	@Override
	public String toString() {
		return "推送消息记录 [推送消息记录编号=" + pushMessageRecordId + ", 直播间编号=" + liveRoomId
				+ ", 推送类型编号=" + pushTypeId + ", 推送时长=" + pushDuration + ", 推送消息结果="
				+ pushMessageResult + ", 推送时间=" + pushMessageTime + ", 推送消息记录备注="
				+ pushMessageRecordRemark + "]";
	}
	
	
	
}
