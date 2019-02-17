<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>看吧直播找回密码-安全验证</title>
<link rel="shortcut icon" href="img/logo.png " type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="css/verify.css">
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.min.js"></script>
</head>

<body>

	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title" style="font-size: 25px;">找回密码-安全验证</h3>
					</div>
					<div class="panel-body">
						<div class="jumbotron" style="padding: 20px;">
							<p style="margin: 0px; font-size: 20px;">您的账号存在风险，为了保障账号安全，登陆前需验证身份</p>
						</div>
						<form id="findform" method="post" class="form-horizontal"
							action="userAction.do?command=toResetPassword">

							<div class="form-group">
								<label class="col-sm-4 control-label" for="userPhoneNumber">手机号:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="userPhoneNumber"
										name="userPhoneNumber" placeholder="请输入您的手机号" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="code">验证码:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="code" name="code"
										placeholder="请输入6位验证码" />
								</div>
								<button type="button" id="sendcode"
									class="btn btn-group btn-warning">发送验证码</button>
							</div>


							<div class="form-group">

								<div class="col-sm-5 col-sm-offset-4"
									style="margin-left: 180px;">
									<!--
                                        	作者：2671242147@qq.com
                                        	时间：2019-01-17
                                        	描述：滑动验证
                                        -->
									<div id="mpanel4"></div>
								</div>
							</div>

							<button type="button" class="btn btn-primary btn-lg btn-block"
								id="sureBtn">确定</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
    <script type="text/javascript" src="js/verify.min.js"></script>
	<script type="text/javascript">
	        //图形验证码是否通过
			var isAccess = false;
		/**
		 * 滑动验证
		 */
		$('#mpanel4').slideVerify({
			type : 2, 
			vOffset : 5, 
			vSpace : 5, 
			imgName : [ '1.jpg', '2.jpg' ],
			imgSize : {
				width : '400px',
				height : '200px',
			},
			blockSize : {
				width : '40px',
				height : '40px',
			},
			barSize : {
				width : '400px',
				height : '40px',
			},
			ready : function() {},
			success : function() {
				isAccess =true;
			},
			error : function() {
				isAccess = false;
			}
		});
	
		//默认表单提交的回调方法
		$.validator.setDefaults({
			submitHandler : function(form) {
			   alert("提交表单");
			   form.submit();
			}
		});
		//自定义规则
		$.validator.addMethod(
			"phone",
			function(value, element) {
				return this.optional(element) || /^\d{11}$/.test(value);
			},
			"请输入正确的手机号"
		);
		$.validator.addMethod(
			"code",
			function(value, element) {
				return this.optional(element) || /^\d{6}$/.test(value);
			},
			"请输入正确的验证码"
		);
		$(function() {
			$("#findform").validate({
				rules : {
					userPhoneNumber : {
						required : true,
						minlength : 11,
						maxlength : 11,
						phone : true,
						remote : {
							url : "userAction.do?command=checkUserByPhone", //后台处理程序
							type : "post", //数据发送方式
							dataType : "text", //接受数据格式   
							data : { //要传递的数据
								userPhoneNumber : function() {
									return $("#userPhoneNumber").val();
								},
							}
						}
					},
					code : {
						required : true,
						minlength : 6,
						maxlength : 6,
						code : true
					}
				},
				messages : {
					userPhoneNumber : {
						required : "请输入您的手机号",
						minlength : "手机号为11位数字",
						maxlength : "手机号为11位数字",
						remote : "该手机号未绑定账号"
					},
					code : {
						required : "请输入您的验证码",
						minlength : "验证码长度为6位数字",
						maxlength : "验证码长度为6位数字"
					}
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					error.addClass("help-block");
					element.parents(".col-sm-5").addClass("has-feedback");
					if (element.prop("type") === "checkbox") {
						error.insertAfter(element.parent("label"));
					} else {
						error.insertAfter(element);
					}
					if (!element.next("span")[0]) {
						$("<span class='glyphicon glyphicon-remove form-control-feedback'></span>").insertAfter(element);
					}
				},
				success : function(label, element) {
					if (!$(element).next("span")[0]) {
						$("<span class='glyphicon glyphicon-ok form-control-feedback'></span>").insertAfter($(element));
					}
				},
				highlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-5").addClass("has-error").removeClass("has-success");
					$(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
				},
				unhighlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-5").addClass("has-success").removeClass("has-error");
					$(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
				}
			});
	
			var times = null;
			//验证码有效期
			var codeValidtime = null;
			//发送验证码按钮计时器
			var codetimer = null;
			//验证码有效期计时器
			var codeValidtimer = null;
			//验证码是否有效，默认无效
			var isValid = false;
			//从服务器接受的验证码
			var valideCode = null;
			//获取验证码按钮
			var getCodeBtn = $("#sendcode");
	
			getCodeBtn.click(sendCode);
			
	        //确定按钮注册点击事件
	        $("#sureBtn").click(function(){
	            if (isAccess == false) {
					alert('请完成图形滑动验证');
					return ;
				}
				
				if (valideCode == null) {
					$("#code-error").html("请重新获取验证码");
					return ;
				}
				if ($("#code").val() != valideCode) {
					$("#code-error").html("验证码错误"+$("#code").val() );
					return ;
				}
				$("#findform").submit();
	        });
	        
			   /**
		         * 发送验证码
		         */
			function sendCode() {
				if ($("#userPhoneNumber-error").val() != "") {
					console.log("手机号错误");
					return;
				} else {
					console.log("手机号：" + userPhoneNumber.value)
					times = 60;
					//发送验证码
					getCode($("#userPhoneNumber").val());
					getCodeBtn.html(times + "S后重新获取验证码");
					getCodeBtn.get(0).disabled = true;
					codetimer = setInterval(changeTime, 1000);
				}
			}
			/**
			 * 获取验证码
			 */
			function getCode(phone) {
				var url = "userAction.do?command=sendCode&phoneNumber=" + phone;
				$.ajax({
					url : url,
					type : "post",
					async : true,
					dataType : "text",
					statusCode : {
						404 : function() {
							alert('页面没找到');
						}
					},
					success : function(data, textStatus, jqXHR) {
						if (data != "发送异常，请重试") { //获取验证码
							valideCode = data;
							startTimer();
						} else {
							alert(data);
						}
						console.log("从服务器传来的数据" + data);
					},
					error : function(e) {
						alert("错误！！");
					}
				});
	
			}
			/**
			 *刷新倒计时
			 */
			function changeTime() {
				times--;
				getCodeBtn.html(times + "S后重新获取验证码");
				if (times <= 0) {
					getCodeBtn.html("重新获取验证码") ;
					clearInterval(codetimer);
					getCodeBtn.get(0).disabled = false;
				}
			}
	
			/**
			 *验证码有效期开始倒计时
			 */
			function startTimer() {
				isValid = true;
				codeValidtime = 300;
				codeValidtimer = setInterval(changecodeValidtime, 1000);
			}
			/**
			 *刷新验证码有效期倒计时
			 */
			function changecodeValidtime() {
				codeValidtime--;
				if (codeValidtime <= 0) {
					isValid = false; //设置验证码无效
					valideCode = null;
					clearInterval(codeValidtimer);
				}
			}
	
		});
	</script>
	 
</body>

</html>
