<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ltgo.model.Manager"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update</title>
</head>
<style type="text/css">
 .btn{
  background-color: #BBD3EB;
  height:30px;
  width:75px;
 }
</style>
<body>
<%--
  Manager mana=(Manager)request.getAttribute("mana");
--%>
<table width=100% height="50" bgcolor="#FFFFFF">
 <tr>
  <td align="center"><font size="3" color="#F36D13" face="宋体"><strong>编辑管理员</strong></font></td> 
 </tr>
</table>
<form action="${pageContext.request.contextPath}/UpdateManagerServlet" method="post">
<table border="0" width="600px" align="center" bgcolor="#BBD3EB">
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>账号</td>
  <td>
   <input type="text" name="account" value="${mana.account}" disabled="disabled">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>密码</td>
  <td>
   <input type="text" name="password" value="${mana.password}">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>性别</td>
  <td>
   <input type="radio" name="sex" value="男" ${mana.sex=="男"?"checked":""}>男 
   <input type="radio" name="sex" value="女" ${mana.sex=="女"?"checked":""}>女
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>邮箱</td>
  <td>
   <input type="text" name="email" value="${mana.email}">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>登录时间</td>
  <td>
   <input type="text" name="time" value="${mana.time}">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td colspan="2">
   <input type="submit" class="btn" value="修改">
  </td>
 </tr>
</table>
  <input type="hidden" name="haccount" value="${mana.account}">
</form>
</body>
</html>