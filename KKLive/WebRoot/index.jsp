<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta charset="UTF-8">
	<meta http-equiv="content-type" content="text/html">
  </head>
  
  <body>
    <form name="loginone" method="post" action="LoginAction" enctype="application/x-www-form-urlencoded" target="_blank">
			<table border="1" width="300" cellspacing="0" style="font-size: 12px;font-style: normal; color: burlywood; border-color: burlywood;">
			<caption align="center"><font color="burlywood"><b>用户注册</b></font></caption>
			<tr>
			  <td align="left" width="80" bgcolor="aqua" background=""> 姓名:</td>	
			  <td align="left" width="220"><input type="text" name="uname" ></td>	
			</tr>
			<tr>
			  <td align="left" width="80"> 密码:</td>	
			  <td align="left" width="220"><input type="password" name="upass" ></td>	
			</tr>
			<tr>
			  <td align="center" colspan="2">
			  	<input type="submit" name="login" value="登陆"/>
			  </td>	
			  	
			</tr>
			</table>	
		</form>
  </body>
</html>
