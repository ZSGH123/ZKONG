<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>收益兑换-个人中心-看吧</title>
		<link rel="stylesheet" href="css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
		<link rel="stylesheet" type="text/css" href="css/userpage.css"/>
		<link rel="stylesheet" type="text/css" href="css/myexchange.css"/>
		<script type="text/javascript" src="js/jquery.min.js" ></script>
		<script type="text/javascript" src="js/bootstrap.min.js" ></script>
</head>
<body style="background-color:#FFFFFF ;">
		<div class="container">
			<div class="col-md-12">
				<h1>个人中心</h1>
			</div>
			<div class="col-md-2">
			<ul class="nav nav-pills nav-stacked" role="tablist">
  				<li><a href="user-page.jsp">	
  					<i class="fa fa-user-circle-o" aria-hidden="true"></i>
  						我的资料
  					</a></li>
  				<li><a href="my-messages.html">
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
  				<li  class="active"><a href="my-exchange.jsp">
  					<i class="fa fa-exchange" aria-hidden="true"></i>
  						收益兑换
  				</a></li>
  				<li><a href="room-manage.html">
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
				<div class="user-myexchange-title clearfix">
					<span class="exchange_tit">
						<i class="user-myexchange-icon"></i>
						<h4>收益兑换</h4>
					</span>
				</div>		
				<div class="earn_tab_tit">
					<dl>
						<dd class="active">
							<a href="my-exchange.html">收益兑换</a>
						</dd>
					</dl>
				</div>	
				<div class="row" id="exchange_type">
    				<div class="col-sm-3 col-md-6" id="bankcard_content">
    					<div class="thumbnail">
     						<div class="caption">
        						<img src="img/个人中心.png" align="left"/>
        						<span id="tool"><h5>银行卡兑换</h5></span>
        						<span id="tool-info-jin">可兑换的金K币：300元</span>
        						<span id="tool-info-yin">可兑换的银K币：500元</span>
								<div class="input-group" id="exchange-input">
  									<span class="input-group-addon">请输入银行卡号</span>
    								<input type="text" class="form-control">
								</div>
        						
        						<span><a href="#" class="btn tool-btn"  role="button">兑换</a> </span>
      					</div> 
    					</div>
  					</div>
					<div class="col-sm-3 col-md-6" id="alipay_content">
    					<div class="thumbnail">
     						<div class="caption">
        						<img src="img/个人中心.png" align="left"/>
        						<span id="tool"><h5>支付宝兑换</h5></span>
        						<span id="tool-info-jin">可兑换的金K币：300元</span>
        						<span id="tool-info-yin">可兑换的银K币：500元</span>
								<div class="input-group" id="exchange-input">
  									<span class="input-group-addon">请输入支付宝号</span>
    								<input type="text" class="form-control">
								</div>
        						
        						<span><a href="#" class="btn tool-btn"  role="button">兑换</a> </span>
      					</div> 
    					</div>
  					</div>

				</div>
				<div class="earn_tab_tit">
					<dl>
						<dd class="active">
							<a href="my-exchange.html">兑换记录</a>
						</dd>
					</dl>
				</div>	
				<div class="exchange_list">
					<div class="exchange_nr" style="display: block;">
						<table  class="table table-bordered table-hover" id="exchange-table" cellspacing="0" cellpadding="0">
							<thead>
								<tr>
									<th>兑换编号</th>
									<th>兑换礼物</th>
									<th>礼物数量</th>
									<th>K币类型</th>
									<th>K币数量</th>
									<th>兑换方式</th>
									<th>兑换时间</th>
								</tr>
							</thead>
							<tbody>	
								<tr>
									<td >10000001</td>
									<td >航空母舰</td>
									<td >3</td>
									<td >金K币</td>
									<td >30000K</td>
									<td >支付宝</td>
									<td >2019-01-15</td>
								</tr>
								<tr>
									<td >10000001</td>
									<td >航空母舰</td>
									<td >3</td>
									<td >金K币</td>
									<td >30000K</td>
									<td >支付宝</td>
									<td >2019-01-15</td>
								</tr>
								<tr>
									<td >10000001</td>
									<td >航空母舰</td>
									<td >3</td>
									<td >金K币</td>
									<td >30000K</td>
									<td >支付宝</td>
									<td >2019-01-15</td>
								</tr>
								<tr>
									<td >10000001</td>
									<td >航空母舰</td>
									<td >3</td>
									<td >金K币</td>
									<td >30000K</td>
									<td >支付宝</td>
									<td >2019-01-15</td>
								</tr>
								<tr>
									<td >10000001</td>
									<td >航空母舰</td>
									<td >3</td>
									<td >金K币</td>
									<td >30000K</td>
									<td >支付宝</td>
									<td >2019-01-15</td>
								</tr>
				
							</tbody>	
								
						</table>
						<ul class="pager">
  							<li><a href="#">上一页</a></li>
  							<li><a href="#">下一页</a></li>
						</ul>						
					</div>
				</div>				
			
			</div>
		</div>
		
	</body>
</html>