package com.kba.entity;

/**
 * 支付类型信息
 * @author 杨智能
 *时间：2019-1-13
 */
public class PayType {

	private String payTypeId;//支付类型编号
	
	private String payTypeName;//支付类型名称
	
	private String payTypeRemark;//支付类型编号
	public String getPayTypeId() {
		return payTypeId;
	}

	public void setPayTypeId(String payTypeId) {
		this.payTypeId = payTypeId;
	}

	public String getPayTypeName() {
		return payTypeName;
	}

	public void setPayTypeName(String payTypeName) {
		this.payTypeName = payTypeName;
	}

	public String getPayTypeRemark() {
		return payTypeRemark;
	}

	public void setPayTypeRemark(String payTypeRemark) {
		this.payTypeRemark = payTypeRemark;
	}

	@Override
	public String toString() {
		return "支付类型 [支付类型编号=" + payTypeId + ", 支付类型名称=" + payTypeName + ", 支付类型备注=" + payTypeRemark
				+ "]";
	}
	
}
