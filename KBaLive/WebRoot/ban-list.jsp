<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房间禁言名单-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/roomManage.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/head.css"/>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body style="background-color:#FFFFFF ;">
		<jsp:include page="../top.jsp"></jsp:include>
		<div id="container" class="container" >
		
			<div class="col-md-12">
				<h1>个人中心</h1>
			</div>
			<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" role="tablist">
  				<li><a href="user-page.jsp">	
  					<i class="fa fa-user-circle-o" aria-hidden="true"></i>
  						我的资料
  					</a></li>
  				<li><a href="my-messages.html">
  					<i class="fa fa-envelope-o" aria-hidden="true"></i>
  						我的消息
  						<span class="badge">3</span>
  					</a></li>
  				<li><a href="my-book.jsp">
  					<i class="fa fa-heart-o" aria-hidden="true"></i>
  						我的订阅
  					</a></li>
  				<li><a href="my-level.html">
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
  				<li><a href="my-exchange.html">
  					<i class="fa fa-exchange" aria-hidden="true"></i>
  						收益兑换
  				</a></li>
  				<li class="active"><a href="room-manage.html">
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
				<div class="earn_tab_tit">
					<dl>
						<dd class="active">
							<a href="ban-list.html">禁言名单</a>
						</dd>
						<dd class="fr">
							<a href="room-manage.html">返回</a>
						</dd>
					</dl>
				</div>			
				<div class="headline01">
					<button class="add" type="submit">添加</button>
				</div>
				<div class="ban_form">
					<table class="table table-hover table-striped" border="0" cellspacing="0" cellpadding="0">
						<thead>
							<tr>
								<th>用户账号</th>
								<th>有效期</th>
								<th>操作人</th>
								<th>管理</th>
							</tr>
						</thead>	
						<tr><td>Data</td></tr>
					</table>
				</div>
			</div>
		</div>
		
	</body>
</html>