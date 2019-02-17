<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE HTML">
<html>
<head>
<meta charset="UTF-8">
<title>KBaLive直播${liveContent.liveContentName}</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/left.css" />
<link rel="stylesheet" type="text/css" href="css/live.css" />
<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script type='text/javascript' src='js/jquery-1.7.2.min.js'></script>
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
				<!--
                    	作者：2671242147@qq.com
                    	时间：2019-01-14
                    	描述：广告开始
                    -->
				<div id="ad">
					<div class="row">
						<div class="col-md-4" style="padding: 0px 10px 0px 15px;">
							<a href="#"><img src="images/ad/ad1.png" width="400px" alt="广告"
								class="img-rounded"></a>
						</div>
						<div class="col-md-4" style="padding: 0px;">
							<a href="#"><img src="images/ad/ad2.png" width="400px" alt="广告"
								class="img-rounded"></a>
						</div>
						<div class="col-md-4" style="padding: 0px 15px 0px 10px;">
							<a href="#"><img src="images/ad/ad2.png" width="400px" alt="广告"
								class="img-rounded"></a>
						</div>
					</div>
				</div>
				<!--
                    	作者：2671242147@qq.com
                    	时间：2019-01-14
                    	描述：广告结束
                    -->

				<!--
                    	作者：2671242147@qq.com
                    	时间：2019-01-14
                    	描述：版块说明开始
                    -->
                <c:set value="${allSpecificLiveRoomDetailInfos}" var="itemsize"/>
				<div id="ad">
					<div class="row">
						<div class="col-md-4"
							style="padding: 0px 10px 0px 15px; text-align: left;">
							<div class="panel  panel-warning" style="margin-bottom: 0px;">
								<div class="panel-heading" style="padding-right: 0px;">
									<div style="display: inline-block;">
										<img src="${liveContent.liveContentImgURL}" width="127px"/>
										<h6 style="margin: 0px; height: 6px;">&nbsp;</h6>
									</div>

									<div style="display: inline-block;">
										<h3 style="margin: 0px;">${liveContent.liveContentName}</h3>
										<p style="margin: 0px; font-size: 10px;">${liveContent.liveContentRemark}</p>
										<span><i class="fa fa-video-camera" aria-hidden="true"
											style=""></i>&nbsp;&nbsp;${fn:length(itemsize)}</span> <span style="float: right;"><img
											src="img/hot.png" width="13px" align="center" />&nbsp;&nbsp;200w</span>
									</div>
								</div>
								<div class="panel-body"
									style="padding: 0px ; text-align: center;">
									<a href="#"><img src="images/ad/ad2.png" width="394px" /></a>
								</div>
							</div>
						</div>
						<div class="col-md-4" style="padding: 0px;">
							<div class="panel  panel-warning" style="margin-bottom: 0px;">
								<div class="panel-heading">我是张家辉:这是一款你从来没玩过的全新游戏</div>
								<div class="panel-body" style="padding: 0px ;">
									<a href="#"><img src="images/ad/ad1.png" width="420px" height="112px" class="img-rounded" /></a>
								</div>
							</div>
						</div>
						<div class="col-md-4" style="padding: 0px 15px 0px 10px;">
							<div class="panel  panel-warning" style="margin-bottom: 0px;">
								<div class="panel-heading">2019lpl英雄联盟职业联赛</div>
								<div class="panel-body" style="padding: 0px ;">
									<a href="#"><img src="images/ad/ad2.png" width="395px" height="112px"
										class="img-rounded" /></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--
                    	作者：2671242147@qq.com
                    	时间：2019-01-14
                    	描述：版块说明结束
                    -->

				<!--
                    	作者：2671242147@qq.com
                    	时间：2019-01-14
                    	描述：内容开始
                    -->
				<div class="panel  panel-warning">
					<div class="panel-heading">
						<div class="title">
							<h3 style="display: inline-block;">
								<img src="img/video.png"
									style="margin-left: 1px;margin-right: 10px;margin-bottom: 3px;" />在线直播
							</h3>
							<div class="btn-group" id="btn_box">
								
							</div>
						</div>
						<div class="titlebotborder">
							<div class="border1"></div>
							<div class="border2"></div>
						</div>
					</div>
					<div class="panel-body" style="padding:15px 15px 0px 15px">
						<ul id="liveroom_box">
							    <c:forEach items="${allSpecificLiveRoomDetailInfos}" var="item" >
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
												<span class="tag "><a id="atag" href="LiveContentAction.do?liveContentId=${liveContent.liveContentId}" style="float: right;">${liveContent.liveContentName}</a></span>
												<div class="clear"></div>
											</div>
											<div>
											    <span>
										            <img src='${empty userInfoItem.userIcon ? "img/logo/logo（40）.png":userInfoItem.userIcon}' style="border-radius:50% ;" width='20px'/> 
									                <a href="userAction.do?command=toLiveHome&liveRoomId=${liveRoomItem.liveRoomId}" style="font-size: 12px;">
										                   ${userInfoItem.userName}
									                </a>
									            </span>
									            <span style="float: right;"> <img src="img/hot.png" width="13px" align="center" /> 
									                 <a href="javascript:;" style="font-size: 12px;"> 10 </a>
											    </span>
											    <div class="clear"></div>
									        </div> 
										</div>
									</div>
								</li>
								</c:forEach>
						</ul>
					</div>
					<!--
                        	作者：2671242147@qq.com
                        	时间：2019-01-14
                        	描述：分页部分
                        -->
					<div class="panel-footer" style="height: 52px;">
						<ul class="pager" style="margin: 0px;">
							<li><a href="#">上一页</a></li>
							<li><a href="#">下一页</a></li>
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
