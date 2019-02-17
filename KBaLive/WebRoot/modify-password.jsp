<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML >
<html>
<head>
<meta charset="UTF-8">
<title>看吧直播找回密码-重置密码</title>
<link rel="shortcut icon" href="img/logo.png " type="image/x-icon" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript" src="js/messages_zh.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title" style="font-size: 25px;">个人中心-修改密码</h3>
					</div>
					<div class="panel-body">
						<div class="jumbotron" style="padding: 20px;">
							<p style="margin: 0px; font-size: 20px;">
								您正在修改的账号是：<span id="userName">${loginUser.userName}</span>
							</p>
						</div>
						<form id="resetpasswordform" method="post" class="form-horizontal"
							action="userAction.do?command=modifyUserPassword">

							<div class="form-group">
								<label class="col-sm-4 control-label" for="userPassword">新密码:</label>
								<div class="col-sm-7">
									<input type="hidden" class="form-control" id="userName"
										value="${loginUser.userName}" name="userName" readonly="true"/> <input
										type="password" class="form-control" id="userPassword"
										name="userPassword" placeholder="6-20位至少要包含大小写字母，及一个数字" />
								</div>
							</div>

							<div class="form-group">
								<label class="col-sm-4 control-label" for="repassword">确认新密码:</label>
								<div class="col-sm-7">
									<input type="password" class="form-control" id="repassword"
										name="repassword" placeholder="请再次输入您的新密码" />
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

	<script type="text/javascript">
		//默认表单提交的回调方法
		$.validator.setDefaults({
			submitHandler : function(form) {
				alert("submitted!");
				form.submit();
			}
		});
		//自定义规则
		$.validator.addMethod(
			"pwd",
			function(value, element) {
				return this.optional(element) || /^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![A-Za-z]+$)[A-Za-z0-9]{6,20}$/.test(value);
			},
			"您的密码必须:6-20位至少要包含大小写字母，及一个数字"
		);
		$(function() {
			$("#resetpasswordform").validate({
				rules : {
					userPassword : {
						required : true,
						minlength : 6,
						maxlength : 20,
						pwd : true
					},
					repassword : {
						required : true,
						minlength : 6,
						maxlength : 20,
						equalTo : "#userPassword",
						pwd : true
					}
				},
				messages : {
					userPassword : {
						required : "请输入您的新密码",
						minlength : "新密码长度至少6位",
						maxlength : "新密码长度最多20位"
					},
					repassword : {
						required : "请再次输入您的新密码",
						minlength : "新密码长度至少6位",
						maxlength : "新密码长度最多20位",
						equalTo : "两次输入的密码不匹配"
					}
				},
				errorElement : "em",
				errorPlacement : function(error, element) {
					// 添加 `help-block` 类到错误元素上
					error.addClass("help-block");
	
					// 添加 `has-feedback` 类 到父元素 div.form-group
					// 为了添加 图标 到input
					element.parents(".col-sm-7").addClass("has-feedback");
	
					if (element.prop("type") === "checkbox") {
						error.insertAfter(element.parent("label"));
					} else {
						error.insertAfter(element);
					}
					// 添加 span 元素, 如果不存在, 就在给他添加classes.
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
					$(element).parents(".col-sm-7").addClass("has-error").removeClass("has-success");
					$(element).next("span").addClass("glyphicon-remove").removeClass("glyphicon-ok");
				},
				unhighlight : function(element, errorClass, validClass) {
					$(element).parents(".col-sm-7").addClass("has-success").removeClass("has-error");
					$(element).next("span").addClass("glyphicon-ok").removeClass("glyphicon-remove");
				}
			});
	
			//确定按钮注册点击事件
			$("#sureBtn").click(function() {
				$("#resetpasswordform").submit();
			});
	
		});
	</script>
</body>
</html>