var startlength=300;
var danmuspan1=null;
var danmuspan2=null;
var danmu=null;
var startHeight=25;

var a=null;
var b=null;

//获得弹幕总div
var danmuall=null;
//生成一条弹幕div
var danmudivObj=null;
//生成两个span
var span1=null;
var span2=null;
//设置开关
var kai=true;
//用户名字
var userName=null;
//内容
var context=null;
//房间号
var myroomId=null;

function init(){
	addLength();
	addModel("发送者名字","你发送的内容");
	//改变输入框
	var denlucg=document.getElementById("danmuz1a");
	denlucg.onclick=changeShuru;
	//弹幕透明度
	var wu=document.getElementById("wu");
	wu.onclick=ChangeToumin;
	var di=document.getElementById("di");
	di.onclick=ChangeToumin;
	var zhong=document.getElementById("zhong");
	zhong.onclick=ChangeToumin;
	var gao=document.getElementById("gao");
	gao.onclick=ChangeToumin;
	//改变弹幕位置
	var full=document.getElementById("full");
	full.onclick=ChangeWeizhi;
	var bottom=document.getElementById("bottom");
	bottom.onclick=ChangeWeizhi;
	var top=document.getElementById("top");
	top.onclick=ChangeWeizhi;
	
	//键盘事件
    MykeyEvent();
    //发送弹幕2
    var quanpingdanmuright=document.getElementById("qupingdanmuright");
    quanpingdanmuright.onclick=sendDanmu2;
    
    //改变贡献榜
    var gxzb=document.getElementById("gxzb");
	var gz=document.getElementById("gz");
	var fst=document.getElementById("fst");
	gxzb.onclick=ChangGongxian;
	gz.onclick=ChangGongxian;
    fst.onclick=ChangGongxian;
    
    //监听
    document.addEventListener("webkitfullscreenchange", function() {
    	var quanpingdanmu=document.getElementById("qupingdanmu");
    	quanpingdanmu.style.display="none";
    	//重启弹幕
    	RestartDanmu();
    }, true);
    
    //鱼吧与视频显示改变
    var hudong1=document.getElementById("hudong1");
    hudong1.onclick=ChangeYuba;
	var hudong2=document.getElementById("hudong2");
	hudong2.onclick=ChangeYuba;
	
	//检查是否登陆
	checkLogin();
	
	//关注
	$('#zbgzsp1').onclick=forBook;
}

//重启弹幕
function RestartDanmu(){
	var guidongdanmu=document.getElementById("guidongdanmu");
	guidongdanmu.style.display="none";
	
	setTimeout("StartDanmu()",10000);
}

//启动弹幕
function StartDanmu(){
	var guidongdanmu=document.getElementById("guidongdanmu");
	guidongdanmu.style.display="block";
}

//键盘事件
function MykeyEvent(){
	//按下事件
	document.onkeydown = function(event) {
		var e = event || window.event;
		var main=document.getElementById("main");
		var quanpingdanmu=document.getElementById("qupingdanmu");
		if(main.offsetHeight>500){
			if(e && e.keyCode == 13) { // enter 键
				//要做的事情
				if(kai){
					quanpingdanmu.style.display="block";
					kai=false;
				}else{
					quanpingdanmu.style.display="none";
					kai=true;
				}
		  }
		}
	};

	//enter事件
	var qupingdanmuleft=document.getElementById("qupingdanmuleft");
	qupingdanmuleft.onkeydown = function(event) {
		var e = event || window.event;
		if(e && e.keyCode == 13) { // enter 键
			//要做的事情
            sendDanmu2();
		}
	};
}

//发送弹幕方法2
function sendDanmu2(){
	var danmushurukuang=document.getElementById("qupingdanmuleft");
	var context=danmushurukuang.value;
	if(context!=""){ 
		if(context.length<=25) {//限制弹幕长度
			//右侧弹幕
			addModel(userName, context);
			danmushurukuang.value = null;
			//屏幕滚动弹幕
			var dakaidanmu=document.getElementById("dakaidanmu");
			if(dakaidanmu.title=="关闭弹幕") { //判断滚动弹幕是否打开
				moveWordModel(context);
			}
		}else{//长度过长
			danmushurukuang.value=context.substring(0,25);
		}
	}
	//滚动条置于最低端
	putDibu();
	
	//增加长度
	addLength();
}

