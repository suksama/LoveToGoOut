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
  <td align="center"><font size="3" color="#F36D13" face="宋体"><strong>更改票价</strong></font></td> 
 </tr>
</table>
<form action="${pageContext.request.contextPath}/UpdatePriceServlet" method="post">
<table border="0" width="600px" align="center" bgcolor="#BBD3EB">
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>参考网站</td>
  <td>
   <input type="text" name="pp_WebName" value="${mana.pp_WebName}" disabled="disabled">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>票价</td>
  <td>
   <input type="text" name="pp_Price" value="${mana.pp_Price}">
  </td>
 </tr>

 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td colspan="2">
   <input type="submit" class="btn" value="修改">
  </td>
 </tr>
</table>
  <input type="hidden" name="haccount" value="${mana.pp_WebName}">
</form>
</body>
</html>