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
<div align="center">
<form method="post" action="/LoveToGoOut/AddTravelNoteServlet" enctype="multipart/form-data">
<table cellspacing="5" width="800px" >
	<tr>
		<td style="background:#cccccc;">游记编号:</td>
		<td><input type="text" name="nid" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;width:200px;">用户ID:</td>
		<td><input type="text" name="nwriter"  /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">游记名称:</td>
		<td><input type="text" name="nname" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">创建时间:</td>
		<td><input type="text" name="ncreateTime"  /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">开始时间:</td>
		<td><input type="text" name="nstartTime"  /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">游玩天数:</td>
		<td><input type="text" name="ntime"  /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">景点数:</td>
		<td><input type="text" name="nnumOfPoint"  /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">图片数:</td>
		<td><input type="text" name="nnumOfPic" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">请选择上传的图片:</td>
		<td><input type="file" name="nimage"/></td>	
		
	</tr>	
	<tr> 
	<td style="background:#cccccc;"> 收藏数:</td>
	<td><input type="text" name="ncollect" /><br/></td>
	</tr>
	<tr>
		<td style="background:#cccccc;">浏览数:</td>
		<td><input type="text" name="nview"  /><br/></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		<input type="reset" value="重置"/>
		<input type="submit" value="修改" /></td>
	</tr>
</table>
</form>
</div>
</body>
</html>