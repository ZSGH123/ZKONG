<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>

	<head>
		<meta charset="UTF-8">
		<title>KBaLive直播-搜索</title>
		<link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="css/left.css" />
		<link rel="stylesheet"  type="text/css" href="css/live.css"/>
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<script type='text/javascript' src='js/jquery-1.7.2.min.js'></script>
		<script type='text/javascript' src='js/live-index.js'></script>
	</head>

	<body>
	    <jsp:include page="top.jsp"></jsp:include>
		<!--
                	作者：2671242147@qq.com
                	时间：2019-01-14
                	描述：左边导航栏开始
                -->
       <jsp:include page="left.jsp"></jsp:include>
		<!--
                	描述：左边导航栏结束
                -->
		<div class="container-fluid" id="rightcontent">
			<div class="row">
				<!--
                	作者：2671242147@qq.com
                	时间：2019-01-14
                	描述：内容开始
                -->
				<div class="col-md-12">
					<div class="panel  panel-warning">
						<div class="panel-heading">
							<div class="title">
								<h3><img src="img/logo.png" style="margin-left: 3px;margin-right: 10px;margin-bottom: 3px;"/>看吧推荐</h3>
							</div>
							<div class="titlebotborder">
								<div class="border1"></div>
								<div class="border2"></div>
							</div>
						</div>
						<div class="panel-body" style="padding: 15px 15px 0px 15px">
							<ul id="liveroom_box">
							    <c:forEach items="${allPushLiveRoomDetailInfos}" var="item" >
							     <c:set value="${item.liveRoom}" var="liveRoomItem"/>
							     <c:set value="${item.userInfo}" var="userInfoItem"/>
							     <c:set value="${item.liveContent}" var="liveContent"/>
								<li id="liveroom">
									<div class="panel panel-warning">
										<div class="panel-heading" style="padding: 0px;">
											<a href="userAction.do?command=toLiveHome&liveRoomId=${liveRoomItem.liveRoomId}"><img src="${liveRoomItem.liveRoomRemark}" width="248px" /></a>
										</div>
										<div class="panel-body" style="padding: 5px;">
											<div>
												<h5 class="title"><a href="userAction.do?command=toLiveHome&liveRoomId=${liveRoomItem.liveRoomId}" style="font-size: 15px;">${userInfoItem.userName}:${liveRoomItem.liveRoomTilie}</a></h5>
												<span class="tag "><a id="atag" href="${liveContent.liveContentId}" style="float: right;">${liveContent.liveContentName}</a></span>
												<div class="clear"></div>
											</div>
											<span>
										<img src='${empty userInfoItem.userIcon ? "img/logo.png":userInfoItem.userIcon}' style="border-radius:50% ;" width='20px'/>  
									    <a href="userAction.do?command=toLiveHome&liveRoomId=${liveRoomItem.liveRoomId}" style="font-size: 12px;">
										  ${userInfoItem.userName}
									    </a>
									</span>
										</div>
									</div>
								</li>
								</c:forEach>
							</ul>

						</div>
					</div>
					
				<!--
                	作者：2671242147@qq.com
                	时间：2019-01-14
                	描述：内容结束
                -->
			</div>
		</div>
		</div>
	</body>

</html>