//增加宽度
function addLength(){
	danmuspan1=document.getElementsByClassName("clayoucedanmuspan1");
	danmuspan2=document.getElementsByClassName("clayoucedanmuspan2");
	for (var i=0;i<danmuspan2.length;i++) {
		b=danmuspan1[i].offsetWidth+danmuspan2[i].offsetWidth;
		if(b>startlength){
			danmu=document.getElementsByClassName("youcedanmu");
			a=danmu[i];
			wq(a,b);
		}
	}
}

//发送弹幕模板方法
function addModel(a,b){
	//获得弹幕总div
    danmuall=document.getElementById("danmu2");
	
	//生成一条弹幕div
	danmudivObj=document.createElement("div");
	danmudivObj.className="youcedanmu";

	//生成两个span
	span1=document.createElement("span");
	span1.className="clayoucedanmuspan1";
	span1.innerHTML=a+"：";

	span2=document.createElement("span");
	span2.className="clayoucedanmuspan2";
	span2.innerHTML=b;

	//将span加入一条弹幕div
	danmudivObj.appendChild(span1);
	danmudivObj.appendChild(span2);
	
	//将这条弹幕div加入弹幕总div中
	danmuall.appendChild(danmudivObj);
}

//递归方法
function wq(obja,objb) {
	if(objb>startlength){
    //div高度+25
	startHeight = startHeight + 25;
	obja.style.height = startHeight + "px";
	startlength = startlength + 300;
	//递归调用
	wq(a,b);
	}
	//数值回归
	startlength=300;
	startHeight=25;
}

//改变输入框
function changeShuru(){
	var danmuz=document.getElementById("danmuz");
	danmuz.style.display="none";
	var danmushurukuang=document.getElementById("danmushurukaung");
	danmushurukuang.style.display="block";
	var danmusubmit=document.getElementById("danmusubmit");
	danmusubmit.style.backgroundColor="coral";
	
	danmusubmit.onclick=sendDanmu;
	danmushurukuang.onkeydown = function(event) {
		var e = event || window.event;
		if(e && e.keyCode == 13) { // enter 键
			//要做的事情输出弹幕
            sendDanmu();
            //放置于全局容器
		}
	};
}

//输出弹幕
function sendDanmu(){
	var danmushurukuang=document.getElementById("danmushurukaung");
	context=danmushurukuang.value;
	if(context!=""){ 
		if(context.length<=25) {//限制弹幕长度
			//右侧弹幕
			userName=document.getElementById("guidongdanmubox").title;
			addModel(userName, context);
			danmushurukuang.value = null;
			
			//发给服务器
			$.ajax({
				type : 'post',
				url : 'userAction.do?command=sendDanmu&loginUserName='+userName+'&context='+context+'&roomId='+roomId,
				//async : true,
		        dataType: 'text',
				success : function(data) {

				}
			});

			//屏幕滚动弹幕
			var dakaidanmu=document.getElementById("dakaidanmu");
			if(dakaidanmu.title=="关闭弹幕") { //判断滚动弹幕是否打开
				moveWordModel(context);
			}
		}else{//长度过长
			danmushurukuang.value=context.substring(0,25);
		}
	}
	//滚动条置于最低端
	putDibu();
	
	//增加长度
	addLength();
}

//滚动条置于最低端
function putDibu(){
	var danmu2=document.getElementById("danmu2");
	danmu2.scrollTop = danmu2.scrollHeight;
}



//弹幕div宽度与高度
var divW=null;
var divH=null;
//弹幕位置高度（随机）
var height=null;
//弹幕
var span=null;
//定时器
var timer=null;
//divd对象
var Div=null;
//滚动弹幕span集合
var spans=null;


//发送滚动弹幕模板方法
function moveWordModel(context){
	//清除计时器
	clearInterval(timer);
	
	divW=document.getElementById("guidongdanmubox").offsetWidth;
	divH=document.getElementById("guidongdanmubox").offsetHeight;
	height= parseInt(Math.random() * (divH-20)) ;
	span = document.createElement('span');
	
	span.style.right = 0 + 'px';		
	span.style.top = height +'px';
	span.style.fontSize=20+'px';
    span.innerHTML = context;
    span.className="gundong";
    
    Div=document.getElementById("guidongdanmubox");
    //添加到div中
    Div.appendChild(span);
    //使弹幕移动
    timer = setInterval(moveWord, 10);
}

