
function openAnchorLevelInsert(){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		window.location.href="anchorlevel-insert.jsp";
	}else{
		alert("权限不足");
	}
}

function anchorLevelUpdate(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
			$.post("backStageAnchorLevelAction.do?command=selectOfUpdate",{anchorLevelId:id},
				function(data){
			if(data){
				//alert("进来了");
				window.location.href="anchorlevel-update.jsp";
			}else{			
				confirm("修改失败");
			}
		});
	}else{
		alert("权限不足");
	}
}

function deleteAnchorLevel(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		$.post("backStageAnchorLevelAction.do?command=delete",{anchorLevelId:id},function(data){
			if(data){
				window.location.href="backStageAnchorLevelAction.do";
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
