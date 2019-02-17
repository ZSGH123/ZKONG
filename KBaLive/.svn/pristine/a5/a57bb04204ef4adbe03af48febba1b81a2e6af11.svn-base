/**
 * 时间：2019-1-25
 */
/**
 * 钟强
 * 描述：根据直播类型id查询相应所有直播内容
 */
function selectLiveContentById(typeId){
			$.ajax({
			url : "liveIndexAction.do?command=selectLiveContentByTypeId&liveTypeId="+typeId,
			type : "post",
			async : true,
			dataType : "json",
			processData:false,
			cache:false,
			statusCode : {
				404 : function() {
					console.log("页面没找到");
				}
			},
			success : function(data,textStatus,xmlhttp){
				if(data!=null){
					parseJson(data);
				}
				console.log("成功"+data);
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
function parseJson(data){
	var pos=$("#liveroom_box");
	var liveContents=data.liveContents;
	var len=liveContents.length;
	var content="";
	for(var i=0;i<len;i++){
		var liveContentId=liveContents[i].liveContentId;
		var liveContentImgURL=liveContents[i].liveContentImgURL;
		var liveContentName=liveContents[i].liveContentName;
		content+="<li id='liveroom'><div class='panel panel-warning'><div class='panel-heading' style='padding: 0px;'><a href='LiveContentAction.do?liveContentId="+liveContentId+ "' >";
		content+="<img src='"+liveContentImgURL+"' width='127px' /></a></div>";
		content+="<div class='panel-body' style='padding: 5px;'><div style='text-align: center;'><h5 class='title'>";
		content+="<a href='LiveContentAction.do?liveContentId="+liveContentId+ "'>";
		content+=liveContentName+"</a></h5></div></div></div></li>";	
	}
	pos.html(content);
}				
				