//弹幕滚动方法
function moveWord() {
	spans = document.getElementsByClassName("gundong");
	for(var i = 0; i < spans.length; i++) {
		spans[i].style.left = spans[i].offsetLeft - 2 + 'px';
		if(spans[i].offsetLeft < 2) {
			Div = document.getElementById("guidongdanmubox");
			Div.removeChild(Div.childNodes[0]);
		}
	}
}

//获得音量左侧长度
function getX(obj) {
	var parObj = obj;
	var left = obj.offsetLeft;
	while(parObj = parObj.offsetParent) {
		left += parObj.offsetLeft;
	}
	return left;
}

//改变音量位置
function DisplayCoord(event) {
	var left, oDiv, divleft, divright;
	oDiv = document.getElementById("yinliangkz");
	left = event.clientX - getX(oDiv) + document.body.scrollLeft;
	if(left<=100 && left>=0){
	divleft=document.getElementById("yinliangkzleft");
	divleft.style.width=left+"px";
	divright=document.getElementById("yinliangkzright");
	divright.style.width=100-left+"px";
	}
}

//弹幕透明度
function ChangeToumin(){
	//得到无，低，中，高四个挡位
	var wu=document.getElementById("wu");
	var di=document.getElementById("di");
	var zhong=document.getElementById("zhong");
	var gao=document.getElementById("gao");
	//弹幕颜色div
	var gundongdanmubox=document.getElementById("guidongdanmubox");
	
	if(wu==this){
		wu.style.color="coral";
		di.style.color="#888";
		zhong.style.color="#888";
		gao.style.color="#888";
		gundongdanmubox.style.opacity=1;
	}
	else if(di==this){
		wu.style.color="#888";
		di.style.color="coral";
		zhong.style.color="#888";
		gao.style.color="#888";
		gundongdanmubox.style.opacity=0.75;
	}
	else if(zhong==this){
		wu.style.color="#888";
		di.style.color="#888";
		zhong.style.color="coral";
		gao.style.color="#888";
		gundongdanmubox.style.opacity=0.5;
	}
	else{
		wu.style.color="#888";
		di.style.color="#888";
		zhong.style.color="#888";
		gao.style.color="coral";
		gundongdanmubox.style.opacity=0.25;
	}
}

//弹幕位置改变
function ChangeWeizhi(){
	//得到全屏，下面，上面三个挡位
	var full=document.getElementById("full");
	var bottom=document.getElementById("bottom");
	var top=document.getElementById("top");
	//弹幕宽度div
	var gundongdanmubox=document.getElementById("guidongdanmubox");
	var gundongdanmu=document.getElementById("guidongdanmu");
	
	if(this==top){
		gundongdanmubox.style.top=0+"px"
		gundongdanmubox.style.height=50+"%";
		full.style.background="url(controlImgs/kzg1.png) no-repeat 0";
		bottom.style.background="url(controlImgs/kzh1.png) no-repeat 0";
		top.style.background="url(controlImgs/kzi2.png) no-repeat 0";
	}
	else if(this==bottom){
		gundongdanmubox.style.top=document.getElementById("main").offsetHeight/2+"px"
		gundongdanmubox.style.height=50+"%";
		full.style.background="url(controlImgs/kzg1.png) no-repeat 0";
		bottom.style.background="url(controlImgs/kzh2.png) no-repeat 0";
		top.style.background="url(controlImgs/kzi1.png) no-repeat 0";
		
		//弹幕上移，防止溢出
		spans = document.getElementsByClassName("gundong");
		for(var i=0;i<=spans.length;i++){
			spans[i].style.top=spans[i].style.top.split("px",1)-document.getElementById("main").offsetHeight/2;
			if(spans[i].style.top.split("px",1)>document.getElementById("main").offsetHeight/2){
				spans[i].style.display="none";
			}
		}
	}
	else{
		gundongdanmubox.style.top=0+"px"
		gundongdanmubox.style.height=100+"%";
		full.style.background="url(controlImgs/kzg2.png) no-repeat 0";
		bottom.style.background="url(controlImgs/kzh1.png) no-repeat 0";
		top.style.background="url(controlImgs/kzi1.png) no-repeat 0";		
	}
}

