<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>${loginUser==null?"loginUser.userName":loginUser.userName}的开播中心</title>
<link rel="stylesheet"
	href="https://cdn.staticfile.org/foundation/5.5.3/css/foundation.min.css">
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.staticfile.org/foundation/5.5.3/js/foundation.min.js"></script>
<script
	src="https://cdn.staticfile.org/foundation/5.5.3/js/vendor/modernizr.js"></script>
<!-- 引入Bootstrap核心样式文件 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css"
	href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" />

<!-- 引入jQuery核心js文件 -->
<script type="text/javascript" src="js/jquery-1.9.1.js">
		 </script>
<script type="text/javascript" src="js/bootstrap.js">
		</script>

<!-- 引入BootStrap核心js文件 -->
<link rel="stylesheet" type="text/css" href="css/anchorSet.css" />
</head>
<body>
	<div class="container" id="anchor_set">
		<div class="col-md-2" id="anchor_set_left">
			<!--左侧菜单栏-->
		</div>

		<div class="col-md-10" id="anchor_set_right">

			<div id="anchor_set_right_1">直播设置</div>
			<!--
                	作者：offline
                	时间：2019-01-23
                	描述：推流设置
                -->
			<div class="row" style="padding-top: 10px;margin-left: 20px;">
				<div class="col-md-1"
					style=" color: orange;font-size:20px;padding: 0px;width: 5px;">
					|</div>

				<div class="col-md-1"
					style="padding: 0px;width: 200px;font-size: 20px;padding-left: 5px;">
					<b>推流设置</b>
				</div>
			</div>

			<div class="row" id="rtmp_address">
				<div class="col-md-2" id="on_off_1">rtmp地址：</div>
				<div class=" col-md-2 " id="rtmp_address_2">
					<input type="text" class="form-control" id="exampleInputPassword1"
						value=${myLiveRoom.livePushAddress}>
				</div>
			</div>

			<div id="but">
				<input type="button" name="copy" id="copy" value="复制" />
			</div>

			<div class="row" id="rtmp_address">
				<div class="col-md-2" id="on_off_1">直&nbsp;&nbsp;播&nbsp;&nbsp;码：</div>
				<div class=" col-md-2 " id="rtmp_address_2">
					<input type="text" class="form-control" id="exampleInputPassword1"
						value=${myLiveRoom.livePushCode}>
				</div>
			</div>

			<div id="but">
				<input type="button" name="copy" id="copy" value="复制" />
			</div>

			<!--
                	作者：offline
                	时间：2019-01-23
                	描述：房间设置
                -->
			<div class="row"
				style="padding-top: 10px;margin-left: 20px;margin-top: 30px;">
				<div class="col-md-1"
					style=" color: orange;font-size:20px;padding: 0px;width: 5px;">
					|</div>

				<div class="col-md-1"
					style="padding: 0px;width: 200px;font-size: 20px;padding-left: 5px;">
					<b>房间设置</b>
				</div>
			</div>

			<div class="row" id="liveRoomid">
				<div class="col-md-2" id="liveRoomid_1">房间编号：</div>
				<div class=" col-md-2 " id="liveRoomid_2">
					<span>${myLiveRoom.liveRoomId}</span>
				</div>
				<div class="col-md-2" id="liveRoomid_3">
					<input type="button" name="toLiveRoom" id="toLiveRoom"
						value="进入直播间"  onclick="toMyLiveHome()"/>
				</div>
			</div>

			<div class="row" id="liveRoomTitle">
				<div class="col-md-2" id="liveRoomTitle_1">房间标题：</div>
				<div class=" col-md-2 " id="liveRoomTitle_2">
					<input type="text" name="liveRoom_tilie" id="liveRoom_tilie"
						value="${myLiveRoom.liveRoomTilie}" />
				</div>
				<div class="col-md-2" id="liveRoomTitle_3">
					<input type="button" name="toLiveRoom" id="toLiveRoom" value="修改" onclick="changeTitle()"/>
				</div>
			</div>

			<div id="liveRoomTitle_ramark">房间标题通过审核后，需要间隔10分钟才能再次修改</div>

			<div class="row" id="liveRoomnotice">
				<div class="col-md-2" id="liveRoomnotice_1">房间公告： </div>
				<div class=" col-md-2 " id="liveRoomnotice_2">
					<textarea id="gongGaoText" style="min-height: 110px;min-width: 400px;max-height: 110px; max-width: 400px;">${myLiveRoom.liveRoomAnnouncement}</textarea>
				</div>

			</div>

			<div id="liveRoomnotice_set">
				<input type="button" name="set" id="set" value="修改"  onclick="changeGonggao()"/>
			</div>

			<div id="liveRoomTitle_ramark">房间公告通过审核后，需要间隔10分钟才能再次修改</div>

			<!--
                	作者：offline
                	时间：2019-01-23
                	描述：其他设置
                -->
			<div class="row"
				style="padding-top: 10px;margin-left: 20px;margin-top: 30px;">
				<div class="col-md-1"
					style=" color: orange;font-size:20px;padding: 0px;width: 5px;">
					|</div>

				<div class="col-md-1"
					style="padding: 0px;width: 200px;font-size: 20px;padding-left: 5px;">
					<b>其他设置</b>
				</div>
			</div>

			<div class="row" id="liveRoomyuname">
				<div class="col-md-2" id="liveRoomyuname_1">当前域名：</div>
				<div class=" col-md-2 " id="liveRoomyuname_2">
					<span>http://127.0.0.1:70/KBaLive/userAction.do?command=toLiveHome&liveRoomId=${myLiveRoom.liveRoomId}</span>
				</div>

			</div>


			<div class="row" id="liveRoomyuname">
				<div class="col-md-2" id="liveRoomyuname_1">微博同步：</div>
				<div class=" col-md-2 " id="liveRoomtongbu">
					<input type="button" name="tongbu" id="" value="同步到微博" />
				</div>
				<div class="col-md-2" id="liveRoomtongbu_1">
					（开播后将同步直播内容至微博，审核通过后才可用）</div>

			</div>

			<div class="row" id="on_off">
				<div class="col-md-2" id="on_off_1">直播分数：</div>
				<div class=" col-md-2 " id="on_off_2"
					style="margin-top:3px;width:35px;height:25px;">
					<span> <font color="green"><b>12</b></font>分
					</span>
				</div>
				<div class="col-md-4" id="on_off_3" style="margin-left: 5px;">
					<input type="button" name="ant" id="ant" value="查看扣分记录" />
				</div>

			</div>

			<div id="liveRoomOther_ramark">
				如果出现违规扣除一定直播分数，4分以下关闭直播间礼物、酬勤系统。扣为0分永久封停直播间。保持直播出勤率，可以恢复一定积分。</div>


		</div>
	</div>
	
	<script type="text/javascript">
	       var gonggaotime=null;
	       var titletime=null;
	       function changeGonggao(){
	            var gonggao=$('#gongGaoText').val();
				$.ajax({
					type : 'post',
					url : 'userAction.do?command=changGonggao&gongGao=' + gonggao + '&roomId=' + ${myLiveRoom.liveRoomId},
					dataType : 'text',
					success : function(data) {
					    //检查时间间隔
					    if(true){
					       alert("公告更新成功!");
					    }	    
					}
				});
			}
			
			function changeTitle(){
	            var title=$('#liveRoom_tilie').val();
				$.ajax({
					type : 'post',
					url : 'userAction.do?command=changTitle&roomTitle=' + title + '&roomId=' + ${myLiveRoom.liveRoomId},
					dataType : 'text',
					success : function(data) {
					    //检查时间间隔
					    if(true){
					       alert("房间标题更新成功!");
					    }	    
					}
				});
			}
			
			function toMyLiveHome(){
			    window.location.href="userAction.do?command=toLiveHome&liveRoomId="+${myLiveRoom.liveRoomId};
			}

	</script>

</body>
</html>