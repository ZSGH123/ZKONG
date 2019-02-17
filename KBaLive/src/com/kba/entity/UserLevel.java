package com.kba.entity;

/**
 * 实体类
 * @author 沈灵芝
 *时间：2019-1-13
 */
public class UserLevel {

	public String userLevelId;//用户等级编号
	public String userLevelName;//用户等级名称
	public int userLowInvest;//最低充值
	public int userHighInvest;//最高充值
	public String userLevelRemark;//用户等级备注 
	@Override
	public String toString() {
		return "用户等级表 [用户等级编号=" + userLevelId + ", 用户等级名称="
				+ userLevelName + ", 最低充值=" + userLowInvest
				+ ", 最高充值=" + userHighInvest
				+ ", 用户等级备注=" + userLevelRemark + "]";
	}
	public String getUserLevelId() {
		return userLevelId;
	}
	public void setUserLevelId(String userLevelId) {
		this.userLevelId = userLevelId;
	}
	public String getUserLevelName() {
		return userLevelName;
	}
	public void setUserLevelName(String userLevelName) {
		this.userLevelName = userLevelName;
	}
	public int getUserLowInvest() {
		return userLowInvest;
	}
	public void setUserLowInvest(int userLowInvest) {
		this.userLowInvest = userLowInvest;
	}
	public int getUserHighInvest() {
		return userHighInvest;
	}
	public void setUserHighInvest(int userHighInvest) {
		this.userHighInvest = userHighInvest;
	}
	public String getUserLevelRemark() {
		return userLevelRemark;
	}
	public void setUserLevelRemark(String userLevelRemark) {
		this.userLevelRemark = userLevelRemark;
	}

}
