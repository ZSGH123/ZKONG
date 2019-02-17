
var loginbtn=null;
var phone=null;
var pwd=null;

var one=null;
var two=null;
var three=null;
var four=null;
//命令
var command=null;

$(function() {
	//初始化
	init();

});

function init(){
	phone=document.getElementById("phone");
	pwd=document.getElementById("password");
	loginbtn=document.getElementById("login");
	
	one=document.getElementById("one");
    two=document.getElementById("two");
    three=document.getElementById("three");
    four=document.getElementById("four");
	//注册获得焦点事件
	phone.onfocus=adjustInput;
	pwd.onfocus=adjustInput;
	//注册失去焦点事件
	phone.onblur=phoneInputBlur;
	pwd.onblur=checkPwd;
	//注册登陆事件
	loginbtn.onclick=login;	
}

/**
 * 处理用户登陆
 */
function login(){
	//1.检测是否通过
	if(check()){//通过
		//发送ajax登陆请求
		sendLoginReq();
	}else{
		alert("登陆异常，请重试");
	}
}

/**
 * 发送登陆请求
 */
function sendLoginReq() {
	
	var method=null;
	var remenber=$("#remeberpassword").val();
	if(command=="checkUserByPhone"){
		method=0;
	}else if(command=="checkUserByName"){
		method=1;
	}
	//发送请求
	$.ajax({
		url : "userAction.do?command=generalLogin",
		type : "post",
		async : true,
		dataType : "text",
		data : "userPhoneNumber="+phone.value+"&userPassword="+pwd.value.trim()+"&method="+method+
		       "&remeberPassword="+remenber,
		statusCode : {
			404 : function() {
				console.log("页面没找到");
			}
		},
		success : function(data, textStatus, xmlhttp) {
			if(data=="密码错误"){
			removeAllChild(three);
		   	showTip(four,data,pwd,"crimson",true,"red");
			
			}else{
				location.href=data;
			}
			console.log("success : "+data);
		},
		error : function(e) {
			alert("网络错误！，请重试"+e);
		}
	});
}

/**
 * 处理手机输入框失去焦点
 */
function phoneInputBlur(){
	var account=phone.value;
	if(checkPhone()){//手机
		command="checkUserByPhone";
	}else if(checkUserName()){//用户名
		command="checkUserByName";
	}else{
		return;
	}
	//发送ajax请求
	selectUser(command,account,null);
	console.log("帐号"+account+" 命令"+command);
}

/**
 * 查询账户是否存在
 */
function selectUser(command, account, method) {
	var url = "userAction.do?command=" + command ;
	var tip="用户不存在";
	if(command=="checkUserByPhone"){
		url+="&userPhoneNumber=" + account;
		tip="该手机号还未注册";
	}else if(command=="checkUserByName"){
		url+="&userName=" + account;
	}
	if (method != null) {
		url += "&method=" + method;
	}else{
		$.ajax({
			url : url,
			type : "post",
			async : true,
			dataType : "text",
			statusCode : {
				404 : function() {
					alert('page not found');
					//location.href="";
				}
			},
			success : function(data, textStatus, jqXHR) {
				if(data!="true"){
					 removeAllChild(one);
				   	 showTip(two,tip,phone,"crimson",true,"red");
				}
				console.log("从服务器传来的数据" + data);
			},
			error : function(e) {
				alert("错误！！");
			}
		});	
	}	
}

/**
 * 显示提示信息，并改变输入框风格
 * @param {Object} parent
 * @param {Object} str
 * @param {Object} inputp
 * @param {Object} tipColor
 * @param {Object} isAddImg
 * @param {Object} borderColor
 */
function showTip(parent,str,inputp,tipColor,isAddImg,borderColor){
	removeAllChild(parent);
	parent.style.color=tipColor;
	if(isAddImg){
	  var inode=document.createElement("img");
	  inode.src="img/redfork.png";
	  inode.align="center";
	  var tnode=document.createTextNode(" "+str);
	  parent.appendChild(inode);
	  parent.appendChild(tnode);
	}else{
	  var tnode=document.createTextNode(" "+str);
	  parent.appendChild(tnode);
	}
	inputp.style.borderColor=borderColor;	
}

/**
 * 
 * 删除所有儿子节点
 * @param {Object} parnet
 */
function removeAllChild(parnet){
	var childnode=parnet.childNodes;
	var len=childnode.length;
	for(var i=0;i<len;i++){	
		parnet.removeChild(childnode[0]);
	}
}

/**
 * 调整输入框的风格
 */
function adjustInput(){
	this.style.borderColor="dodgerblue";	
}

/**
 * 11位移动电话号码的第一位和第二位为"13“，”15”，”18”
 */
function checkPhone(){
	var value=phone.value;
	var regex=/^\d{11}$/;
	if(value.length==0){
		removeAllChild(one);
		showTip(two,"请输入您的手机号或用户名",phone,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(one,"√ 通过",phone,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(two);
		  return true;
	   }else{
		   removeAllChild(one);
	   	  showTip(two,"请输入正确格式手机号或用户名",phone,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证用户名 ：中、英文均可，最长15个英文或15个汉字
 */
function checkUserName(){
	var value=phone.value;
	//var regex=/[\u4e00-\u9fa5]/;//汉字正则表达式
	var regex=/^[a-zA-Z\u4e00-\u9fa5]{2,15}$/;
	if(value.length==0){
		removeAllChild(one);
		showTip(two,"请输入您的手机号或用户名",phone,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
		  removeAllChild(two);
	  	  showTip(one,"√ 通过",phone,"mediumseagreen",false,"#D3D3D3");
		  return true;
	   }else{
		  removeAllChild(one);
	   	  showTip(two,"请输入正确格式的手机号或用户名",phone,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证密码 ：8-20位要至少要包含一个大小写字母，及一个数字
 */
function checkPwd(){
	var value=pwd.value.trim();
	var regex=/^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![A-Za-z]+$)[A-Za-z0-9]{8,20}$/;
	if(value.length==0){
		removeAllChild(three);
		showTip(four,"请输入您的密码",pwd,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(three,"√ 通过",pwd,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(four);
		  return true;
	   }else{
		  removeAllChild(three);
	   	  showTip(four,"请输入正确格式的密码",pwd,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 检查表单验证是否通过
 */
function check(){
	if(one.innerHTML.trim()!="√ 通过"||three.innerHTML.trim()!="√ 通过"){
		return false;
	}else{
		return true;
	}
}

