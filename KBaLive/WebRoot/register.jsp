<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>看吧直播-注册-弹幕式互动直播平台</title>

<!-- 引入Bootstrap核心样式文件 -->
<link rel="shortcut icon" href="img/logo.png" type="image/x-icon" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css" href="css/registerIndex.css" />

<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/register.js"></script>
</head>
<body>


	<!--作者：杨智能
                     时间：2019-01-16
                    描述：登录注册部分
    -->
    <jsp:include page="top.jsp"></jsp:include>
	<div class="container" id="registers">

		<div class="panel panel-warning">
			<div class="panel-heading" align="center">
				<h1 class="panel-title" style="font-size: 32px;">看吧注册</h1>
			</div>
			<div class="panel-body">

				<div class="row" id="register_phone">

					<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：手机验证
                          -->

					<div class="row" id="phone_row">
						<div class="col-md-2" id="phone_row_one">
							手&nbsp;&nbsp;机&nbsp;&nbsp;号：</div>
						<div class="form-group col-md-8" id="phone_row_two">
							<input type="text" class="form-control" id="phone" type="text"
								name="phone" placeholder="请填写你手机号码作为登录帐号">
						</div>
						<div class="col-md-2" id="phone_row_three">
							<span id="one" style="color: limegreen;"></span>
						</div>
					</div>
					<div class="row" id="phone_row_line">
						<span id="two" style="font-size: 13px;color: crimson;"></span>
					</div>
					<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：用户名
              -->
					<div class="row" id="phone_row" style="margin-top: 0px;">
						<div class="col-md-2" id="phone_row_one">
							用&nbsp;&nbsp;户&nbsp;&nbsp;名：</div>
						<div class="form-group col-md-8" id="phone_row_two">
							<input type="text" class="form-control" id="userName" type="text"
								name="userName" placeholder="中、英文均可、至少2个字符、最长15个字符">

						</div>
						<div class="col-md-2" id="phone_row_three">
							<span id="three" style="color: limegreen;"></span>
						</div>
					</div>
					<div class="row" id="phone_row_line">
						<span id="four" style="font-size: 13px;color: crimson;"></span>
					</div>

					<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：密码
                          -->
					<div class="row" id="phone_row" style="margin-top: 0px;">
						<div class="col-md-2" id="phone_row_one">
							密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</div>
						<div class="form-group col-md-8" id="phone_row_two">
							<input type="password" class="form-control" id="pwd"
								type="password" name="password"
								placeholder="6-20位至少要包含大小写字母，及一个数字">

						</div>
						<div class="col-md-2" id="phone_row_three">
							<span id="five" style="color: limegreen;"></span>
						</div>
					</div>
					<div class="row" id="phone_row_line">
						<span id="six" style="font-size: 13px;color: crimson;"></span>
					</div>

					<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：密码
                          -->
					<div class="row" id="phone_row" style="margin-top: 0px;">
						<div class="col-md-2" id="phone_row_one">确认密码：</div>
						<div class="form-group col-md-8" id="phone_row_two">
							<input type="password" class="form-control" id="repwd"
								type="password" name="repassword"
								placeholder="6-20位至少要包含大小写字母，及一个数字">

						</div>
						<div class="col-md-2" id="phone_row_three">
							<span id="seven" style="color: limegreen;"></span>
						</div>
					</div>
					<div class="row" id="phone_row_line">
						<span id="eight" style="font-size: 13px;color: crimson;"></span>
					</div>
					<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：验证码
                          -->
					<div class="row" id="phone_row" style="margin-top: 0px;">
						<div class="col-md-2" id="phone_row_one">验&nbsp;&nbsp;证&nbsp;&nbsp;码：</div>
						<div class="col-md-4" id="phone_row_left">
							<input id="code" class="form-control" type="text" name="code"
								placeholder="验证码" />
						</div>
						<div class="col-md-4" id="phone_row_right">
							<input id="getcode" class="myinputbtn" type="button"
								name="getcode" value="获取短信验证码" />
						</div>
						<div class="col-md-4" id="phone_row_three">
							<span id="ten" style="color: limegreen;"></span>
						</div>
					</div>
					<div class="row" id="phone_row_line">
						<span id="nine" style="font-size: 13px;color: crimson;"></span>
					</div>

					<!--
    	                        作者：offline
    	                        时间：2019-01-16
    	                        描述：注册按钮
                          -->
					<div id="register_button">
						<input id="register" class="mybtn" type="submit" name="submit"
							value="注册" />
					</div>

					<!--
                                           作者：2671242147@qq.com
                                           时间：2018-12-16
                                           描述：第三方注册
            -->
					<div id="other_login">
						&nbsp;&nbsp;&nbsp;<a href="userAction.do?command=toWeiLogin" class="weibo"><i
							class="fa fa-weibo fa-2x" aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
						<a href="userAction.do?command=toQQLogin" class="qq"><i class="fa fa-qq fa-2x"
							aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp; <a href="#"
							class="wenxin"><i class="fa fa-weixin fa-2x"
							aria-hidden="true"></i></a>&nbsp;&nbsp;&nbsp;
					</div>

					<div id="other_login_text">第三方注册登陆</div>
				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	! function() {
		//封装方法，压缩之后减少文件大小
		function get_attribute(node, attr, default_value) {
			return node.getAttribute(attr) || default_value;
		}
		//封装方法，压缩之后减少文件大小
		function get_by_tagname(name) {
			return document.getElementsByTagName(name);
		}
		//获取配置参数
		function get_config_option() {
			var scripts = get_by_tagname("script"),
				script_len = scripts.length,
				script = scripts[script_len - 1]; //当前加载的script
			return {
				l: script_len, //长度，用于生成id用
				z: get_attribute(script, "zIndex", -1), //z-index
				o: get_attribute(script, "opacity", 0.5), //opacity
				c: get_attribute(script, "color", "0,102,153"), //color
				n: get_attribute(script, "count", 199) //count
			};
		}
		//设置canvas的高宽
		function set_canvas_size() {
			canvas_width = the_canvas.width = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth,
				canvas_height = the_canvas.height = window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
		}

		//绘制过程
		function draw_canvas() {
			context.clearRect(0, 0, canvas_width, canvas_height);
			//随机的线条和当前位置联合数组
			var e, i, d, x_dist, y_dist, dist; //临时节点
			//遍历处理每一个点
			random_points.forEach(function(r, idx) {
				r.x += r.xa,
					r.y += r.ya, //移动
					r.xa *= r.x > canvas_width || r.x < 0 ? -1 : 1,
					r.ya *= r.y > canvas_height || r.y < 0 ? -1 : 1, //碰到边界，反向反弹
					context.fillRect(r.x - 0.5, r.y - 0.5, 1, 1); //绘制一个宽高为1的点
				//从下一个点开始
				for(i = idx + 1; i < all_array.length; i++) {
					e = all_array[i];
					// 当前点存在
					if(null !== e.x && null !== e.y) {
						x_dist = r.x - e.x; //x轴距离 l
						y_dist = r.y - e.y; //y轴距离 n
						dist = x_dist * x_dist + y_dist * y_dist; //总距离, m

						dist < e.max && (e === current_point && dist >= e.max / 2 && (r.x -= 0.03 * x_dist, r.y -= 0.03 * y_dist), //靠近的时候加速
							d = (e.max - dist) / e.max,
							context.beginPath(),
							context.lineWidth = d / 2,
							context.strokeStyle = "rgba(" + config.c + "," + (d + 0.2) + ")",
							context.moveTo(r.x, r.y),
							context.lineTo(e.x, e.y),
							context.stroke());
					}
				}
			}), frame_func(draw_canvas);
		}
		//创建画布，并添加到body中
		var the_canvas = document.createElement("canvas"), //画布
			config = get_config_option(), //配置
			canvas_id = "c_n" + config.l, //canvas id
			context = the_canvas.getContext("2d"),
			canvas_width, canvas_height,
			frame_func = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame || window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(func) {
				window.setTimeout(func, 1000 / 40);
			},
			random = Math.random,
			current_point = {
				x: null, //当前鼠标x
				y: null, //当前鼠标y
				max: 20000 // 圈半径的平方
			},
			all_array;
		the_canvas.id = canvas_id;
		the_canvas.style.cssText = "position:fixed;top:0;left:0;z-index:" + config.z + ";opacity:" + config.o;
		get_by_tagname("body")[0].appendChild(the_canvas);

		//初始化画布大小
		set_canvas_size();
		window.onresize = set_canvas_size;
		//当时鼠标位置存储，离开的时候，释放当前位置信息
		window.onmousemove = function(e) {
			e = e || window.event;
			current_point.x = e.clientX;
			current_point.y = e.clientY;
		}, window.onmouseout = function() {
			current_point.x = null;
			current_point.y = null;
		};
		//随机生成config.n条线位置信息
		for(var random_points = [], i = 0; config.n > i; i++) {
			var x = random() * canvas_width, //随机位置
				y = random() * canvas_height,
				xa = 2 * random() - 1, //随机运动方向
				ya = 2 * random() - 1;
			// 随机点
			random_points.push({
				x: x,
				y: y,
				xa: xa,
				ya: ya,
				max: 6000 //沾附距离
			});
		}
		all_array = random_points.concat([current_point]);
		//0.1秒后绘制
		setTimeout(function() {
			draw_canvas();
		}, 100);
	}();
	</script>
	<canvas width="490" height="747" id="c_n26"
		style="left: 0px; top: 0px; 
	position: fixed; z-index: -1; opacity: 0.5;"></canvas>
	<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
