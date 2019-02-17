<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
		<title>我的资料-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/gerenzhuye.css"/>
		<script type="text/javascript" src="js/jquery-1.7.2.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.js" ></script>
		
</head>
<body>
<jsp:include page="../top.jsp"></jsp:include>
<div class="container">
			
			<div class="col-md-12">
				<h1>个人中心</h1>          
			</div>
			<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" role="tablist">
  				<li class="active"><a href="user-page.jsp">
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
  				<li><a href="my-level.html">
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
  				<li><a href="room-manager.jsp">
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
				<div class="user-gerenzhuye-title clearfix">
						<span class="gerenzhuye_tit">
						<i class="user-gerenzhuye-icon"></i>
						<h4>我的资料</h4>
						</span>
				</div>		
				<div class="user_myprofile user_info_page">
                    <div class="myprofile_main clearfix data_cont white_bg" id="js_info_div">
                        <div class="userinfo clearfix">
                			<div id="js-invisible-taste" class="invisible-taste-switch"></div>
                           	<div class="uinfo_left fl">
                                <div class="utx fl">
                                    <img src="${loginUser.userIcon}" width="100" height="80" alt=""/>
                                </div>
                                <div class="fl udetail_info">
                                    <div class="uname clearfix">
                                        <div class="uname_con clearfix" title="${loginUser.userName}">
                                            <h2 class="fl clearfix"  style="float:left;">${loginUser.userName}</h2>
                                        </div>
                                       
                                        
                                    </div>

                                        <div class="m_rank clearfix">
                                            <div class="m_rank_item">
                                                <span class="m_rank_item_title">用户等级</span>
                                                <span class="user_level lv10"  id="leveimg"></span>
                                                <a class="bar fl" id="bar" >
                                                    <span id="barline" class="bar_totalper"></span>
                                                    <span id="leverline" class="bar_per"></span>
                                                    <div class="exprience"></div>
                                                    <div class="levelTip user-tip" id="grade_tip"></div>
                                                </a>
                                                <span id="leverscore" class="bar_nb fl"></span>
                                               
                                            </div>
                                                                                    </div>
                                            <div class="m_yc clearfix">
                                            <span id="balance" class="y1" data-value="0" >
                                   				 <img src="img/${userpropertys[0].kTypeId==1 ? 'k-jin.png':'k-yin.png'}" alt="" />
                                   				 ${userpropertys[0].kTypeId==1 ? "金k币":"银K币"}：
                                   				 ${userpropertys[0].kNumber==null ? 0 : userpropertys[0].kNumber }k
                                            </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                  							<span class="y2" id="balance_gold">
                  								 <img src="img/${userpropertys[1].kTypeId==1 ? 'k-jin.png':'k-yin.png'}"  />
                  								 ${userpropertys[1].kTypeId==1 ? "金k币":"银K币"}：
                  								 ${userpropertys[1].kNumber==null ? 0 : userpropertys[1].kNumber}k
                  								 </span>
                                            <span>&nbsp;&nbsp;&nbsp;
                                            </span>
                                            <span><a href="invest.html" class="btn btn-primary" role="button">充值</a> </span>
                                            </div>
                                </div>
                            
                           	</div>
                        </div>
                   		<div class="row" id="add">
                   			<div class="col-sm-3 col-md-12" id="add1">
                   				<div class="thumbnail">
                   					<div class="caption">



   							<a href="" title="这里是广告"><img src="img/add2.png" width="950px"></a>


                   					</div>
                   				</div>
                   			</div>
                   		</div>
                    	<div class="row" id="zhanghao_shezhi">
                    		<div class="col-sm-3 col-md-6" id="phone">
                    			    <div class="thumbnail">
      									<img data-src="holder.js/300x300" alt="">
     									<div class="caption">
       										<img src="img/phone.png" align="left" />
       										<h4>${loginUser.userPhoneNumber==null ? "手机未绑定":"手机已绑定"}</h4>
        									<span>您可以绑定手机享受相关的安全及提醒服务！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        									<span><a href="phone.html" class="btn btn-primary" role="button">${loginUser.userPhoneNumber==null ? "绑定手机":"解绑"}</a> </span>
      									</div>
    								</div>	
                    		</div>
                    		<div class="col-sm-3 col-md-6" id="password">
                    			    <div class="thumbnail">
      									<img data-src="holder.js/300x300" alt="">
     									<div class="caption">
       										<img src="img/suo.png" align="left"/>
       										<h4>&nbsp;账号密码</h4>
        									<span>经常修改您的密码，保证不被盗号！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        									<span><a href="pass-word.html" class="btn btn-primary" role="button">修改密码</a> </span>
      									</div>
    								</div>
                    		</div>
                    		<div class="col-sm-3 col-md-6" id="IDCard">
                    			    <div class="thumbnail">
      									<img data-src="holder.js/300x300" alt="">
     									<div class="caption">
       										<img src="img/sfz.png" align="left" />
       										<h4>实名认证</h4>
        									<span>完善身份信息，方便提取直播收益！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        									<span><a href="id-card.html" class="btn btn-primary" role="button">${loginUser.userIdCard==null ? "实名认证":"已认证"}</a> </span>
      									</div>
    								</div>	
                    		</div>
                    		<div class="col-sm-3 col-md-6" id="bankCard">
                    			    <div class="thumbnail">
      									<img data-src="holder.js/300x300" alt="">
     									<div class="caption">
       										<img src="img/card.png" align="left" />
       										<h4>&nbsp;银行卡绑定</h4>
        									<span>完善银行卡信息，方便提取直播收益！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        									<span><a href="bank-card.html" class="btn btn-primary" role="button">${loginUser.userBankCard==null ? "绑定银行卡":"已绑定"}</a> </span>
      									</div>
    								</div>	
                    		</div>
                    		<div class="col-sm-3 col-md-6" id="QQ">
                    			    <div class="thumbnail">
      									<img data-src="holder.js/300x300" alt="">
     									<div class="caption">
       										<img src="img/qq.png" align="left" />
       										<h4>&nbsp;QQ绑定</h4>
        									<span>绑定QQ账号，使用QQ账号便捷登录！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        									<span><a href="#" class="btn btn-primary" role="button">${loginUser.userQQId==null ? "绑定QQ":"已绑定"}</a> </span>
      									</div>
    								</div>	
                    		</div>
                    		<div class="col-sm-3 col-md-6" id="weibo">
                    			    <div class="thumbnail">
      									<img data-src="holder.js/300x300" alt="">
     									<div class="caption">
       										<img src="img/weib.png" align="left" />
       										<h4>&nbsp;微博绑定</h4>
        									<span>绑定微博账号，使用微博账号便捷登录！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
        									<span><a href="#" class="btn btn-primary" role="button">${loginUser.userWeiboId==null ? "绑定微博":"已绑定"}</a> </span>
      									</div>
    								</div>	
                    		</div>
                    	</div>
                    </div>
				</div>
			</div>
		</div>
	</body>
</html>