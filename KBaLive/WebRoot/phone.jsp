<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绑定新手机-安全验证-个人中心-看吧</title>
        <link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/password.css"/>
		<link rel="stylesheet" type="text/css" href="css/verify.css"/>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
		<script type="text/javascript" src="js/verify.js" ></script>
		<script type="text/javascript" src="js/jquery.validate.min.js" ></script>
</head>
<body style="background-color:#FFFFFF ;">
  
  <jsp:include page="top.jsp"></jsp:include>
		
		<div class="container">
			<div class="col-md-12">
				<h1>个人中心</h1>
			</div>
			<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" role="tablist">
  				<li class="active"><a href="user-page.html">	
  					<i class="fa fa-user-circle-o" aria-hidden="true"></i>
  						我的资料
  					</a></li>
  				<li><a href="my-messages.html">
  					<i class="fa fa-envelope-o" aria-hidden="true"></i>
  						我的消息
  						<span class="badge">3</span>
  					</a></li>
  				<li><a href="my-book.html">
  					<i class="fa fa-heart-o" aria-hidden="true"></i>
  						我的订阅
  					</a></li>
  				<li><a href="my-level.html">
  					<i class="fa fa-bookmark" aria-hidden="true"></i>
  						我的等级
  				</a></li>
  				<li><a href="my-property.html">
  						<i class="fa fa-credit-card" aria-hidden="true"></i>
  						我的钱包
  				</a></li>
  				<li><a href="my-consume.html">
	  					<i class="fa fa-jpy" aria-hidden="true"></i>
  						 消费记录
  				</a></li>
  				<li><a href="my-exchange.html">
  					<i class="fa fa-exchange" aria-hidden="true"></i>
  						收益兑换
  				</a></li>
  				<li><a href="room-manage.html">
  						<i class="fa fa-university" aria-hidden="true"></i>
  						房间管理
  				</a></li>
				<li class="active"><a class="u_video" href="">
						<i class="u_nav_icon"></i>
						我要直播
				</a></li>
 			</ul>
			</div> 
			<jsp:include page="yz-phone.jsp"></jsp:include>
			</div>	
			<jsp:include page="bottom.jsp"></jsp:include>	
	</body>
</html>