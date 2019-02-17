package com.kba.entity;

import java.util.Date;

/**
 * 弹幕信息表
 * @author 赵科
 * 时间：2019-1-13
 */
public class BarrageInfo {

	private String barrageId;   //弹幕编号
	private String barrageContent; //弹幕内容
	private Date barrageSendTime;  //弹幕发送时间
	private String videoId;    //视频编号
	private String userId;     //用户编号
	private int nowVideoDuration; //当前视频播放秒数
	@Override
	public String toString() {
		return "弹幕信息 [弹幕编号=" + barrageId + ", 弹幕内容=" + barrageContent + ", 弹幕发送时间="
				+ barrageSendTime + ", 视频编号=" + videoId + ", 用户编号=" + userId + ", 当前视频播放秒数="
				+ nowVideoDuration + ", toString()=" + super.toString() + "]";
	}
	public String getBarrageId() {
		return barrageId;
	}
	public void setBarrageId(String barrageId) {
		this.barrageId = barrageId;
	}
	public String getBarrageContent() {
		return barrageContent;
	}
	public void setBarrageContent(String barrageContent) {
		this.barrageContent = barrageContent;
	}
	public Date getBarrageSendTime() {
		return barrageSendTime;
	}
	public void setBarrageSendTime(Date barrageSendTime) {
		this.barrageSendTime = barrageSendTime;
	}
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getNowVideoDuration() {
		return nowVideoDuration;
	}
	public void setNowVideoDuration(int nowVideoDuration) {
		this.nowVideoDuration = nowVideoDuration;
	}
}
