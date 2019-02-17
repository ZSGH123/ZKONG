<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
  <head>
   
	<meta charset="UTF-8">
	<meta http-equiv="content-type" content="text/html">
  </head>
  
  <body>
      <s:form action="producttestAction">
		      <s:textfield value='%{user.uname}' name="user.uname" key="username"></s:textfield>
		      <s:textfield name="strings[0]" key="username"></s:textfield>
		      <s:textfield name="strings[1]"></s:textfield>
		      <s:textfield name="lists[0]"></s:textfield>
		      <s:textfield name="lists[1]"></s:textfield>
		      <s:textfield name="map['a']"></s:textfield>
		      <s:textfield name="map['b']"></s:textfield>
		      <s:submit name="submit" value="提交"></s:submit>
		</s:form>
  </body>
  
</html>
