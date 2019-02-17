/**
 * 时间：2019-1-25
 */
/**
 * 钟强
 * 描述：根据直播类型id查询相应所有直播房间信息
 */
function selectRoomByLiveTypeID(typeId) {
	var url = "liveIndexAction.do?command=selectRoomByLiveTypeID&liveTypeId=" + typeId;
	$.ajax({
		url : url,
		type : "post",
		async : true,
		dataType : "json",
		processData : false,
		cache : false,
		statusCode : {
			404 : function() {
				console.log("页面没找到");
			}
		},
		success : function(data, textStatus, xmlhttp) {
			if (data != null) {
				parseJson(data);
			}
			console.log("成功" + data);
		},
		error : function(e) {
			alert("网络错误！，请重试");
		}
	});
}

/**
 * 钟强
 * 描述：解析json数据
 */
function parseJson(data) {
	var pos = $("#liveroom_box_online");
	var liveRoomDetailInfos = data.liveRoomDetailInfos;
	var len = liveRoomDetailInfos.length;
	var content = "";
	for (var i = 0; i < len; i++) {
		var liveRoom = liveRoomDetailInfos[i].liveRoom;
		var userInfo = liveRoomDetailInfos[i].userInfo;
		var liveContent = liveRoomDetailInfos[i].liveContent;
		
		var liveRoomId = liveRoom.liveRoomId;
		var liveRoomRemark = liveRoom.liveRoomRemark;
		var userName = userInfo.userName;
		var liveRoomTilie = liveRoom.liveRoomTilie;
		var liveContentId = liveContent.liveContentId;
		var liveContentName = liveContent.liveContentName;
		var userIcon = userInfo.userIcon;
		if(userIcon==null){
			userIcon="img/logo/logo（40）.png";
		}
		content += "<li id='liveroom'><div class='panel panel-warning'><div class='panel-heading' style='padding: 0px;'><a href='" + liveRoomId + "' >";
		content += "<img src='" + liveRoomRemark + "' width='248px' /></a></div>";
		content += "<div class='panel-body' style='padding: 5px;'><div><h5 class='title'><a href='"+liveRoomId+"'style='font-size: 15px;'>"+userName+":"+liveRoomTilie;
		content += "</a></h5><span class='tag'><a id='atag' href='LiveContentAction.do?liveContentId=" + liveContentId + "' style='float: right;'>"+liveContentName;
		content+="</a></span><div class='clear'></div></div><span>";
		content +="<img src='"+userIcon+"' style='border-radius:50% ;' width='20px'/>"+"<a href='"+liveRoomId+"' style='font-size: 12px;'>"+userName;
		content += "</a></span></div></div></li>";
	}
	pos.html(content);
	return content;
}

