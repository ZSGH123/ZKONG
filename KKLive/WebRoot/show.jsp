<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
  <head>
   
	<meta charset="UTF-8">
	<meta http-equiv="content-type" content="text/html">
  </head>
  
  <body>
    请求作用域：姓名：<s:property value="uname"/>
    </br>
    会话作用域：密码：${upass}
    </br>
    程序作用域：密码：${auser.uname}
     </br>
   [0]  <s:property value="[0]"/>
   </br>
   [1]  <s:property value="[1]"/>
   </br>
   ognl创建对象：属性，方法
                创建集合　　<s:property value="{'a','b','c'}[0]" /> ArrayList
    </br>
                 集合选择(过滤)：<s:property value="{5,6,7}.{?#this>6}" /> ArrayList
　　        创建Map LinkedHashMap　<s:property value="#{'mm':'MM','nn':'NN'}.get('mm')" /> 
                  <s:property value="#{'mm':'MM','nn':'NN'}.['mm']" />
               <s:property value="#{'mm':'MM','nn':'NN'}" />
    </br>
           创建用户对象 
       <s:property value="new entity.User()" />        
  </body>
</html>
