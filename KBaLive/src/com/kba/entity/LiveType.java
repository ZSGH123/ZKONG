package com.kba.entity;

/**
 * 直播类型信息
 * @author 杨智能
 *时间：2019-1-13
 */
public class LiveType {

	
	private String liveTypeId;//直播类型编号
	
	private String liveTypeName;//直播类型名称
	
	private String liveTypeRemark;//直播类型备注
	public String getLiveTypeId() {
		return liveTypeId;
	}

	public void setLiveTypeId(String liveTypeId) {
		this.liveTypeId = liveTypeId;
	}

	public String getLiveTypeName() {
		return liveTypeName;
	}

	public void setLiveTypeName(String liveTypeName) {
		this.liveTypeName = liveTypeName;
	}

	public String getLiveTypeRemark() {
		return liveTypeRemark;
	}

	public void setLiveTypeRemark(String liveTypeRemark) {
		this.liveTypeRemark = liveTypeRemark;
	}

	@Override
	public String toString() {
		return "直播类型 [直播类型编号=" + liveTypeId + ", 直播类型名字=" + liveTypeName + ", 直播类型备注="
				+ liveTypeRemark + "]";
	}
	
}
