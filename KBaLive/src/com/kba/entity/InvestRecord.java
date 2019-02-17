package com.kba.entity;

import java.util.Date;

/**
 * 充值记录
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class InvestRecord {
//	充值记录编号	invest_record_id	varchar2(10)
//	用户编号	user_id	varchar2(10)
//	K币类型编号	k_type_id	varchar2(5)
//	充值数量	invest_number	number
//	充值记录时间	invest_record_time	date
//	充值金额	invest_cash	number
//	支付类型编号	pay_type_id	varchar2(5)
//	充值记录备注	invest_record_remark	varchar2(200)
    
	private String	investRecordId;//充值记录编号
	private String	userId;//用户编号
	private String	kTypeId;//K币类型编号
	private int investNumber;//充值数量
	private Date investRecordTime;//充值记录时间
	private double investCashNumber;//充值金额
	private String	payTypeId;//支付类型编号
	private String investRecordRemark;//充值记录备注
	
	public String getInvestRecordId() {
		return investRecordId;
	}
	public void setInvestRecordId(String investRecordId) {
		this.investRecordId = investRecordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getkTypeId() {
		return kTypeId;
	}
	public void setkTypeId(String kTypeId) {
		this.kTypeId = kTypeId;
	}
	public int getInvestNumber() {
		return investNumber;
	}
	public void setInvestNumber(int investNumber) {
		this.investNumber = investNumber;
	}
	public Date getInvestRecordTime() {
		return investRecordTime;
	}
	public void setInvestRecordTime(Date investRecordTime) {
		this.investRecordTime = investRecordTime;
	}
	public double getInvestCashNumber() {
		return investCashNumber;
	}
	public void setInvestCashNumber(double investCashNumber) {
		this.investCashNumber = investCashNumber;
	}
	public String getPayTypeId() {
		return payTypeId;
	}
	public void setPayTypeId(String payTypeId) {
		this.payTypeId = payTypeId;
	}
	public String getInvestRecordRemark() {
		return investRecordRemark;
	}
	public void setInvestRecordRemark(String investRecordRemark) {
		this.investRecordRemark = investRecordRemark;
	}
	public String toString() {
		return "充值记录 [充值记录编号=" + investRecordId + ", 用户编号=" + userId + ", K币类型编号=" + kTypeId + ",充值数量="
				+ investNumber + ",充值记录时间=" + investRecordTime + ",充值金额=" +investCashNumber + ", 支付类型编号=" + payTypeId
				+ ",充值记录备注=" + investRecordRemark + "]";
	}
	
}
