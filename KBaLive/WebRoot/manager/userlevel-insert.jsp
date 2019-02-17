<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" Content="text/html; Charset=UTF-8">

<title>看吧直播新增用户等级</title>
<link rel="shortcut icon" href="img/indexlog.png " type="image/x-icon" />
<link rel="stylesheet" href="../css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="../css/verify.css">
<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="../js/jquery.validate.min.js"></script>
<script type="text/javascript" src="../js/messages_zh.min.js"></script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"56404",secure:"56411"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-197" data-genuitec-path="/KBaLive/WebRoot/find-password.jsp">
	<div class="container" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-197" data-genuitec-path="/KBaLive/WebRoot/find-password.jsp">
		<div class="row">
			<div class="col-sm-8 col-sm-offset-2">
				<div class="panel panel-warning">
					<div class="panel-heading">
						<h3 class="panel-title" style="font-size: 25px;">新增用户等级</h3>
					</div>
					<div class="panel-body">
						<div class="jumbotron" style="padding: 20px;">
							<p style="margin: 0px; font-size: 20px;">为了您输入的数据有效，请严格按照指定规则填写</p>
						</div>
						<form id="findform" method="post" class="form-horizontal">

							<div class="form-group">
								<label class="col-sm-4 control-label" for="userLevelName">等级名称:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="userLevelName"
										name="userLevelName" placeholder="必须不大于三十个字符" />
								</div>
							</div>
                            <div class="form-group">
								<label class="col-sm-4 control-label" for="userLowInvest">最低充值:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="userLowInvest"
										name="userLowInvest" placeholder="必须为数字" />
								</div>
							</div>
							 <div class="form-group">
								<label class="col-sm-4 control-label" for="userHighInvest">最高充值:</label>
								<div class="col-sm-5">
									<input type="text" class="form-control" id="userHighInvest"
										name="userHighInvest" placeholder="必须为数字" />
								</div>
							</div>
							
                            <div class="form-group">
								<label class="col-sm-4 control-label" for="userlevelRemark">等级备注:</label>
								<div class="col-sm-5">
									<textarea  class="form-control"  placeholder="最高充值必须大于最低充值" 
									id="userlevelRemark" name="userlevelRemark"></textarea>
								</div>
							</div>

                            <div class="form-group">
							<div class="row">
                                <div class="col-xs-4">
							       <button type="button" class="btn btn-primary btn-lg btn-block" id="sureBtn" onclick="refreshParent()">确定</button>
								</div>
                                <div class="col-xs-4"></div>
								<div class="col-xs-4">
							       <button type="button" class="btn btn-primary btn-lg btn-block" id="falseBtn" onclick="closeWindow()">取消</button>
								</div>
                            </div>
                            </div>

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
			   alert("提交表单");
			   form.submit();
			}
		});
		//userLevelName
		$.validator.addMethod(
			"userlevelName",
			function(value, element) {
				return this.optional(element) || /^[\u4e00-\u9fffa-zA-Z]{1,30}$/.test(value);
			},
			"请输入正确的主播等级名称"
		);
		//userLowInvest
		$.validator.addMethod(
			"lowInvest",
			function(value, element) {
				return this.optional(element) || /^[0-9]+$/.test(value);
			},
			"请输入正确的直播时长"
		);
		//userHighInvest
		$.validator.addMethod(
			"highInvest",
			function(value, element) {
				return this.optional(element) || /^[0-9]+$/.test(value);
			},
			"请输入正确的直播时长"
		);
		//userlevelRemark
		$.validator.addMethod(
			"userlevelRemark",
			function(value, element) {
				return this.optional(element) || /^[\w]{1,200}$/.test(value);
			},
			"请输入正确的主播等级备注"
		);
		$(function() {
			$("#findform").validate({
				rules : {
					userLevelName : {
						required : true,
						minlength : 1,
						maxlength : 30,
						userlevelName : false,
						remote : {
							url : "backStageUserLevelAction.do?command=checkUserLevelByName", //后台处理程序
							type : "post", //数据发送方式
							dataType : "text", //接受数据格式   
							data : { //要传递的数据
								userLevelName : function() {
									return $("#userLevelName").val();
								}
							}
						}
					},
					userLowInvest : {
						required : true,
						minlength : 1,
						maxlength : 10,
						lowInvest : true
					},
					userHighInvest : {
						required : true,
						minlength : 1,
						maxlength : 10,
						highInvest : true
					},
					userlevelRemark : {
						required : true,
						minlength : 1,
						maxlength : 200,
						userlevelRemark : true
					}
				}, 
				messages : {
					userLevelName : {
						required : "请输入等级名称",
						minlength : "名称为1位字符",
						maxlength : "名称为30位字符",
						remote : "该等级名称已存在"
					},
					userLowInvest : {
						required : "请输入最低充值金额",
						minlength : "密码长度为1位字符",
						maxlength : "密码长度为10位字符"
					},
					userHighInvest : {
						required : "请输入最高充值金额",
						minlength : "职位长度为1位数字",
						maxlength : "职位长度为10数字"
					},
					userlevelRemark : {
						required : "请输入备注",
						minlength : "备注长度为1位字符",
						maxlength : "备注长度为200位字符"
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
			})		
			
			 function refreshParent() {
                 var name=$("#userLevelName").val();
                 var minTime=$("#userLowInvest").val();
                 var maxTime=$("#userHighInvest").val();
                 var remark=$("#userlevelRemark").val();
                 if(name.length!=0){
                 	 $.ajax({
                     url:"backStageUserLevelAction.do?command=insertUserLevel",
                     type:"post",
                     dataType:"text",
                     async:false,
                     data:{
                          userLevelName:name,userLowInvest:minTime,userHighInvest:maxTime,userlevelRemark:remark
                     },
                     success:function(result){
                          if(result){
                              window.location.href="backStageUserLevelAction.do";
                          }else{
                             console.log("添加失败");
                          }
                     },
                     error:function(XMLHttpRequest,textStatus,errorThrown){
                         console.log("添加失败");
                     }
                     });
                 }
                 else{
                 	alert("名称不能为空")
                 }
                
             }  
             
             function closeWindow(){
                     window.location.href="backStageUserLevelAction.do";      
	            
             }
	</script>
</body>

</html>
