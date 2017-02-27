<%@page import="java.io.OutputStream"%>
<%@page import="com.ltgo.model.TravelNote"%>
<%@page import="com.ltgo.model.TravelNotePage"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	*{margin:0px;padding:0px;}
	body{font:"微软雅黑";font-size:14px;}
	a{text-decoration:none;}
	ul,li{list-style:none;}
	table{margin:0 auto;}
	hr{height:1px;border:none;border-top:1px solid #cccccc;}
	#search{margin:0 auto;}
	#content{height:40px;width:180px;margin:20px auto;}
	#submit{background-color:blue;}
	#searchid{height:25px;width:180px;margin-left:440px;}
	#box{height:auto;width:80%;border:0 solid #aaa;margin:0 auto;overflow:hidden;}
	.top{height:100px;}
	 /* .top a{height:16px; width:16px;display:block;float:right;margin:5px;}  */
	.btn-list-off{background-image:#fff url(images/btns.jpg) no-repeat -38px 0px;}
	.btn-car-on{background:#fff url(images/btns.jpg) no-repeat -21px -34px;}
	.btn-list-on{background-image:#fff url(images/btns.jpg) no-repeat -21px 0px;}
	.btn-car-off{background:#fff url(images/btns.jpg) no-repeat -38px -32px;}
	
	#box ul li{height:auto;width:383px;border:1px solid #aaa;float:left;margin:7px;} 
	.a-img{height:164px;width:383px;display:block;overflow:hidden;}
	p a,p span{
		display:block;
		line-height:23px;
		padding-left:10px;
	}
	.bottom{height:40px;line-height:40px;text-align:center;background-color:#ccc;}
	.small{height:50px;width:50px;float:left;margin:5px;}
</style>
<script type="text/javascript">
	function deleteTravelNote(Nid){
		var flag = window.confirm("确定删除吗");
		if(flag){
			location.href = "/LoveToGoOut/DeleteTravelNoteServlet?Nid="+Nid;
		}
	}
	function updateTravelNote(Nid){
		location.href="/LoveToGoOut/ToUpdateTravelNoteServlet?Nid="+Nid;
	}
	function find(){
		var input = document.getElementById("searchid");
		var searchContent = input.value;
		location.href = "/LoveToGoOut/ShowTravelNoteServlet?searchContent="+searchContent;
	}
</script>
</head>
<body>
<%
	TravelNotePage tpage = (TravelNotePage)request.getAttribute("tpage");
	String searchContent = (String)request.getAttribute("searchContent");
%>
<div id="box">

	<div class="top">
	<form action="">
	<table width="100%" height="80px">
	<tr>
		<!-- <a href="#" title="列表模式" id="btn1" class="btn-list-off">列表模式</a>
		<a href="#" title="卡片模式" id="btn2" class="btn-car-on">卡片模式</a> -->
		<td>
			<input type="text" name="searchcontent"  onkeyup="textChange(this.value)" value="<%=searchContent%>" id="searchid"/>
		    <a href="#" onclick="find()">搜索</a> 
		
	    <a href="addTravelNote.jsp">
		<img src="images/index1_86.gif" alt="add" style="float:right"/></a>
		</td>
	</tr>
	</table>
	</form>
	</div>
	<table border="0" width="600px" align="center" cellspacing="20">
			<%
				for(int i = 0;i<tpage.getData().size();i++){
				String defaultPic = "images/index1_86.gif";
				if(i%2==0){
					TravelNote tNote = tpage.getData().get(i);
			%>
		
			<tr>
			<td><br/>
			<img src="<%=((tNote.getNphoto()==null || tNote.getNphoto().equals("")) ?defaultPic: tNote.getNphoto()) %>" alt="请添加" width="480px" height="288px" style="border-radius:15px;"/><br/>
			<div align="center"><%=tNote.getNname() %></div><br/>
			<%=tNote.getNstartTime() %>/
			<%=tNote.getNtime() %>/天
			<%=tNote.getNnumOfPic() %>/图<br/>
			<div aligh="right">
			<a href="#" onclick= "deleteTravelNote(<%=tNote.getNid() %>)">
			<img src="images/index1_84.gif" alt="delete" style="float:right"/></a>
			<a href="#" onclick= "updateTravelNote(<%=tNote.getNid() %>)">
			<img src="images/index1_82.gif" alt="update" style="float:right"/></a>
			</div><br/><br/>
			<hr/>
			</td>
			 <%}else{
				TravelNote tNote = tpage.getData().get(i);
			%>
			
			<td><br/>
			<img src="<%=((tNote.getNphoto()==null || tNote.getNphoto().equals("")) ?defaultPic: tNote.getNphoto()) %>" alt="请添加" width="480px" height="288px" style="border-radius:15px;"/><br/>
			<div align="center"><%=tNote.getNname() %></div><br/>
			<%=tNote.getNstartTime() %>/
			<%=tNote.getNtime() %>天/
			<%=tNote.getNnumOfPic() %>图<br/>
			<div aligh="right">
			<a href="#" onclick= "deleteStudent(<%=tNote.getNid() %>)">
			<img src="images/index1_84.gif" alt="delete" style="float:right"/></a>
			<a href="#" onclick= "updateTravelNote(<%=tNote.getNid() %>)">
			<img src="images/index1_82.gif" alt="update" style="float:right"/></a>
			</div><br/><br/>
			<hr/>
			</td>
			</tr> 
			
			<%} %>
			
			<%} %>
	<tr align="center">
 	<td colspan="2">
		当前<%=tpage.getCurrentPage()%>页 共<%=tpage.getTotalPage() %>页
 			<% if(tpage.getCurrentPage() == 1){ %>
 				上一页
 			<%}else{%>
	 			<a href="/LoveToGoOut/ShowTravelNoteServlet?currentPage=<%=tpage.getCurrentPage() - 1%>&searchContent=<%=searchContent%>">上一页</a> 
	 		<%} %>
	 		
	 		<% if(tpage.getTotalPage() <= tpage.getCurrentPage()){ %>
 				下一页
 			<%}else{%>
	 			<a href="/LoveToGoOut/ShowTravelNoteServlet?currentPage=<%=tpage.getCurrentPage() + 1%>&searchContent=<%=searchContent%>">下一页</a>
	 		<%} %>
 	</td>
 	</tr>
	</table>	
</div>
</body>
</html>