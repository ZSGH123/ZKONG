<%@page import="com.kba.entity.BarrageInfo"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
<title>${liveHost==null?"liveHost.userName":liveHost.userName}的直播间</title>
<meta charset="UTF-8" />

<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="css/livehome.css" />

<script type='text/javascript' src='js/jwplayer.js'></script>
<script type='text/javascript' src='js/jquery-1.7.2.min.js'></script>
<script src="js/bootstrap.js" type="text/javascript" charset="utf-8"></script>
<script src="js/danmuzengjia.js" type="text/javascript" charset="utf-8"></script>


</head>
	
<body>
	<div id="box">
        <%@include file="../top.jsp"%>
		<%@include file="left.html"%>

		<div id="dazhudiv">

			<div id="middle">
				<div id="zhuboxinxi" class="haveboder">
					<div id="zhuboxinxi1" style="background-image: url(${liveHost.userIcon})">
						<div id="txdh">进入TA的鱼吧</div>
					</div>
					<div id="zhuboxinxi2">
						<div id="zbmz">
							<p>${liveHost==null?"liveRoomTilie":liveHost.liveRoomTilie}</p>
							<span> <a href="#">举报</a>
							</span>
							<div id="zbgz">
								<div id="zbgzsp1">关注</div>
								<i></i>
								<div id="zbgzsp2">${liveHost.anchorBookedNumber}</div>
							</div>
							<div id="zbsp" class="haveboder">TA的视频</div>
						</div>
						<div id="zb2">
							<div id="zbpm">
								本周排名第 <font>5</font>位
							</div>
							<div id="zbbq">
								<ul>
									<li>${liveHost.liveTypeName}</li>
									<li class="bq"></li>
									<li>${liveHost.liveContextName}</li>
									<li class="bq"></li>
									<li>技术大神</li>
								</ul>
							</div>
						</div>
						<div id="zb3">
							<div id="zbdj" title="主播等级">${liveHost.anchorLevelId}</div>
							<div id="zb3mz" title="进入他的鱼吧">${liveHost.userName}</div>
							<div id="xt1" title="发送站内短信"></div>
							<div id="xt2">
								<img src="stimages/xt1.jpg" style="width: 15px; height: 16px;" />
							</div>
							<div id="zbrd" title="主播热度"><%=10%></div>
							<div id="xt3"></div>
							<div id="zbwh">月鱼文化</div>
						</div>
						<div id="zb4">
							<div id="zbrz" title="官方认证，点击可查看详情">
								<img src="stimages/xt6.png" style="width: 20px;" />
								${liveHost.anchorInfoRemark}
							</div>
						</div>
					</div>
				</div>

				<div id="main">
					<div id="player" title=${liveHost.liveRoomId}>
						<embed id="flash" src='play/player.swfplayer.swf' autostart="true"
							style="width: 100%; height: 100%;"></embed>
						<script type='text/javascript'>
						//全局变量
						//播放器
						var thePlayer = null;	
						//设置开关
						var kaiguan=true;
						
						var roomId=$('#player').attr('title');
						
						//生成播放器
						function craetPlayer() {
							thePlayer = jwplayer('player').setup({
								'flashplayer' : 'play/player.swf',
								'file' : ''+roomId+'',  //文件名为直播间id
								'streamer' : 'rtmp://Imprator/oflaDemo',  
								'autostart' : 'true', //自动播放
								'bufferlength' : '0',
								'overstretch' : 'fit',
								'controlbar' : 'none', //控制条位置
								'stretching' : 'fill',
								'image' : 'images/img1.png',
								'width' : '100%',
								'height' : '100%',
							});
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

                            //全屏方法
							function requestFullScreen(id) {
								var de = document.getElementById(id);
								if(de.requestFullscreen) {
									de.requestFullscreen();
								} else if(de.mozRequestFullScreen) {
									de.mozRequestFullScreen();
								} else if(de.webkitRequestFullScreen) {
									de.webkitRequestFullScreen();
								}
							}
	                    
	                    //ajax轮询
	                    var time=null;  //全局时间变量
						function ajaxlunxun(){
						//alert("进行了一次轮询");
						var newtime=null;
							//发给服务器
							$.ajax({
								type : 'post',
								url : "userAction.do?command=toajax",
								//async : true,
						        dataType: 'json',
								success : function(data) {
								    var barrageInfo = data.barrageInfo;
								    var len=barrageInfo.length;
								    for(var i=0;i<len;i++){
								        var room=barrageInfo[i].barrageId;
								        var name=barrageInfo[i].userId;
								        var content=barrageInfo[i].barrageContent;
								        //alert(room+";"+name+";"+content);
								        newtime=barrageInfo[i].time;
								    }
								    
								    //检查房间是否相同
								    if(room==roomId){
								          //时间是否不一样
								          if(newtime!=time){
								             time=newtime;
								             //是不是自己发的
								             if(name!=$('#guidongdanmubox').attr('title')){
								                 //符合要求发送弹幕
								                 addModel(name,content);
								                 //滚动条置于最低端
												putDibu();
												//增加长度
												addLength();
											}
								          }
								    }
								}
							});
						}
							
                        //初始化方法
						$(function() {
						
							//建立播放器
							craetPlayer();
                               
                            //暂停方法
							$('#zanting').click(function() {
								if (thePlayer.getState() != 'PLAYING') {
									thePlayer.play(true);
									$(this).attr({"title": "暂停视频"});
									$(this).css({"background": "url(controlImgs/kza1.png) no-repeat 0"});
									//鼠标访问
									$(this).hover(
										function() {
											$(this).css({"background": "url(controlImgs/kza2.png) no-repeat 0"});
										},
										function() {
											$(this).css({"background": "url(controlImgs/kza1.png) no-repeat 0"});
										}
									);
								} else {
									thePlayer.play(false);
									$(this).attr({"title": "取消暂停"});
									$(this).css({"background": "url(controlImgs/kza3.png) no-repeat 0"});
									//鼠标访问
									$(this).hover(
										function() {
											$(this).css({"background": "url(controlImgs/kza4.png) no-repeat 0"});
										},
										function() {
											$(this).css({"background": "url(controlImgs/kza3.png) no-repeat 0"});
										}
									);
								}
							});	
							
					        //全屏方法
							$('#quanping').click(function() {
								//将maindiv全屏
								requestFullScreen("main");
								//关闭设置
								$('#shezhigongneng').hide();	
							});
							
					        //刷新方法
							$('#shuaxin').click(function() {
								//删除就的player
								thePlayer.remove();
								//产生新的player
								craetPlayer();
							});
							
							//设置方法 
							$('#shezhi').click(function() {
								if(kaiguan){
									$('#shezhigongneng').show();
									kaiguan=false;
								}else{
									$('#shezhigongneng').hide();
									kaiguan=true;
								}
							});
							
							//打开弹幕方法
							$('#dakaidanmu').click(function() {
								//先启动弹幕
								$('#guidongdanmu').show();
								if($(this).attr("title")=="打开弹幕"){
									$(this).attr({"title": "关闭弹幕"});
								    $(this).css({"background": "url(controlImgs/kze2.png) no-repeat 0"});
								    //打开弹幕div
								    $('#guidongdanmubox').show();
								}else{
									$(this).attr({"title": "打开弹幕"});
								    $(this).css({"background": "url(controlImgs/kze1.png) no-repeat 0"});
								    //关闭弹幕div
								    $('#guidongdanmubox').hide();
								}
							});
					
							//音量控制方法
							$('#yinliangkz').click(function() {
								DisplayCoord(event);
								//得到左控件的长度；
								var len=null;
								len=parseInt($('#yinliangkzleft').css("width"));
								thePlayer.setVolume(len); 
								//更改title
								$('#yinliangkzleft').attr({"title": "音量"+len});
								$('#yinliangkzright').attr({"title": "音量"+len});
								//如果音量为零改变图标
								if(len==0){
									$('#yinliang').css({"background": "url(controlImgs/kzc3.png) no-repeat 0"});
								}else{
									$('#yinliang').css({"background": "url(controlImgs/kzc1.png) no-repeat 0"});
								}
							});
							
							//moban1鼠标事件
							$('#moban1').mousemove(function() {
								$('#moban1b').show();
							});
							$('#moban1').mouseleave(function() {
								$('#moban1b').hide();
							});
							
	 						//ajax轮询
	                        window.setInterval(ajaxlunxun, 100);
						});
					</script>
					</div>

					<div id="guidongdanmu">
						<div id="guidongdanmubox" title=${loginUser.userName}>
							<span class="gundong"> 这是一条测试弹幕 </span>
						</div>
					</div>

					<div id="shezhigongneng">
						<div id="shezhihead">透明度</div>
						<div id="shezhitoumingdu">
							<div id="wu">无</div>
							<div id="di">低</div>
							<div id="zhong">中</div>
							<div id="gao">高</div>
						</div>
						<div id="shezhiweizhi">
							<div id="full"></div>
							<div id="bottom"></div>
							<div id="top"></div>
						</div>
					</div>
					<div id="qupingdanmu">
						<input id="qupingdanmuleft" type="text"> </input>
						<div id="qupingdanmuright">发送(Enter)</div>
					</div>
				</div>

				<div id="control">
					<div id="kzleft">
						<div id="zanting" title="视频暂停"></div>
						<div id="shuaxin" title="视频刷新"></div>
					</div>
					<div id="kzright">
						<div id="yinliang"></div>
						<div id="yinliangkz">
							<div id="yinliangkzleft" title="音量50">
								<div id="yinliangkztubiao"></div>
							</div>
							<div id="yinliangkzright" title="音量50"></div>
						</div>
						<div id="dakaidanmu" title="打开弹幕"></div>
						<div id="shezhi" title="打开设置"></div>
						<div id="quanping" title="全屏显示"></div>
					</div>
				</div>

				<div id="liwu" class="haveboder">
					<div id="liwubox">
						<div id="lwa1">
							<i> <img src="stimages/xt11.png"
								style="width: 26px; height: 26px;" />
							</i> 任务
						</div>
						<div id="lwa2" class="lwa">
							<img src="stimages/xt12.png" style="width: 35px; height: 39px;" />
						</div>
						<div id="lwa3" class="lwa">
							<img src="stimages/xt13.png" style="width: 60px; height: 40px;" />
						</div>
						<div id="lwa4" class="lwa">
							<img src="stimages/xt14.png" style="width: 60px; height: 40px;" />
						</div>
						<div id="lwa5" class="lwa">
							<img src="stimages/xt15.png" style="width: 60px; height: 40px;" />
						</div>
						<div id="lwa6" class="lwa">
							<img src="stimages/xt16.png" style="width: 60px; height: 40px;" />
						</div>
						<div id="lwa7" class="lwa">
							<img src="stimages/xt17.png" style="width: 60px; height: 40px;" />
						</div>
						<div id="lwa8" class="lwb">
							<img src="stimages/xt18.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa9" class="lwb">
							<img src="stimages/xt19.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa10" class="lwb">
							<img src="stimages/xt20.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa11" class="lwb">
							<img src="stimages/xt21.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa12" class="lwb">
							<img src="stimages/xt22.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa13" class="lwb">
							<img src="stimages/xt23.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa14	" class="lwb">
							<img src="stimages/xt24.png" style="width: 40px; height: 40px;" />
						</div>
						<div id="lwa15" class="haveboder">∧</div>
						<div id="lwb1">
							<img src="stimages/xt26.png" style="width: 17px; height: 20px;" />
							【一键领】您还有一个红包待领取，打开可得6666鱼丸+10办卡！
						</div>
						<div id="lwb2">
							<div id="lwb2a" class="lwc">
								<img src="stimages/xt27.png" style="width: 20px; height: 20px;" />
								鱼丸 <font>0</font>
							</div>
							<div id="lwb2b" class="lwc">
								<img src="stimages/xt28.png" style="width: 20px; height: 20px;" />
								鱼翅 <font>0</font>
							</div>
							<div id="lwb2c" class="lwc">充值</div>
							<div id="lwb2d" class="lwc">背包</div>
						</div>
					</div>
				</div>

				<div id="guanggao" class="haveboder">
					<div id="shuiyin" class="haveboder">广告</div>
				</div>

				<div id="yubatou">
					<span class="hudong" id="hudong1">相关推荐</span> <span class="hudong"
						id="hudong2">鱼吧讨论</span>
				</div>
				<div id="yuba">
					<div id="yubabody1" class="yubabody">
						<ul>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
							<li><img class="hkimg" src="images/hk1.jpg" />
								<h2 class="hktou">梦魇打工：上门护体，我服了！ 2019-01-13 07点场</h2>
								<p class="hkcontext">智勋勋勋勋</p></li>
						</ul>
					</div>
					<div id="yubabody2" class="yubabody">鱼吧暂未开放！</div>
				</div>

				<div id="tuiguangtou">热门推广</div>
				<div id="tuiguang">
					<div id="tuiguangbody">
						<div id="tuiguangbody1" class="haveboder">
							<ul>
								<li id="gt1">
									<div class="guanggaoshuiyin">广告</div>
								</li>
								<li id="gt2"></li>
								<li id="gt3">
									<div class="guanggaoshuiyin">广告</div>
								</li>
							</ul>
						</div>
						<div id="tuiguangbody2" class="haveboder">
							<ul>
								<li id="qt1">
									<div class="guanggaoshuiyin">广告</div>
								</li>
								<li id="qt2">
									<div class="guanggaoshuiyin">广告</div>
								</li>
								<li id="qt3">
									<div class="guanggaoshuiyin">广告</div>
								</li>
								<li class="qt456"></li>
								<li class="qt456"></li>
								<li class="qt456"></li>
							</ul>
						</div>
					</div>
					<div class="tuiguangtitle" id="tuiguangp1">官方推广</div>
					<div class="tuiguangtitle" id="tuiguangp2">其它推广</div>
				</div>

			</div>

			<div id="right">
				<div id="danmu" class="haveboder">
					<div id="danmu2">
						<div class="youcedanmu">
							<span class="clayoucedanmuspan1">test：</span> <span
								class="clayoucedanmuspan2">这是一条测试弹幕</span>
						</div>
					</div>
					<div id="danmu1">
						<div id="gongxianbox">
							<div id="gxzb">贡献周榜</div>
							<div id="gz">贵族(11)</div>
							<div id="fst">粉丝团</div>
						</div>
						<div id="moban1">
							<div id="moban1a">
								<span id="moban1aspan1"> 点击右侧查看详情 </span> <span
									id="moban1aspan2"> 贡献总榜> </span>
								<ul>
									<li style="background: url(controlImgs/gx1.png) no-repeat 0;"></li>
									<li style="background: url(controlImgs/gx2.png) no-repeat 0;"></li>
									<li style="background: url(controlImgs/gx3.png) no-repeat 0;"></li>
								</ul>
								<div id="moban1b">
									<ul>
										<li><span class="yuan">4</span> <span class="minzi">大柱</span>
										</li>
										<li><span class="yuan">5</span> <span class="minzi">大柱</span>
										</li>
										<li><span class="yuan">6</span> <span class="minzi">大柱</span>
										</li>
										<li><span class="yuan">7</span> <span class="minzi">大柱</span>
										</li>
										<li><span class="yuan">8</span> <span class="minzi">大柱</span>
										</li>
										<li><span class="yuan">9</span> <span class="minzi">大柱</span>
										</li>
										<li><span class="yuan">10</span> <span class="minzi">大柱</span>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div id="moban2">暂未开放！</div>
						<div id="moban3">尽情期待！</div>
					</div>
					<div id="danmu3">
						<div id="biaoqing">屏蔽礼物特效</div>
						<div id="danmushuru">
							<div id="danmuz" class="haveboder">
								<span id="danmuz1"> <a id="danmuz1a">登录</a>
								</span> <span id="danmuz2"> 发送弹幕参与主播互动 </span>
							</div>
							<input type="text" id="danmushurukaung" />
							<div id="danmuy">
								<input type="submit" id="danmusubmit" value="发送" />
							</div>
						</div>
					</div>
				</div>
				<div id="gonggao" class="haveboder">
					<div id="gonggao1">
						<img src="stimages/xt8.png" /> <font>直播公告</font>
					</div>
					<div id="gonggao2">
						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${liveHost.liveRoomAnnouncement}</p>
					</div>
					<div id="gonggao3">
						<img src="stimages/xt9.png" /> <font>主播也爱看</font> <img
							src="stimages/xt10.png" />
					</div>
					<div id="gonggao4">
						<ul>
							<li>
								<div id="akz1" class="akz">
									<img src="images/ak1.jpg" width="124px" height="70px" />
								</div>
								<div id="aky1" class="aky">
									<h1 class="toutext">菟菟的心里咨询情感分析和交流</h1>
									<p class="akcontext">分类：二次元</p>
									<p class="akcontext">主播：兔兔萌将</p>
								</div>
							</li>
							<li>
								<div id="akz2" class="akz">
									<img src="images/ak2.jpg" width="124px" height="70px" />
								</div>
								<div id="aky2" class="aky">
									<h1 class="toutext">火影手游NUF超影大赛总决赛</h1>
									<p class="akcontext">分类：火影忍者</p>
									<p class="akcontext">主播：火影木叶电视台</p>
								</div>
							</li>
							<li>
								<div id="akz3" class="akz">
									<img src="images/ak3.jpg" width="124px" height="70px" />
								</div>
								<div id="aky3" class="aky">
									<h1 class="toutext">野外吃到你不想吃</h1>
									<p class="akcontext">分类：户外</p>
									<p class="akcontext">主播：乔治麦克</p>
								</div>
							</li>
							<li>
								<div id="akz4" class="akz">
									<img src="images/ak4.jpg" width="124px" height="70px" />
								</div>
								<div id="aky4" class="aky">
									<h1 class="toutext">职业冠军主播 五指陀螺仪如画身法~</h1>
									<p class="akcontext">分类：刺激战场</p>
									<p class="akcontext">主播：一生仙气艾九九</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>