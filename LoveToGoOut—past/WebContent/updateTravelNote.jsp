<%@page import="com.ltgo.model.TravelNote"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
input[type="text"]{
width:200px;
height:30px;
}
</style>
</head>
<body>
<% 
	TravelNote tnote = (TravelNote)request.getAttribute("tnote");
%>
<div align="center">
<form method="post" action="/LoveToGoOut/UpdateTravelNoteServlet" enctype="multipart/form-data">
<table cellspacing="5" width="800px" >
	<tr>
		<td style="background:#cccccc;">游记编号:</td>
		<td><input type="text" name="Nid" value="<%=tnote.getNid() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;width:200px;">用户ID:</td>
		<td><input type="text" name="Nwriter" value="<%=tnote.getNwriter() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">游记名称:</td>
		<td><input type="text" name="Nname" value="<%=tnote.getNname() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">创建时间:</td>
		<td><input type="text" name="NcreateTime" value="<%=tnote.getNcreateTime() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">开始时间:</td>
		<td><input type="text" name="NstartTime" value="<%=tnote.getNstartTime() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">游玩天数:</td>
		<td><input type="text" name="Ntime" value="<%=tnote.getNtime() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">景点数:</td>
		<td><input type="text" name="NnumOfPoint" value="<%=tnote.getNnumOfPoint() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">图片数:</td>
		<td><input type="text" name="NnumOfPic" value="<%=tnote.getNnumOfPic() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;"> 图片:</td>
		<td><input type="text" name="Nphoto" value="<%=tnote.getNphoto() %>" /></td><br/>	
	<tr>
		<td>请选择上传的图片:<input type="file" name="image"/></td>	
		<td><img src="<%=tnote.getNphoto() %>" name="Nphotoshow" alt="images" width="200px" height="120px"/><br/></td>
	</tr>	
	</tr>
	<tr> 
	<td style="background:#cccccc;"> 收藏数:</td>
	<td><input type="text" name="Ncollect" value="<%=tnote.getNcollect() %>" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">浏览数:</td>
		<td><input type="text" name="Nview" value="<%=tnote.getNview() %>" /><br/></td>
	</tr>
	<tr>
		<td align="center" colspan="2"><input type="submit" value="修改" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>