var times=null;
//验证码有效期
var codeValidtime=null;
//发送验证码按钮计时器
var codetimer=null; 
//验证码有效期计时器
var codeValidtimer=null; 
//验证码是否有效，默认无效
var isValid=false;
//从服务器接受的验证码
var valideCode=null;

var body=null;
var phone=null;
var userName=null;
var pwd=null;
var repwd=null;
var code=null;
var getCodeBtn=null;
var registerBtn=null;

var one=null;
var two=null;
var three=null;
var four=null;
var five=null;
var six=null;
var seven=null;
var eight=null;
var nine=null;

//命令
var command=null;

$(function() {
	//初始化
	init();

});

function init(){
	phone=$("#phone").get(0);
	userName=$("#userName").get(0);
	pwd=$("#pwd").get(0);
	repwd=$("#repwd").get(0);
	code=$("#code").get(0);
	getCodeBtn=$("#getcode").get(0);
	registerBtn=$("#register").get(0);
	
	one=$("#one").get(0);
    two=$("#two").get(0);
    three=$("#three").get(0);
    four=$("#four").get(0);
    five=$("#five").get(0);
    six=$("#six").get(0);
    seven=$("#seven").get(0);
    eight=$("#eight").get(0);
    nine=$("#nine").get(0);
    
	//注册获得焦点事件
	phone.onfocus=adjustInput;
	userName.onfocus=adjustInput;
	pwd.onfocus=adjustInput;
	repwd.onfocus=adjustInput;
	code.onfocus=adjustInput;
	//注册失去焦点事件
	phone.onblur=phoneInputBlur;
	userName.onblur=userNameInputBlur;
	pwd.onblur=checkPwd;
	repwd.onblur=checkRePwd;
	code.onblur=function(){this.style.borderColor="#D3D3D3";};
	
	//getCodeBtn.disabled=true;
	//获取验证码按钮注册事件
	getCodeBtn.onclick=sendCode;
	//注册按钮注册事件
	registerBtn.onclick=registerUser;
}


/**
 * 用户注册
 */
function registerUser(){
	//检测验证是否通过
	if(check()){
		if(valideCode==null){
			alert("请点击获取短信验证码");
			return;
		}
		if(code.value!=valideCode){
			alert("短信验证码错误");
			return;
		}else{//发起用户注册请求
			sendRegisterReq();
		}	
	}  	  
}
/**
 * 发起注册请求
 */
function sendRegisterReq(){
	//发送请求
	$.ajax({
		url : "userAction.do?command=generalRegister",
		type : "post",
		async : true,
		dataType : "text",
		data : "userPhoneNumber="+phone.value.trim()+"&userPassword="+pwd.value.trim()+
		       "&userName="+userName.value.trim(),
		statusCode : {
			404 : function() {
				console.log("页面没找到");
			}
		},
		success : function(data, textStatus, xmlhttp) {
			if(data!="indexAction.do"){
				alert("注册错误！，请稍后重试");
			}
			location.href=data;
			console.log("success : "+data);
		},
		error : function(e) {
			alert("网络错误！，请重试"+e);
		}
	});
}
/**
 * 检查表单验证是否通过
 */
function check(){
	if(one.innerHTML.trim()!="√ 通过"||three.innerHTML.trim()!="√ 通过"||
			five.innerHTML.trim()!="√ 通过"||seven.innerHTML.trim()!="√ 通过"||checkCode()==false){
		return false;
	}else{
		return true;
	}
}

/**
 * 发送验证码
 */
function sendCode(){
	if(one.innerHTML.trim()!="√ 通过"){
		console.log("手机号错误");
		return ;
	}else{
		console.log("手机号："+phone.value)
		times=60;
		//发送验证码
		getCode(phone.value);
	 	getCodeBtn.value=times+"S后重新获取验证码";
	 	getCodeBtn.disabled=true;
	 	codetimer=setInterval(changeTime,1000);
	}   
}
/**
 * 获取验证码
 */
