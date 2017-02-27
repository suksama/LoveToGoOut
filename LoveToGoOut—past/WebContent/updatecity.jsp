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
  <td align="center"><font size="3" color="#F36D13" face="宋体"><strong>编辑城市</strong></font></td> 
 </tr>
</table>
<form action="${pageContext.request.contextPath}/UpdateCityServlet" method="post">
<table border="0" width="600px" align="center" bgcolor="#BBD3EB">
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>城市Id</td>
  <td>
   <input type="text" name="c_Id" value="${mana.c_Id}" disabled="disabled">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td>城市名称</td>
  <td>
   <input type="text" name="c_Name" value="${mana.c_Name}">
  </td>
 </tr>
<td>城市英文名</td>
  <td>
   <input type="text" name="c_Ename" value="${mana.c_Ename}">
  </td>
 </tr>
 <td>城市图片</td>
  <td>
   <input type="text" name="c_Photo" value="${mana.c_Photo}">
  </td>
 </tr>
 <td>所在地方</td>
  <td>
   <input type="text" name="c_Localtion" value="${mana.c_Localtion}">
  </td>
 </tr>
 <tr align="center" bgcolor="#FFFFFF" height="30">
  <td colspan="2">
   <input type="submit" class="btn" value="修改">
  </td>
 </tr>
</table>
  <input type="hidden" name="haccount" value="${mana.c_Name}">
</form>
</body>
</html>