
function openUserLevelInsert(){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		window.location.href="userlevel-insert.jsp";
	}else{
		alert("权限不足");
	}
}

function userLevelUpdate(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
			$.post("backStageUserLevelAction.do?command=selectOfUpdate",{userLevelId:id},
				function(data){
			if(data){
				//alert("进来了");
				window.location.href="userlevel-update.jsp";
			}else{			
				confirm("修改失败");
			}
		});
	}else{
		alert("权限不足");
	}
}

function deleteUserLevel(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		$.post("backStageUserLevelAction.do?command=delete",{userLevelId:id},function(data){
			if(data){
				window.location.href="backStageUserLevelAction.do";
			}
			else{
				confirm("删除失败");
			}
		});
	}else{
		alert("权限不足");
	}
}

//function parseJson(data){
//var showContent=$("#tdata").get(0);
//var anchorLevels=data.anchorLevelsStr;
//var len=anchorLevels.length;
//var content="";
//for(var i=0;i<len;i++){
//	var aLId=anchorLevels[i].anchorLevelId;
//	var aLName=anchorLevels[i].anchorLevelName;
//	var lMinT=anchorLevels[i].liveMinTotalTime;
//	var lMaxT=anchorLevels[i].liveMaxTotalTime;
//	var aLRemark=anchorLevels[i].anchorLevelRemark;
//	content+="<tr ><td class='center'>"+aLId+"</td>";
//	content+="<td class='center'>"+aLName+"</td>";
//	content+="<tr class='center'><td>"+lMinT+"H</td>";
//	content+="<td class='center'>"+lMaxT+"H</td>";
//	content+="<td class='center'><a class='btn btn-success' href='javascript:openAnchorLevelInsert()'>"
//	+"<i class='glyphicon glyphicon-zoom-in icon-white'></i>新增</a>"
//	+"<a class='btn btn-info' href='javascript:anchorLevelUpdate("+aLId+")'><i class='glyphicon glyphicon-修改 icon-white'></i>"
//    +"修改"+"</a><a class='btn btn-danger' href='javascript:deleteAnchorLevel("+aLId+")'>"
//    +"<i class='glyphicon glyphicon-trash icon-white'></i>删除</a></td></tr>";
//}
//   alert(content);
//showContent.innerHTML=content;
//}
