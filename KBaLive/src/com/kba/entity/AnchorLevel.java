package com.kba.entity;

/**
 * 主播等级表
 * @author 赵科
 * 时间：2019-1-13
 */
public class AnchorLevel {

	private String anchorLevelId;  //主播等级编号
	private String anchorLevelName;  //主播等级名称
	private int liveMinTotalTime; //直播最短总时长
	private int liveMaxTotalTime; //直播最大总时长
	private String anchorLevelRemark; //主播等级备注
	public String getAnchorLevelId() {
		return anchorLevelId;
	}
	public void setAnchorLevelId(String anchorLevelId) {
		this.anchorLevelId = anchorLevelId;
	}
	@Override
	public String toString() {
		return "主播等级 [主播等级编号=" + anchorLevelId + ", 主播等级名称=" + anchorLevelName
				+ ", 直播最短总时长=" + liveMinTotalTime + ", 直播最大总时长=" + liveMaxTotalTime
				+ ", 主播等级备注=" + anchorLevelRemark + ", toString()=" + super.toString() + "]";
	}
	public String getAnchorLevelName() {
		return anchorLevelName;
	}
	public void setAnchorLevelName(String anchorLevelName) {
		this.anchorLevelName = anchorLevelName;
	}
	public int getLiveMinTotalTime() {
		return liveMinTotalTime;
	}
	public void setLiveMinTotalTime(int liveMinTotalTime) {
		this.liveMinTotalTime = liveMinTotalTime;
	}
	public int getLiveMaxTotalTime() {
		return liveMaxTotalTime;
	}
	public void setLiveMaxTotalTime(int liveMaxTotalTime) {
		this.liveMaxTotalTime = liveMaxTotalTime;
	}
	public String getAnchorLevelRemark() {
		return anchorLevelRemark;
	}
	public void setAnchorLevelRemark(String anchorLevelRemark) {
		this.anchorLevelRemark = anchorLevelRemark;
	}
}
