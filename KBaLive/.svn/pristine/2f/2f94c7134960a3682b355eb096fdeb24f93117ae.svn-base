<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>绑定银行卡-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/bankcard.css"/>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body style="background-color:#FFFFFF ;">
		<jsp:include page="top.jsp"></jsp:include>
		<div class="container" >
		
			<div class="col-md-12">
				<h1>个人中心</h1>
			</div>
			<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" role="tablist">
  				<li  class="active"><a href="user-page.jsp">	
  					<i class="fa fa-user-circle-o" aria-hidden="true"></i>
  						我的资料
  					</a></li>
  				<li><a href="my-messages.jsp">
  					<i class="fa fa-envelope-o" aria-hidden="true"></i>
  						我的消息
  						<span class="badge">3</span>
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
				<p class="convert_note">
				*请如实填写银行卡信息，如您因填写错误导致转账失败的情况，看吧概不负责！	
				</p>
				<form id="frm" class="user_convert" action="userAction.do?command=updateBankcard" method="post">
					<div class="control_group clearfix">
						<label class="control-label">
							<span>*</span>
							银行卡号：
						</label>
						<div class="control control02">
							<input type="text" name="bankcard" id="bankcard" class="form-control convert_text" value="" maxlength="30" />
						</div>
					</div>
					<div class="control_group clearfix">
						<label class="control-label">
							<span>*</span>
							开户行：
						</label>
						<div class="control control02">
							<input type="text" name="bank" id="bank" class="form-control convert_text" value="" maxlength="30" />
						</div>
					</div>
					<div class="control_group clearfix">
						<label class="control-label">
							<span>*</span>
							收款人姓名：
						</label>
						<div class="control control02">
							<input type="text" name="uname" id="uname" class="form-control convert_text" value="" maxlength="30" />
						</div>
					</div>
					<div class="control_group clearfix">
						<label class="control-label">
							<span>*</span>
							收款人身份证：
						</label>
						<div class="control control02">
							<input type="text" name="IDcard" id="IDcard" class="form-control convert_text" value="" maxlength="30" />
						</div>
					</div>
					<div class="largeBtn">
						<label class="control-label"></label>
							<button id="password_submit" class="primary_button01" type="submit">
								<span>
								提交
								</span>
							</button>
					</div>
		
				</form>					
			</div>
		</div>
		
	</body>
</html>