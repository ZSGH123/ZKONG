<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<script type='text/javascript' src='js/jquery-1.7.2.min.js'></script>
<script type='text/javascript' src='js/../js/AjaxUtil.js'></script>
<script type="text/javascript">
      
      //重定向直播间
      function toLivehone(roomId){
         alert("进入ajax");
         var url = "userAction.do?command=toLiveHome&liveRoomId=" + roomId;
				$.ajax({
					url : url,
					method : "get",
					success : function() {
						alert("成功了");
					}
				});
      }
 /*     
      $(function(){
        alert("start");
        var roomId=70002;  //获得房间id
        
        $('#div1').click(function toLivehone(roomId){
         alert("进入ajax");
				$.ajax({
					url : "userAction.do?command=toLiveHome&liveRoomId=" + roomId,
					method : "get",
					success : function() {
						alert("成功了");
					}
				});
        });
      });
      */
      
</script>

</head>
<body>
     
      <div id="div1" style="height: 200px;width: 200px; background-color: red;">
      <a href="userAction.do?command=toLiveHome&liveRoomId=70002">点这</a>
      </div>
      <div id="div2" style="height: 200px;width: 200px; background-color: blue;">
      <a href="userAction.do?command=toLiveHome&liveRoomId=96291">点这</a></div>
</body>
</html>