function getCode(phone){
	var url="userAction.do?command=sendCode&phoneNumber="+phone;
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
			if(data!="发送异常，请重试"){//获取验证码
				valideCode=data; 
				startTimer();
			}else{
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
function changeTime(){
	times--;
	getCodeBtn.value=times+"S后重新获取验证码";
	if(times<=0){
		getCodeBtn.value="重新获取验证码";
		clearInterval(codetimer);
		getCodeBtn.disabled=false;
	}
}

/**
 *验证码有效期开始倒计时
 */
function startTimer(){
	isValid=true;
	codeValidtime=300;
	codeValidtimer=setInterval(changecodeValidtime,1000);
}
/**
 *刷新验证码有效期倒计时
 */
function changecodeValidtime(){
	codeValidtime--;
	if(codeValidtime<=0){
		isValid=false;//设置验证码无效
		valideCode=null;
		clearInterval(codeValidtimer);
	}
}

/**
 * 处理手机输入框失去焦点
 */
function phoneInputBlur(){
	var account=phone.value;
	if(checkPhone()){//手机
		command="checkUserByPhone";
	}else{
		return;
	}
	//发送ajax请求
	selectUser(command,account,null);
	console.log("帐号"+account+" 命令"+command);
}
/**
 * 处理用户输入框失去焦点
 */
function userNameInputBlur(){
	var account=userName.value;
	if(checkUserName()){//用户名
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
	var tip=null;
	//显示正确消息的对象
	var parent=one;
	//显示错误信息的对象
	var tipParent=two;
	//输入框
	var input=phone;
	if(command=="checkUserByPhone"){
		url+="&userPhoneNumber=" + account;
		tip="该手机号已注册";
	}else if(command=="checkUserByName"){
		url+="&userName=" + account;
		tip="该用户名已被占用";
		parent=three;
		tipParent=four;
		input=userName;
	}
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
				if(data=="true"){
					 removeAllChild(parent);
				   	 showTip(tipParent,tip,input,"crimson",true,"red");
				}
				console.log("从服务器传来的数据" + data);
			},
			error : function(e) {
				alert("错误！！");
			}
		});		
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
		showTip(two,"请输入您的手机号",phone,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(one,"√ 通过",phone,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(two);  
		  return true;
	   }else{
		   removeAllChild(one);
	   	  showTip(two,"请输入正确格式手机号",phone,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证用户名 ：中、英文均可，最长15个英文或15个汉字
 */
function checkUserName(){
	var value=userName.value;
	var regex=/^[a-zA-Z\u4e00-\u9fa5]{2,15}$/;
	if(value.length==0){
		removeAllChild(three);
		showTip(four,"请输入您的用户名",userName,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(three,"√ 通过",userName,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(four);
		  return true;
	   }else{
		   removeAllChild(three);
	   	  showTip(four,"请输入正确格式的用户名",userName,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证密码 ：6-20位要至少要包含一个大小写字母，及一个数字
 */
function checkPwd(){
	var value=pwd.value.trim();
	var regex=/^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![A-Za-z]+$)[A-Za-z0-9]{6,20}$/;
	if(value.length==0){
		removeAllChild(five);
		showTip(six,"请输入您的密码",pwd,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  showTip(five,"√ 通过",pwd,"mediumseagreen",false,"#D3D3D3");
	  	  removeAllChild(six);
		  return true;
	   }else{
		   removeAllChild(five);
	   	  showTip(six,"请输入正确格式的密码",pwd,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 验证重复密码 ：6-20位要至少要包含一个大小写字母，及一个数字
 */
function checkRePwd(){
	var pwdvalue=pwd.value.trim();
	var value=repwd.value.trim();
	var regex=/^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![A-Za-z]+$)[A-Za-z0-9]{6,20}$/;
	if(value.length==0){
		removeAllChild(seven);
		showTip(eight,"请再次输入您的密码",repwd,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
	  	  if(pwdvalue==value){
	  	    showTip(seven,"√ 通过",repwd,"mediumseagreen",false,"#D3D3D3");
	  	    removeAllChild(eight);
		    return true;
		  }else{
			removeAllChild(seven);
		    showTip(eight,"两次输入的密码不一致",repwd,"crimson",true,"red");
		    return false;
		  }
	   }else{
		   removeAllChild(seven);
	   	  showTip(eight,"请输入正确格式的重复密码",repwd,"crimson",true,"red");
		  return false;
	   }
	}
}

/**
 * 检查验证码 ：6位数字
 */
function checkCode(){
	var value=code.value;
	var regex=/^\d{6}$/;
	if(value.length==0){
		removeAllChild(ten);
		showTip(nine,"请输入您的验证码",code,"crimson",true,"red");
		return false;
	}else{
	  if(regex.test(value)){
		    removeAllChild(nine);
		    return true;
	   }else{
		  removeAllChild(ten);
	   	  showTip(nine,"请输入正确格式的验证码",code,"crimson",true,"red");
		  return false;
	   }
	}
}