//贡献周榜，贵族，粉丝团
function ChangGongxian(){
	//得到三个DIv
	var gxzb=document.getElementById("gxzb");
	var gz=document.getElementById("gz");
	var fst=document.getElementById("fst");
	
	//得到三个模板
	var moban1=document.getElementById("moban1");
	var moban2=document.getElementById("moban2");
	var moban3=document.getElementById("moban3");
	
	if(gxzb==this){
		//更改背景颜色，边框
		this.style.backgroundColor="#fff";
		this.style.borderBottom="0px";
		this.style.borderLeft="0px";
		gz.style.backgroundColor="#eee";
		gz.style.borderBottom="1px";
		gz.style.borderLeft="1px";
		fst.style.backgroundColor="#eee";
		fst.style.borderBottom="1px";
		fst.style.borderLeft="1px";
		
		//显示正确模板
		moban1.style.display="block";
		moban2.style.display="none";
		moban3.style.display="none";
	}
	if(gz==this){
		//更改背景颜色，边框
		this.style.backgroundColor="#fff";
		this.style.borderBottom="0px";
		this.style.borderLeft="0px";
		gxzb.style.backgroundColor="#eee";
		gxzb.style.borderBottom="1px";
		gxzb.style.borderRight="1px";
		fst.style.backgroundColor="#eee";
		fst.style.borderBottom="1px";
		fst.style.borderLeft="1px";
		
		//显示正确模板
		moban2.style.display="block";
		moban1.style.display="none";
		moban3.style.display="none";
	}
	if(fst==this){
		//更改背景颜色，边框
		this.style.backgroundColor="#fff";
		this.style.borderBottom="0px";
		this.style.borderLeft="0px";
		gxzb.style.backgroundColor="#eee";
		gxzb.style.borderBottom="1px";
		gxzb.style.borderRight="1px";
		gz.style.backgroundColor="#eee";
		gz.style.borderBottom="1px";
		gz.style.borderRight="1px";
		
		//显示正确模板
		moban3.style.display="block";
		moban2.style.display="none";
		moban1.style.display="none";
	}
}

//鱼吧与视频显示改变
function ChangeYuba(){
	//得到两个div
	var hudong1=document.getElementById("hudong1");
	var hudong2=document.getElementById("hudong2");
	var yubabody1=document.getElementById("yubabody1");
	var yubabody2=document.getElementById("yubabody2");
	
    if(hudong1==this){
    	//改变颜色
	    this.style.color = "coral";
	    this.style.borderBottomColor="coral";
	    hudong2.style.color = "#000";
	    hudong2.style.borderBottomColor="#fff";
	    //显示div
	    yubabody1.style.display="block";
	    yubabody2.style.display="none";
    }
    else{
    	//改变颜色
	    this.style.color = "coral";
	    this.style.borderBottomColor="coral";
	    hudong1.style.color = "#000";
	    hudong1.style.borderBottomColor="#fff";
	    //显示div
	    yubabody2.style.display="block";
	    yubabody1.style.display="none";
    }
}

//检查是否登陆
function checkLogin(){
	var loginname=$('#guidongdanmubox').attr('title');
	if(loginname!=""){
		var danmuz=document.getElementById("danmuz");
		danmuz.style.display="none";
		var danmushurukuang=document.getElementById("danmushurukaung");
		danmushurukuang.style.display="block";
		var danmusubmit=document.getElementById("danmusubmit");
		danmusubmit.style.backgroundColor="coral";
		
		danmusubmit.onclick=sendDanmu;
		danmushurukuang.onkeydown = function(event) {
			var e = event || window.event;
			if(e && e.keyCode == 13) { // enter 键
				//要做的事情输出弹幕
	            sendDanmu();
			}
		};
	}
}

//关注
function forBook(){
	alert("x");
	//发给服务器
	$.ajax({
		type : 'post',
		url : 'userAction.do?command=toBook&roomId='+roomId,
        dataType: 'text',
		success : function(data) {
             alert("关注成功");
		} 
	});
}

window.onload=init;
