<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta charset="UTF-8">
	<meta http-equiv="content-type" content="text/html">
  </head>
  
  <body>
    <form name="loginone" method="post" action="userloginAction" enctype="application/x-www-form-urlencoded" target="_blank">
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
		<s:form action="producttestAction">
		      <s:textfield name="user.uname" key="username"></s:textfield>
		      <s:textfield name="strings[0]" key="username"></s:textfield>
		      <s:textfield name="strings[1]"></s:textfield>
		      <s:textfield name="lists[0]"></s:textfield>
		      <s:textfield name="lists[1]"></s:textfield>
		      <s:textfield name="map['a']"></s:textfield>
		      <s:textfield name="map['b']"></s:textfield>
		      <s:submit name="submit" value="提交"></s:submit>
		</s:form>
		<a href="userregisterAction">注册</a>
  </body>
</html>
