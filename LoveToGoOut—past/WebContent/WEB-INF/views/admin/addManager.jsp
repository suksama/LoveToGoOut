<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
 .btn{
  background-color: #BBD3EB;
  height:30px;
  width:75px;
 }
</style>
<body>
<table width=100% height="50" bgcolor="#FFFFFF">
 <tr>
  <td align="center"><font size="3" color="#F36D13" face="宋体"><strong>添加管理员</strong></font></td>
 </tr>
</table>
<form action="${pageContext.request.contextPath}/AddManagerServlet.do" method="post"">
<table border="0" width="600px" align="center" bgcolor="#BBD3EB">
 <tr bgcolor="#FFFFFF" height="30">
  <th>账号</th>
  <th>
    <input type="text" name="account">
  </th>
 </tr>
 <tr bgcolor="#FFFFFF" height="30">
  <th>密码</th>
  <th>
    <input type="password" name="password">
  </th>
 </tr>
 <tr bgcolor="#FFFFFF" height="30">
  <th>性别</th>
  <th>
    <input type="radio" name="sex" value="男" checked>男
    <input type="radio" name="sex" value="女">女
  </th>
 </tr>
 <tr bgcolor="#FFFFFF" height="30">
  <th>邮箱</th>
  <th>
    <input type="email" name="email">
  </th>
 </tr>
 <tr bgcolor="#FFFFFF" height="30">
  <th >登录时间</th>
  <th>
    <input type="text" name="time">
  </th>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td colspan="2">
   <input type="submit" class="btn" value="添加">
  </td>
 </tr>
</table>
</form>
</body>
</html>