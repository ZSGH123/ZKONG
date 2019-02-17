<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML >
<html >
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title>看吧直播-技术驱动娱乐-弹幕式互动直播平台</title>
        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
	    <script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<link rel="stylesheet" type="text/css" href="css/kBaLiveIndex.css" />
		<link rel="stylesheet" type="text/css" href="css/style.css"/>
		<script type="text/javascript" src="js/jwplayer.js"></script>
	</head>
	<body>
	    <jsp:include page="top.jsp"></jsp:include>
		<div class="container" id="container_top" style="background-image: url(${bg}); margin-right: 15px;">
			<div class="row" id="view">
				<div class="col-md-10" id="view-left" onclick="toLive()" style="background-color: #eee;">
				<div id="player" style="width: 100%; height: 100%;">
				 <embed id="flash" src='play/player.swfplayer.swf' autostart="true"
							style="width: 100%; height: 100%;"></embed>   
				<script type='text/javascript'>
					//生成播放器
					function craetPlayer() {
						thePlayer = jwplayer('player').setup({
							'flashplayer' : 'play/player.swf',
							'file' : '70002', //文件名为直播间id
							'streamer' : 'rtmp://Imprator/oflaDemo',
							'autostart' : 'true', //自动播放
							'bufferlength' : '0',
							'overstretch' : 'fit',
							'controlbar' : 'none', //控制条位置
							'stretching' : 'fill',
							'image' : 'images/hk1.jpg',
							'width' : '100%',
							'height' : '100%',
						});
					}
					//
					function toLive(){
					     window.location.href="http://Imprator:8080/KBaLive/userAction.do?command=toLiveHome&liveRoomId=70002";
					}
					//初始化方法
					$(function() {
				
						//建立播放器
						craetPlayer();
						
					});
				</script>
				</div>

			</div>
				<div class="col-md-2" id="view-rigth">
				 <c:forEach items="${liveRoomsTop}" var="item">
					<a href="userAction.do?command=toLiveHome&liveRoomId=${item.liveRoomId}" target="_blank"><img src="${item.liveRoomRemark}" width="140px" /></a>
				 </c:forEach>
				</div>	
				</div>
			</div>
				<!--
                	作者：offline
                	时间：2019-01-11
                	描述：游戏类型
                -->
               
				<div class="row" id="game_type">
					<!--网游竞技-->
					<div class="col-lg-6" id="game_type_left">
						<div class="row" id="game_type_top">
							<div class="col-md-2" id="game_type_top_logo"><img src="img/网游竞技.png"/></div>
						<div class="col-md-4" id="game_type_top_title"><font size="4" style="margin-top: 10px;">${liveType0.liveTypeName}</font></div>
						 <c:forEach items="${liveContents0}" var="item" begin='0' end='3'>
						 <div class="col-md-2" id="game_type_top_button_webgame"> <a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><input type="button" name="lol" id="lol" value="${item.liveContentName}"/></a></div>
					     </c:forEach>
					    </div>
					    <div class="row" id="game_type_foot_webgame">
					        <c:forEach items="${liveRooms0}" var="item" begin='0' end='2'>
					    	<div class="col-md-4" id="game_type_foot_webgame_img"><a href="userAction.do?command=toLiveHome&liveRoomId=${item.liveRoomId}"><img src="${item.liveRoomRemark}" height="90px" style="border-radius:5px"/></a></div>
					    	</c:forEach>
					    </div>
					</div>
					<!--单击游戏-->
					<div class="col-lg-6" id="game_type_right">
						<div class="row" id="game_type_top">
							<div class="col-md-2" id="game_type_top_logo"><img src="img/单机游戏.png"/></div>
						<div class="col-md-4" id="game_type_top_title"><font size="4" style="margin-top: 10px;">${liveType1.liveTypeName}</font></div>
						<c:forEach items="${liveContents1}" var="item" begin='0' end='3'>
						 <div class="col-md-2" id="game_type_top_button_webgame"> <a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><input type="button" name="lol" id="lol" value="${item.liveContentName}"/></a></div>
					     </c:forEach>
					    </div>
						  <div class="row" id="game_type_foot_clickgame">
					    	 <c:forEach items="${liveRooms1}" var="item" begin='0' end='2'>
					    	<div class="col-md-4" id="game_type_foot_webgame_img"><a href="userAction.do?command=toLiveHome&liveRoomId=${item.liveRoomId}"><img src="${item.liveRoomRemark}" height="90px" style="border-radius:5px"/></a></div>
					    	</c:forEach>
					    </div>
					</div>
			
			<!--娱乐天地-->
			<div class="col-lg-6" id="game_type_left">
						<div class="row" id="game_type_top">
							<div class="col-md-2" id="game_type_top_logo"><img src="img/手机游戏.png"/></div>
						<div class="col-md-4" id="game_type_top_title"><font size="4" style="margin-top: 10px;">${liveType2.liveTypeName}</font></div>
						<c:forEach items="${liveContents2}" var="item" begin='0' end='3'>
						 <div class="col-md-2" id="game_type_top_button_webgame"> <a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><input type="button" name="lol" id="lol" value="${item.liveContentName}"/></a></div>
					     </c:forEach>
					    </div>
					      <div class="row" id="game_type_foot_entertainment">
					    	 <c:forEach items="${liveRooms2}" var="item" begin='0' end='2'>
					    	<div class="col-md-4" id="game_type_foot_webgame_img"><a href="userAction.do?command=toLiveHome&liveRoomId=${item.liveRoomId}"><img src="${item.liveRoomRemark}" height="90px" style="border-radius:5px"/></a></div>
					    	</c:forEach>
					    </div>
					</div>
					
					<!--手机游戏-->
					<div class="col-lg-6" id="game_type_right">
						<div class="row" id="game_type_top">
							<div class="col-md-2" id="game_type_top_logo"><img src="img/娱乐天地.png"/></div>
						<div class="col-md-4" id="game_type_top_title"><font size="4" style="margin-top: 10px;">${liveType3.liveTypeName}</font></div>
						<c:forEach items="${liveContents3}" var="item" begin='0' end='3'>
						 <div class="col-md-2" id="game_type_top_button_webgame"> <a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><input type="button" name="lol" id="lol" value="${item.liveContentName}" style="border-radius:5px"/></a></div>
					     </c:forEach>
					    </div>
						  <div class="row" id="game_type_foot_mobilegame">
					    	 <c:forEach items="${liveRooms3}" var="item" begin='0' end='2'>
					    	<div class="col-md-4" id="game_type_foot_webgame_img"><a href="userAction.do?command=toLiveHome&liveRoomId=${item.liveRoomId}"><img src="${item.liveRoomRemark}" height="90px" style="border-radius:5px"/></a></div>
					    	</c:forEach>
					    </div>
					</div>
		</div>
		<!--
                	作者：offline
                	时间：2019-01-11
                	描述：游戏分类
                -->
                
                <div class="row" id="hot_classify">
                	<div class="col-md-1" id="hot_classify_logo"><img src="images/pushtypeimg/hot.png" style="border-radius:50%; margin-top:9px;"/></div>
                	<div class="col-md-2" id="hot_classify_title">热门分类</div>
                	<c:forEach items="${liveContents}" var="item" begin='0' end='6'>
                	 <div class="col-md-1" id="hot_classify_button"><a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><input type="button" name="lol" id="lol" value="${item.liveContentName}" /></a></div>
                	</c:forEach>
                	<div class="col-md-1" id="hot_classify_button"><a href="liveIndexAction.do?command=toAllLiveTypeIndex"><input type="button" name="lol" id="lol" value="更多>>" /></a></div>
                </div>
                
                <div class="row" id="hot_classify_game">
                    <c:forEach items="${liveContents}" var="item" begin='0' end='6'>
                	  <div class="col-md-1" id="hot_classify_game_img"><a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><img src="${item.liveContentImgURL}" width="127px" style="border-radius:5px"/>${item.liveContentName}</a></div>
                	</c:forEach>
		</div>
		
		 <div class="row" id="hot_classify_game">
                 <c:forEach items="${liveContents}" var="item" begin='7' end='13'>
                	  <div class="col-md-1" id="hot_classify_game_img"><a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><img src="${item.liveContentImgURL}" width="127px" style="border-radius:5px"/>${item.liveContentName}</a></div>
                 </c:forEach>	
		</div>

            <!--
                	作者：offline
                	时间：2019-01-11
                	描述：英雄联盟
                -->
           <c:forEach items="${liveRoomsInfos}" var="item" >
              <c:set value="${item.pushliveRoomDetailInfos}" var="item1"/>
              <c:set value="${item.liveRoomDetailInfos}" var="item2"/>
              <c:set value="${item.extraliveRoomDetailInfos}" var="item3"/>
              <c:if test="${fn:length(item1)>0 || fn:length(item2)>0}">
	          <div class="row" id="lol_list">
                    <div class="col-md-1" id="lol_list_logo"><img src="${item.pushType.pushTypeRemark}" style="margin-top:7px;"/></div>
                	<div class="col-md-2" id="lol_list_title">${item.pushType.pushName}</div>
                	<c:forEach items='${item3}' var="itemname">
                	   <div class="col-md-1" id="hot_classify_button"><a href="userAction.do?command=toLiveHome&liveRoomId=${itemname.liveRoom.liveRoomId}"><input type="button" name="lol" id="lol" value="${itemname.userInfo.userName}" /></a></div>
                	</c:forEach>
              </div>
	          <div class="row" id="lol_list_game">
	                <c:forEach items='${item1}' var="pushitem">
                	<div class="col-md-3" id="lol_list_img">
                		<a href='userAction.do?command=toLiveHome&liveRoomId=${pushitem.liveRoom.liveRoomId}'><img src="${pushitem.liveRoom.liveRoomRemark}" style="border-radius:5px"/></a>
                		<a href='userAction.do?command=toLiveHome&liveRoomId=${pushitem.liveRoom.liveRoomId}' style="color:  midnightblue;">${pushitem.userInfo.userName}:${pushitem.liveRoom.liveRoomTilie}</a><br/>
                		<img src='${empty pushitem.userInfo.userIcon ? "img/logo/logo（40）.png":pushitem.userInfo.userIcon}' style="border-radius:50% ;" width='20px'/>
                		<a href='userAction.do?command=toLiveHome&liveRoomId=${pushitem.liveRoom.liveRoomId}' style="color:  midnightblue; font-size :12px;">${pushitem.userInfo.userName}</a>
                		<span ><a href='LiveContentAction.do?liveContentId=${pushitem.liveContent.liveContentId}' style="color: #f60;font-size :12px;">${pushitem.liveContent.liveContentName}</a></span><div class="clear"></div>
                	</div>
                	</c:forEach>
                	<c:forEach items='${item2}' var="pushitem1">
                	<div class="col-md-3" id="lol_list_img">
                		<a href='userAction.do?command=toLiveHome&liveRoomId=${pushitem1.liveRoom.liveRoomId}'><img src="${pushitem1.liveRoom.liveRoomRemark}" style="border-radius:5px"/></a>
                		<a href='userAction.do?command=toLiveHome&liveRoomId=${pushitem1.liveRoom.liveRoomId}' style="color:  midnightblue;">${pushitem1.userInfo.userName}:${pushitem1.liveRoom.liveRoomTilie}</a><br/>
                		<img src='${empty pushitem1.userInfo.userIcon ? "img/logo/logo（40）.png":pushitem1.userInfo.userIcon}' style="border-radius:50% ;" width='20px'/>
                		<a href='userAction.do?command=toLiveHome&liveRoomId=${pushitem1.liveRoom.liveRoomId}' style="color:  midnightblue; font-size :12px;">${pushitem1.userInfo.userName}</a>
                		<span ><a href='LiveContentAction.do?liveContentId=${pushitem1.liveContent.liveContentId}' style="color: #f60;font-size :12px;">${pushitem1.liveContent.liveContentName}</a></span><div class="clear"></div>
                	</div>
                	</c:forEach>
              </div>
              </c:if>
          </c:forEach>
                	<!--
                	作者：offline
                	时间：2019-01-11
                	描述：首页底部
                -->
                	<div class="row" id="foot">
                		<div class="row" id="foot_first">
                		   <div class="col-md-1 col-md-offset-1" >友情链接</div>
                	       <div class="col-md-1" ><a>看吧招采平台</a></div>
                	       <div class="col-md-1" ><a>看吧手机站</a></div>
                	       <div class="col-md-1" ><a>看吧论坛</a></div>
                	       <div class="col-md-1" ><a>企鹅直播</a></div>
                	       <div class="col-md-1" ><a>沙发管家</a></div>
                	       <div class="col-md-1" ><a>齐齐乐</a></div>
                	       <div class="col-md-1" ><a>视频直播</a></div>
                	       <div class="col-md-1" ><a>视频专题列表</a></div>
                	       <div class="col-md-1" ><a>开放平台</a></div>
                	</div>
                	<div class="row" id="foot_second">
                		<div class="col-md-1 col-md-offset-2" ><a>小说</a></div>
                	       <div class="col-md-1" ><a>广告</a></div>
                	       <div class="col-md-1" ><a>漫画</a></div>
                	       <div class="col-md-1" ><a>图片</a></div>
                	</div>
                	<div class="row" id="foot_line">
                		
                	</div>
                	<div class="row" id="foot_we">
                		  <div class="col-md-1 col-md-offset-1" ><a>关于我们</a></div>
                	       <div class="col-md-1" ><a>联系客服</a></div>
                	       <div class="col-md-1" ><a>招聘信息</a></div>
                	       <div class="col-md-1" ><a>我要直播</a></div>
                	       <div class="col-md-1" ><a>意见反馈</a></div>
                	       <div class="col-md-1" ><a>版权保护</a></div>
                	       <div class="col-md-1" ><a>看吧qq群</a></div>
                	       <div class="col-md-1" ><a>投诉</a></div>
                	       <div class="col-md-1" ><a>举报</a></div>
                	       <div class="col-md-1" ><a>举报热线</a></div>
                	</div>
                	<div class="row" id="foot_security">
                		长沙看吧网络科技有限公司 版权所有 ©www.kba.com 湘ICP备15011961号-1 |  湘公网安备 42018502000107号 |   工商网监 |   湘网文（2019）9760-291号 
                	</div>
                	<div class="row" id="foot_address">
                		公司地址：湖南省长沙市岳麓区长沙岳麓专修学院301  客户服务热线：17643236817
                	</div>
                	</div>

	</body>

</html>