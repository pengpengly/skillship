<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <!--引入struts标签 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table width="80%" border="1" cellspacing="0" cellpadding="5" align="center" style="text-align:center;">
  <tr>
    <td colspan="3" align="center">管理列表</td>
  </tr>
  <tr>
    <td width="40%" align="center">用户名</td>
    <td width="40%" align="center">密码</td>
     
    <td align="center">操作</td>
  </tr>
  
  
  <s:iterator value="ulist" var="u">
  <tr>
    <td><s:property value="#u.name" /></td>
    <td><s:property value="#u.pwd" /></td>
    
    <td>
    <a href="zy!input.action?id=<s:property value="#u.id" />">修改</a>
    <a href="zy!delete.action?id=<s:property value="#u.id" />">删除</a>
    </td>
  </tr>
  </s:iterator>
  
  
</table>
</body>
</html>