 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    
    <meta charset="utf-8">
    <title>KBaLive用户送礼记录查询</title>
    <meta name="新增port" content="width=device-width, initial-scale=1">
    <meta name="description" content="Charisma, a fully featured, responsive, HTML5, Bootstrap admin template.">
    <meta name="author" content="Muhammad Usman">

    <!-- The styles -->
    <link id="bs-css" href="css/bootstrap-cerulean.min.css" rel="stylesheet">

    <link href="css/charisma-app.css" rel="stylesheet">
    <link href='bower_components/fullcalendar/dist/fullcalendar.css' rel='stylesheet'>
    <link href='bower_components/fullcalendar/dist/fullcalendar.print.css' rel='stylesheet' media='print'>
    <link href='bower_components/chosen/chosen.min.css' rel='stylesheet'>
    <link href='bower_components/colorbox/example3/colorbox.css' rel='stylesheet'>
    <link href='bower_components/responsive-tables/responsive-tables.css' rel='stylesheet'>
    <link href='bower_components/bootstrap-tour/build/css/bootstrap-tour.min.css' rel='stylesheet'>
    <link href='css/jquery.noty.css' rel='stylesheet'>
    <link href='css/noty_theme_default.css' rel='stylesheet'>
    <link href='css/elfinder.min.css' rel='stylesheet'>
    <link href='css/elfinder.theme.css' rel='stylesheet'>
    <link href='css/jquery.iphone.toggle.css' rel='stylesheet'>
    <link href='css/uploadify.css' rel='stylesheet'>
    <link href='css/animate.min.css' rel='stylesheet'>
    <script src='js/jquery-3.3.1.js'></script>
    <script src="js/manager-index.js"></script>
    <!-- jQuery -->
    <script src="bower_components/jquery/jquery.min.js"></script>

    <!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- The fav icon -->
    <link rel="shortcut icon" href="img/indexlog.png">

</head>

