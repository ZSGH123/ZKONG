/**
 * 
 */

function openGiftInfoInsert(){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		window.location.href="giftinfo-insert.jsp";
	}else{
		alert("权限不足");
	}
}

function giftInfoUpdate(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
			$.post("backStageGiftTypeAction.do?command=selectOfUpdate",{giftId:id},
				function(data){
			if(data){
				//alert("进来了");
				window.location.href="giftinfo-update.jsp";
			}else{			
				confirm("修改失败");
			}
		});
	}else{
		alert("权限不足");
	}
}

function deleteGiftInfo(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		$.post("backStageGiftTypeAction.do?command=delete",{giftId:id},function(data){
			if(data){
				window.location.href="backStageGiftTypeAction.do";
			}
			else{
				confirm("删除失败");
			}
		});
	}else{
		alert("权限不足");
	}
}
