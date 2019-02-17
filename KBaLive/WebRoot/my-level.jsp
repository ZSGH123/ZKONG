<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的等级-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/mylevel.css"/>
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
  				<li><a href="my-messages.jsp">
  					<i class="fa fa-envelope-o" aria-hidden="true"></i>
  						我的消息
  					</a></li>
  				<li><a href="my-book.jsp">
  					<i class="fa fa-heart-o" aria-hidden="true"></i>
  						我的订阅
  					</a></li>
  				<li class="active"><a href="my-level.jsp">
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
				<div class="user-mylevel-title clearfix">
					<span class="level_tit">
						<i class="user-mylevel-icon"></i>
						<h4>我的等级</h4>
					</span>
				</div>
				<div class="userinfo clearfix">
					<div class="mylevel-portait fl">
						<img src="${loginUser.userIcon}" width="120px" height="120px"/>
					</div>
					<div class="mylevel-udetail-info fl">
						<div class="mylevel-uname clearfix">
							<div class="mylevel-uname-con clearfix">
								<h4>${loginUser.userName}</h4>
							</div>
						</div>
						<div class="user-mylevel-rank">
					
							<p class="user-level" >
								等级${userpropertys[0].kNumber==null ? 0 : userpropertys[0].kNumber%20}
							</p>
							<a class="bar">
								<span id="barline" class="bar-totalper">
								</span>
								<span id="leverline" class="bar-per" style="width: ${userpropertys[0].kNumber==null ? 0 : userpropertys[0].kNumber%20*5}%;">
								</span>
							</a>
							<span id="leverscore" class="bar_nb">
					
							</span>
							<p class="user-level" >
								等级${userpropertys[0].kNumber==null ? 0 : userpropertys[0].kNumber%20+1}
							</p>
						
						</div>	
					</div>
					
				</div>
				<div class="user-mylevel-uplevel">
					<h2 class="user-mylevel-uplevel-title">
						<span class="user-mylevel-uplevel-titlebtn">如何快速升级</span>
					</h2>
					<ul >
						<li class="user-mylevel-uplevel-item fl">
							<span class="user-mylevel-uplevel-item-img">
								<img src="img/zsli.png"/>
							</span>
							<p class="user-mylevel-uplevel-item-title" >赠送礼物</p>
							<p class="user-mylevel-uplevel-item-intro" >礼物刷起来，经验飙到嗨</p>
						</li>
						<li class="user-mylevel-uplevel-item fl">
							<span class="user-mylevel-uplevel-item-img">
								<img src="img/czkb.png"/>
							</span>
							<p class="user-mylevel-uplevel-item-title" >充值K币</p>
							<p class="user-mylevel-uplevel-item-intro" >充值千千万，经验爽翻天</p>
						</li>
						<li class="user-mylevel-uplevel-item fl">
							<span class="user-mylevel-uplevel-item-img">
								<img src="img/qd.png"/>
							</span>
							<p class="user-mylevel-uplevel-item-title">签到</p>
							<p class="user-mylevel-uplevel-item-intro">看吧天天游，经验滚雪球</p>
						</li>
						<li class="user-mylevel-uplevel-item fl">
							<span class="user-mylevel-uplevel-item-img">
								<img src="img/fx.png"/>
							</span>
							<p class="user-mylevel-uplevel-item-title" >分享直播</p>
							<p class="user-mylevel-uplevel-item-intro" >分享直播间，花式拿经验</p>
						</li>

					</ul>
				</div>
			</div>
		</div>
		
	</body>
</html>