<body>
     <!-- topbar starts -->
    <div class="navbar navbar-default" role="navigation">

        <div class="navbar-inner">
            <button type="button" class="navbar-toggle pull-left animated flip">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp"> <img alt="Charisma Logo" src="img/indexlog.png" class="hidden-xs"/>
                <span>KbaTV</span></a>

            <!-- user dropdown starts -->
            <div class="btn-group pull-right">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-user"></i><span class="hidden-sm hidden-xs"> 切换账户</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                    <li><a href="login.jsp">Logout</a></li>
                </ul>
            </div>
            <!-- user dropdown ends -->

            <!-- theme selector starts -->
            <div class="btn-group pull-right theme-container animated tada">
                <button class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    <i class="glyphicon glyphicon-tint"></i><span
                        class="hidden-sm hidden-xs"> 主题皮肤</span>
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu" id="themes">
                    <li><a data-value="classic" href="#"><i class="whitespace"></i> Classic</a></li>
                    <li><a data-value="cerulean" href="#"><i class="whitespace"></i> Cerulean</a></li>
                    <li><a data-value="cyborg" href="#"><i class="whitespace"></i> Cyborg</a></li>
                    <li><a data-value="simplex" href="#"><i class="whitespace"></i> Simplex</a></li>
                    <li><a data-value="darkly" href="#"><i class="whitespace"></i> Darkly</a></li>
                    <li><a data-value="lumen" href="#"><i class="whitespace"></i> Lumen</a></li>
                    <li><a data-value="slate" href="#"><i class="whitespace"></i> Slate</a></li>
                    <li><a data-value="spacelab" href="#"><i class="whitespace"></i> Spacelab</a></li>
                    <li><a data-value="united" href="#"><i class="whitespace"></i> United</a></li>
                </ul>
            </div>
            <!-- theme selector ends -->

            <ul class="collapse navbar-collapse nav navbar-nav top-menu">
                <li><a href="#"><i class="glyphicon glyphicon-globe"></i> Visit Site</a></li>
                <li class="dropdown">
                    <a href="#" data-toggle="dropdown"><i class="glyphicon glyphicon-star"></i> Dropdown <span
                            class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
                <li>
                    <form class="navbar-search pull-left">
                        <input placeholder="搜索" class="search-query form-control col-md-10" name="query"
                               type="text">
                    </form>
                </li>
            </ul>

        </div>
    </div>
     <!-- topbar ends -->
     <div class="ch-container">
			<div class="row">

				<!-- 左菜单开始 -->
				<div class="col-sm-2 col-lg-2">
					<div class="sidebar-nav">
						<div class="nav-canvas">
							<div class="nav-sm nav nav-stacked">

							</div>
							<ul class="nav nav-pills nav-stacked main-menu">
								<li class="nav-header">功能导航</li>
								<li><a class="ajax-link" href="backStageIndexAction.do"><i class="glyphicon glyphicon-home"></i><span> Dashboard</span></a>
                                <li><a class="ajax-link" href="managerInfoAction.do"><i class="glyphicon glyphicon-home"></i><span> 管理员设置</span></a>
                         <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 用户管理</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="afterInvestSearchAction.do">充值记录查询</a></li>
                                <li><a href="afterUserGiftRecordAction.do">送礼记录查询</a></li>
                                <li><a href="afterReportMessageAction.do">举报记录查询</a></li>
                                <li><a href="afterUserBookAction.do">订阅记录查询</a></li>
                            </ul>
                        </li>
                         <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 主播管理</span></a>
                            <ul class="nav nav-pills nav-stacked">

                                <li><a href="afterReceiveAction.do">直播间收益</a></li>
                                <li><a href="afterTransformRecordAction.do">提现记录</a></li>

                                <li><a href="afterGagInfoAction.do">禁言记录</a></li>
                                <li><a href="afterLiveRecordAction.do">直播记录</a></li>
                            </ul>
                        </li>
                         <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 等级设置</span></a>
                            <ul class="nav nav-pills nav-stacked">
                                <li><a href="backStageUserLevelAction.do">用户等级</a></li>
                                <li><a href="backStageAnchorLevelAction.do">主播等级</a></li>
                            </ul>
                        </li>
                         <li class="accordion">
                            <a href="#"><i class="glyphicon glyphicon-plus"></i><span> 礼物管理</span></a>
                            <ul class="nav nav-pills nav-stacked">


                                <li><a href="backStageGiftTypeAction.do">礼物类型设置</a></li>
                                <li><a href="backStageKTypeAction.do">K币类型设置</a></li>
                                <li><a href="backStagePayTypeAction.do">支付类型设置</a></li>

                            </ul>
                        </li>
								<li class="accordion">
									<a href="financialstatistic-index.jsp"><i class="glyphicon glyphicon-plus"></i><span>财务统计管理</span></a>
									<ul class="nav nav-pills nav-stacked">
										<li>
											<a href="backStageIncomeByDayAction.do">平台每日收益</a>
										</li>
									</ul>
								</li>
								<li class="accordion">
									<a href="#"><i class="glyphicon glyphicon-plus"></i><span>推送设置</span></a>
									<ul class="nav nav-pills nav-stacked">
										<li>
											<a href="backStagePushTypeAction.do">推送类型</a>
										</li>
										<li>
											<a href="backStagePushMessageRecord.do">推送消息</a>
										</li>
									</ul>
								</li>
								
								<li>
									<a href="#"><i class="glyphicon glyphicon-file"></i><span>日志</span></a>
									
									<li>
										<a href="error.jsp"><i class="glyphicon glyphicon-ban-circle"></i><span> 错误页面</span></a>
									</li>
									<li>
										<a href="login.jsp"><i class="glyphicon glyphicon-lock"></i><span> 登陆</span></a>
									</li>
							</ul>
							<label id="for-is-ajax" for="is-ajax"><input id="is-ajax" type="checkbox">在菜单上使用 Ajax</label>
						</div>
					</div>
				</div>
				<!--/span-->
				<!-- 左菜单结束  -->

			
				<!-- 内容开始 -->
				<div id="content" class="col-lg-10 col-sm-10">
					<!--
                    	作者：单杰
                    	时间：2018-12-27
                    	描述：导航指针
                    -->
					<div>
						<ul class="breadcrumb">
							<li>
								<a href="backStageIndexAction.do">首页</a>
							</li>
							<li>
								<a href="afterUserGiftRecordAction.do">送礼记录查询</a>
							</li>
						</ul>
					</div>
					<!--
                    	作者：单杰
                    	时间：2018-12-27
                    	描述：信息简要
                    -->

    <div class="row">
    <div class="box col-md-12">
    <div class="box-inner">
    <div class="box-header well" data-original-title="">
        <h2><i class="glyphicon glyphicon-user"></i> 送礼记录查询</h2>

        <div class="box-icon">
            <a href="#" class="btn btn-setting btn-round btn-default"><i class="glyphicon glyphicon-cog"></i></a>
            <a href="#" class="btn btn-minimize btn-round btn-default"><i
                    class="glyphicon glyphicon-chevron-up"></i></a>
            <a href="#" class="btn btn-close btn-round btn-default"><i class="glyphicon glyphicon-remove"></i></a>
        </div>
    </div>
    <div class="box-content">
    <table class="table table-striped table-bordered bootstrap-datatable datatable responsive">
    <thead>
    <tr>
        <th>用户编号</th>
        <th>直播间编号</th>
        <th>礼物类型</th>
        <th>礼物数量</th>
        <th>送礼时间</th>
        <th>送礼备注</th>
    </tr>
    </thead>
    <tbody id="tdata">
    	<c:forEach items="${usergiftrecords}" var="item" varStatus="index">
    	<tr >
        <td id="td1">${item.userId}</td>
        <td class="center" id="td2">${item.liveRoomId}</td>
        <td class="center" id="td3">${item.giftTypeId}</td>
        <td class="center" id="td4">${item.giftNumber}</td>
        <td class="center" id="td5">${item.giftTime}</td>
        <td class="center">
            <span class="label-success label label-default" id="td6">${item.userGiftRemark}</span>
        </td>
        </tr>
    	</c:forEach>
   
    </tbody>
    </table>
    </div>
    </div>
    </div>
    <!--/span-->

    </div><!--/row-->

    
    </div><!--/row-->

   
    
    
