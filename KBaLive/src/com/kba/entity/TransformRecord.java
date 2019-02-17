package com.kba.entity;

import java.util.Date;
/**
 * 礼物转K币记录
 * @author 单杰
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class TransformRecord {
	private String transformRecordId;//转换记录编号
	private String anchorId;//主播编号
	private String giftId;//礼物编号
	private int giftNum;//礼物数量
	private String kTypeId;//K币类型编号
	private int kNum;//K币数量
	private Date transformTime;//转换时间
	private String transformRecordRemark;//转换记录备注
	
	public String toString(){
		return "礼物转K币记录 [转换记录编号=" + transformRecordId + ",主播编号=" + anchorId + ",礼物编号=" + giftId + ",礼物数量=" + giftNum 
				+ ",K币类型编号=" + kTypeId + ",K币数量=" + kTypeId + ",转换时间=" + transformTime + ",转换记录备注=" + transformRecordRemark + "]";
	}
	
	public String getTransformRecordId() {
		return transformRecordId;
	}
	public void setTransformRecordId(String transformRecordId) {
		this.transformRecordId = transformRecordId;
	}
	public String getAnchorId() {
		return anchorId;
	}
	public void setAnchorId(String anchorId) {
		this.anchorId = anchorId;
	}
	public String getGiftId() {
		return giftId;
	}
	public void setGiftId(String giftId) {
		this.giftId = giftId;
	}
	public int getGiftNum() {
		return giftNum;
	}
	public void setGiftNum(int giftNum) {
		this.giftNum = giftNum;
	}
	public String getkTypeId() {
		return kTypeId;
	}
	public void setkTypeId(String kTypeId) {
		this.kTypeId = kTypeId;
	}
	public int getkNum() {
		return kNum;
	}
	public void setkNum(int kNum) {
		this.kNum = kNum;
	}
	public Date getTransformTime() {
		return transformTime;
	}
	public void setTransformTime(Date transformTime) {
		this.transformTime = transformTime;
	}
	public String getTransformRecordRemark() {
		return transformRecordRemark;
	}
	public void setTransformRecordRemark(String transformRecordRemark) {
		this.transformRecordRemark = transformRecordRemark;
	}
}
