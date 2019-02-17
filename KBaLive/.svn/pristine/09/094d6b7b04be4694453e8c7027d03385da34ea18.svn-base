<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>看吧直播-技术驱动娱乐-弹幕式互动直播平台</title>
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
<!-- 引入Bootstrap核心样式文件 -->
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/LoginIndex.css" />
<!-- 引入jQuery核心js文件 -->
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<!--
                	作者：杨智能
                	时间：2019-01-16
                	描述：登录注册部分
                -->
    <jsp:include page="top.jsp"></jsp:include>
	<div class="container-fluid" id="center">
		<div class="row">
			<div class="col-md-4 col-md-offset-6" id="logins">
				<div class="row" id="card">
					<ul class="nav nav-tabs">
						<li class="active" id="card_left"><a href="#tab1"
							data-toggle="tab" id="ttext"><font size="5">登录</font></a></li>

					</ul>

					<div class="tab-content">
						<div class="tab-pane active" id="tab1">
							<div id="tab_left">

								<!--
                        	作者：offline
                        	时间：2019-01-16
                        	描述：手机验证
                        -->
								<div class="row" id="phone_row">
									<div class="col-md-2" id="phone_row_one">账号：</div>
									<div class="form-group col-md-8" id="phone_row_two">
										<input type="text" class="form-control" id="phone" type="text"
											name="userPhoneNumber" placeholder="手机号码/用户名">

									</div>
									<div class="col-md-2" id="phone_row_three">
										<span id="one" style="color: limegreen;"></span>
									</div>
								</div>

								<div class="row" id="phone_row_line">
									<span id="two" style="font-size: 13px;color: crimson;"></span>
								</div>
								<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：密码验证
                          -->
								<div class="row" id="phone_row" style="margin-top: 0px;">
									<div class="col-md-2" id="phone_row_one">密码：</div>
									<div class="form-group col-md-8" id="phone_row_two">
										<input type="password" class="form-control" id="password"
											type="text" name="userPassword" placeholder="请填写您的登陆密码">

									</div>
									<div class="col-md-2" id="phone_row_three">
										<span id="three" style="color: limegreen;"></span>
									</div>
								</div>

								<div class="row" id="phone_row_line">
									<span id="four" style="font-size: 13px;color: crimson;"></span>
								</div>

								<!--
                                	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：验证码
                                -->


								<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：记住密码
                                  -->

								<div style="padding-left: 50px;">
									<input id="remeberpassword" type="checkbox"
										name="remeberpassword" /> <font size="2px">记住密码</font>
								</div>


								<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：登录
                                  -->

								<div id="login_but">
									<input id="login" class="mybtn" type="button" name="submit"
										value="登陆" />
								</div>

								<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：找回密码
                                  -->

								<div id="find_password">
									<a href="find-password.jsp">忘记密码？</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;还没注册账号?&nbsp;&nbsp;&nbsp;
									<a href="userAction.do?command=toRegister">立即注册</a>
								</div>

								<!--
                                  	作者：2671242147@qq.com
                                  	时间：2018-12-14
                                  	描述：三方登陆
                                  -->

								<div id="other_login">
									<a href="userAction.do?command=toWeiLogin" class="weibo"><i class="fa fa-weibo fa-2x"
										aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp; <a href="userAction.do?command=toQQLogin"
										class="qq"><i class="fa fa-qq fa-2x" aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
									<a href="#" class="wenxin"><i class="fa fa-weixin fa-2x"
										aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
								</div>

								<div id="other_login_text">第三方登陆</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>