<!-- external javascript -->

<script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

<!-- library for cookie management -->
<script src="js/jquery.cookie.js"></script>
<!-- calender plugin -->
<script src='bower_components/moment/min/moment.min.js'></script>
<script src='bower_components/fullcalendar/dist/fullcalendar.min.js'></script>
<!-- data table plugin -->
<script src='js/jquery.dataTables.min.js'></script>

<!-- select or dropdown enhancer -->
<script src="bower_components/chosen/chosen.jquery.min.js"></script>
<!-- plugin for gallery image 新增 -->
<script src="bower_components/colorbox/jquery.colorbox-min.js"></script>
<!-- notification plugin -->
<script src="js/jquery.noty.js"></script>
<!-- library for making tables responsive -->
<script src="bower_components/responsive-tables/responsive-tables.js"></script>
<!-- tour plugin -->
<script src="bower_components/bootstrap-tour/build/js/bootstrap-tour.min.js"></script>
<!-- star rating plugin -->
<script src="js/jquery.raty.min.js"></script>
<!-- for iOS style toggle switch -->
<script src="js/jquery.iphone.toggle.js"></script>
<!-- autogrowing textarea plugin -->
<script src="js/jquery.autogrow-textarea.js"></script>
<!-- multiple file upload plugin -->
<script src="js/jquery.uploadify-3.1.min.js"></script>
<!-- history.js for cross-browser state change on ajax -->
<script src="js/jquery.history.js"></script>
<!-- application script for Charisma demo -->
<script src="js/charisma.js"></script>


</body>
</html>
