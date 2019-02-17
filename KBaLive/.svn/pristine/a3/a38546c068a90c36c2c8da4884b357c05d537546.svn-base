/**
 * 
 */
/**
 * 
 */

function openKTypeInsert(){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		window.location.href="ktype-insert.jsp";
	}else{
		alert("权限不足");
	}
}

function kTypeUpdate(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
			$.post("backStageKTypeAction.do?command=selectOfUpdate",{kTypeId:id},
				function(data){
			if(data){
				//alert("进来了");
				window.location.href="ktype-update.jsp";
			}else{			
				confirm("修改失败");
			}
		});
	}else{
		alert("权限不足");
	}
}

function deleteKType(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		$.post("backStageKTypeAction.do?command=delete",{kTypeId:id},function(data){
			if(data){
				window.location.href="backStageKTypeAction.do";
			}
			else{
				confirm("删除失败");
			}
		});
	}else{
		alert("权限不足");
	}
}
function openKTypeInsert(){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		window.location.href="ktype-insert.jsp";
	}else{
		alert("权限不足");
	}
}

function kTypeUpdate(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
			$.post("backStageKTypeAction.do?command=selectOfUpdate",{kTypeId:id},
				function(data){
			if(data){
				//alert("进来了");
				window.location.href="ktype-update.jsp";
			}else{			
				confirm("修改失败");
			}
		});
	}else{
		alert("权限不足");
	}
}

function deleteKType(id){
	var position=$("#hidden").html();
	var pos=parseInt(position);
	if(pos==1){
		$.post("backStageKTypeAction.do?command=delete",{kTypeId:id},function(data){
			if(data){
				window.location.href="backStageKTypeAction.do";
			}
			else{
				confirm("删除失败");
			}
		});
	}else{
		alert("权限不足");
	}
}