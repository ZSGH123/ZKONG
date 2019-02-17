package com.kba.vo;
/**
 * 用户关注
 * @author 墨迹
 *目的：解决查询匹配麻烦
 */
public class UserLike {
	private String userId;//用户id
	private String liveRoomId;//直播间id
	private String live_room_title;//直播间标题
	private String live_room_remark;//直播间备注（图片）
	private String user_name;//主播名
	
	
	
	
	@Override
	public String toString() {
		return "UserLike [userId=" + userId + ", liveRoomId=" + liveRoomId + ", live_room_title=" + live_room_title
				+ ", live_room_remark=" + live_room_remark + ", user_name=" + user_name + "]";
	}
	public UserLike() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserLike(String userId, String liveRoomId, String live_room_title, String live_room_remark,
			String user_name) {
		super();
		this.userId = userId;
		this.liveRoomId = liveRoomId;
		this.live_room_title = live_room_title;
		this.live_room_remark = live_room_remark;
		this.user_name = user_name;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getLiveRoomId() {
		return liveRoomId;
	}
	public void setLiveRoomId(String liveRoomId) {
		this.liveRoomId = liveRoomId;
	}
	public String getLive_room_title() {
		return live_room_title;
	}
	public void setLive_room_title(String live_room_title) {
		this.live_room_title = live_room_title;
	}
	public String getLive_room_remark() {
		return live_room_remark;
	}
	public void setLive_room_remark(String live_room_remark) {
		this.live_room_remark = live_room_remark;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	
	
	

}
