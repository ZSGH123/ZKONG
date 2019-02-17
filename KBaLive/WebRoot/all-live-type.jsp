<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<meta charset="UTF-8">
<title>KBaLive-直播分类</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/left.css" />
<link rel="stylesheet" type="text/css" href="css/type.css" />
<script type='text/javascript' src='js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='js/all-live-type.js'></script>
</head>

<body>
	<jsp:include page="top.jsp"></jsp:include>
	<!--描述：左边导航栏开始-->
	<jsp:include page="left.jsp"></jsp:include>
	<!--描述：左边导航栏结束 -->
	<div class="container-fluid" id="rightcontent">
		<div class="row">
			<!--作者：2671242147@qq.com 时间：2019-01-14 描述：内容开始-->
			<div class="col-md-12">
				<div class="panel  panel-warning">
					<div class="panel-heading">
						<div class="title">
							<h3 style="display: inline-block;">
								<img src="img/video.png" style="margin-left: 1px;margin-right: 10px;margin-bottom: 3px;"/>全部分类
							</h3>
							<div class="btn-group" id="btn_box">
								<a href="liveIndexAction.do?command=toAllLiveTypeIndex"><button type="button" class="btn btn-default" id="btn">全部</button></a>
								<c:forEach items="${allLiveType}" var="item" >
								<a href="javascript:selectLiveContentById(${item.liveTypeId})"><button type="button"class="btn btn-default" id="btn">${item.liveTypeName}</button></a>
								</c:forEach>
							</div>
						</div>
						<div class="titlebotborder">
							<div class="border1"></div>
							<div class="border2"></div>
						</div>
					</div>
					<div class="panel-body" style="padding:15px 0px 0px 15px">
						<ul id="liveroom_box">
						    <c:forEach items="${allliveContents}" var="item" >
							    <li id="liveroom">
								<div class="panel panel-warning">
									<div class="panel-heading" style="padding: 0px;">
										<a href="LiveContentAction.do?liveContentId=${item.liveContentId}"><img src="${item.liveContentImgURL}" width="127px" /></a>
									</div>
									<div class="panel-body" style="padding: 5px;">
										<div style="text-align: center;">
											<h5 class="title">
												<a href="LiveContentAction.do?liveContentId=${item.liveContentId}">${item.liveContentName}</a>
											</h5>
										</div>
									</div>
								</div>
							    </li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<!--作者：2671242147@qq.com 时间：2019-01-14 描述：内容结束  -->

		</div>
	</div>
</body>
</html>
