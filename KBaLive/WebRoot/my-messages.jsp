<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的消息-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/mymessages.css"/>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body style="background-color:#FFFFFF ;">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="container">
			<div class="col-md-12">
				<h1>个人中心</h1>
			</div>
			<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" role="tablist">
  				<li><a href="user-page.jsp">	
  					<i class="fa fa-user-circle-o" aria-hidden="true"></i>
  						我的资料
  					</a></li>
  				<li class="active"><a href="my-messages.jsp">
  					<i class="fa fa-envelope-o" aria-hidden="true"></i>
  						我的消息
  					</a></li>
  				<li><a href="my-book.jsp">
  					<i class="fa fa-heart-o" aria-hidden="true"></i>
  						我的订阅
  					</a></li>
  				<li><a href="my-level.jsp">
  					<i class="fa fa-bookmark" aria-hidden="true"></i>
  						我的等级
  				</a></li>
  				<li><a href="my-property.jsp">
  						<i class="fa fa-credit-card" aria-hidden="true"></i>
  						我的钱包
  				</a></li>
  				<li><a href="my-consume.jsp">
	  					<i class="fa fa-jpy" aria-hidden="true"></i>
  						 消费记录
  				</a></li>
  				<li><a href="my-exchange.jsp">
  					<i class="fa fa-exchange" aria-hidden="true"></i>
  						收益兑换
  				</a></li>
  				<li><a href="room-manage.jsp">
  						<i class="fa fa-university" aria-hidden="true"></i>
  						房间管理
  				</a></li>
				<li class="active"><a class="u_video" href="">
						<i class="u_nav_icon"></i>
						我要直播
				</a></li>  				
 			</ul>
			</div> 
			<div class="col-md-10">
				<div class="user-mymessages-title clearfix">
					<span class="messages_tit">
						<i class="user-mymessages-icon"></i>
						<h4>我的消息</h4>
					</span>
				</div>
				<div class="messages_content">
				<c:forEach items="${reportMessages}" var="rms">
					<div class="panel panel-success">
						<div class="panel-heading">
							看吧官方系统消息（举报反馈）
						</div>
						<div class="panel-body">
							举报时间：${rms.reportTime} <br /><br />
							举报内容：${rms.reportContent}<br /><br /><br />
							处理结果：${rms.reportHandleResult==0 ? "失败":"成功"}
							<span id="message_time">
								2019-01-16 19:10
							</span>
						</div>
					</div>
				</c:forEach>
				<c:forEach items="${userManagers}" var="ums">
					<div class="panel panel-success">
						<div class="panel-heading">
							看吧官方系统消息(直播管理)
						</div>
						<div class="panel-body">
							内容：<br /><br />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								主播 &nbsp;&nbsp;${ums.user_name}&nbsp;&nbsp;&nbsp;将	您设置为其房间管理员					
							<span id="message_time">
								${ums.roomManagerWorkTime}
							</span>
						</div>
					</div>
				</c:forEach>
					
				</div>
				
	
			</div>
		</div>
		
	</body>
</html>