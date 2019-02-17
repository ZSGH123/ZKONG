package com.kba.vo;

import java.util.List;

import com.kba.entity.PushType;

/**
 * 供c:foreach标签使用
 * @author 钟强
 * 创建时间：2019-01-13
 * 修改时间：
 */
public class LiveRoomsInfo {
   /**
	* 推送的所有直播房间信息
    */
  private PushType pushType;
	
  /**
   * 推送的所有直播房间信息
   */
  private List<LiveRoomDetailInfo> pushliveRoomDetailInfos;
  /**
   * 与推送内容相关的所有直播房间信息
   */
  private List<LiveRoomDetailInfo> liveRoomDetailInfos=null;
  /**
   * 额外的直播房间信息
   */
  private List<LiveRoomDetailInfo> extraliveRoomDetailInfos=null;
public PushType getPushType() {
	return pushType;
}
public void setPushType(PushType pushType) {
	this.pushType = pushType;
}
public List<LiveRoomDetailInfo> getPushliveRoomDetailInfos() {
	return pushliveRoomDetailInfos;
}
public void setPushliveRoomDetailInfos(List<LiveRoomDetailInfo> pushliveRoomDetailInfos) {
	this.pushliveRoomDetailInfos = pushliveRoomDetailInfos;
}
public List<LiveRoomDetailInfo> getLiveRoomDetailInfos() {
	return liveRoomDetailInfos;
}
public void setLiveRoomDetailInfos(List<LiveRoomDetailInfo> liveRoomDetailInfos) {
	this.liveRoomDetailInfos = liveRoomDetailInfos;
}
public List<LiveRoomDetailInfo> getExtraliveRoomDetailInfos() {
	return extraliveRoomDetailInfos;
}
public void setExtraliveRoomDetailInfos(List<LiveRoomDetailInfo> extraliveRoomDetailInfos) {
	this.extraliveRoomDetailInfos = extraliveRoomDetailInfos;
}
@Override
public String toString() {
	return "所有推送版块的直播间信息 [推送类型=" + pushType + ", 所有正在推送列表中的所有房间信息=" + pushliveRoomDetailInfos
			+ ", 所有与该推送内容相关的所有房间信息=" + liveRoomDetailInfos + ", 额外的直播房间信息=" + extraliveRoomDetailInfos
			+ "]";
}
  
  
}
