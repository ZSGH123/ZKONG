package com.kba.entity;

public class UserProperty {

	public String userPropertyId; //用户钱包编号
	public String userId;//用户编号
	public String kTypeId;//k币数量编号
	public int kNumber;//k币数量
	public String  userPropertyRemark;//钱包备注
	public String getUserPropertyId() {
		return userPropertyId;
	}
	public void setUserPropertyId(String userPropertyId) {
		this.userPropertyId = userPropertyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "用户钱包 [用户钱包编号=" + userPropertyId
				+ ", 用户编号=" + userId + ", k币数量编号=" + kTypeId + ", k币数量="
				+ kNumber + ", 钱包备注=" + userPropertyRemark + "]";
	}
	public String getkTypeId() {
		return kTypeId;
	}
	public void setkTypeId(String kTypeId) {
		this.kTypeId = kTypeId;
	}
	public int getkNumber() {
		return kNumber;
	}
	public void setkNumber(int kNumber) {
		this.kNumber = kNumber;
	}
	public String getUserPropertyRemark() {
		return userPropertyRemark;
	}
	public void setUserPropertyRemark(String userPropertyRemark) {
		this.userPropertyRemark = userPropertyRemark;
	}
}
