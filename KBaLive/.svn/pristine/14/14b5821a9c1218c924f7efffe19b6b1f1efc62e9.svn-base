<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="b" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>我的钱包-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/myproperty.css"/>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body style="background-color:#FFFFFF ;">
		<jsp:include page="../top.jsp"></jsp:include>
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
  				<li class="active"><a href="my-property.jsp">
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
			<div class="col-md-10">
				<div class="shark_tit earning_top clearfix">
					<span class="consume_tit">
						<i class="backpack-title-icon"></i>
						<h4>我的财产</h4>
					</span>
				</div>
				<div class="consume_tab clearfix">
					<dl class="consume_tab_btn">
						<dd class="cur">资产明细</dd>
					</dl>
				</div>
				<div class="row" id="property_num">
				   <b:forEach items="${userpropertys}" var="ups">
    				<div class="col-sm-3 col-md-6" id="big_property_content">
    					<div class="thumbnail">
     						<div class="caption">
        						<img src="img/${ups.kTypeId==1 ? 'k-jin.png' : 'k-yin.png'}" align="left"/>
        						<span id="tool"><h5>${ups.kTypeId==1 ? "金K币" : "银K币"}</h5></span>
        						<span id="tool-info">余额：${ups.kNumber}k</span>
        						<span><a href="invest.html" class="btn tool-btn"  role="button">充值</a> </span>
      					    </div> 
    					</div>
  					</div>
  				</b:forEach>

				</div>
			
			</div>
		</div>
		
	</body>
</html>