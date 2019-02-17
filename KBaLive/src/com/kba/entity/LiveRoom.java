package com.kba.entity;

/**
 * 实体类：直播间信息
 * @author 杨智能
 * 时间：2019-1-13
 *
 */

public class LiveRoom {
	
	

	private String liveRoomId; //直播间编号
	
	private String anchorId; //主播编号
	
	private String livePushAddress;//直播推流地址
	
	private String liveContentId;//直播内容编号
	
	private String livePushCode;//直播推流码
	
	private String liveRoomAnnouncement;//直播间公告
	
	private String liveRoomTilie;//直播间标题
	
	private int liveRoomScore;//直播间分数
	
	private String syncToWeibo;//同步到微博
	
	private String liveRoomRemark;//直播间备注
	public String getLiveRoomId() {
		return liveRoomId;
	}

	public void setLiveRoomId(String liveRoomId) {
		this.liveRoomId = liveRoomId;
	}

	public String getAnchorId() {
		return anchorId;
	}

	public void setAnchorId(String anchorId) {
		this.anchorId = anchorId;
	}

	public String getLivePushAddress() {
		return livePushAddress;
	}

	public void setLivePushAddress(String livePushAddress) {
		this.livePushAddress = livePushAddress;
	}

	public String getLiveContentId() {
		return liveContentId;
	}

	public void setLiveContentId(String liveContentId) {
		this.liveContentId = liveContentId;
	}

	public String getLivePushCode() {
		return livePushCode;
	}

	public void setLivePushCode(String livePushCode) {
		this.livePushCode = livePushCode;
	}

	public String getLiveRoomAnnouncement() {
		return liveRoomAnnouncement;
	}

	public void setLiveRoomAnnouncement(String liveRoomAnnouncement) {
		this.liveRoomAnnouncement = liveRoomAnnouncement;
	}

	public String getLiveRoomTilie() {
		return liveRoomTilie;
	}

	public void setLiveRoomTilie(String liveRoomTilie) {
		this.liveRoomTilie = liveRoomTilie;
	}

	

	public int getLiveRoomScore() {
		return liveRoomScore;
	}

	public void setLiveRoomScore(int liveRoomScore) {
		this.liveRoomScore = liveRoomScore;
	}

	public String getSyncToWeibo() {
		return syncToWeibo;
	}

	public void setSyncToWeibo(String syncToWeibo) {
		this.syncToWeibo = syncToWeibo;
	}

	public String getLiveRoomRemark() {
		return liveRoomRemark;
	}

	public void setLiveRoomRemark(String liveRoomRemark) {
		this.liveRoomRemark = liveRoomRemark;
	}

	@Override
	public String toString() {
		return "直播间信息 [直播间编号=" + liveRoomId + ", 主播编号=" + anchorId + ", 直播推流地址=" + livePushAddress
				+ ", 直播内容编号=" + liveContentId + ", 直播推流码=" + livePushCode + ", 直播间公告="
				+ liveRoomAnnouncement + ", 直播间标题=" + liveRoomTilie + ", 直播间分数=" + liveRoomScore
				+ ", 同步到微博=" + syncToWeibo + ", 直播间备注=" + liveRoomRemark + "]";
	}
	
	
}
