<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import ="com.ltgo.model.*,java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style1.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script language="javascript">
function add(){
		var flag = window.confirm("您确定添加吗？");
		if(flag){
			//发送请求并删除
			location.href = "/LoveToGoOut/addplace.jsp";
		}
	}
	function find(){
		var input = document.getElementById("searchid");
		var searchContent = input.value;
		location.href = "/LoveToGoOut/PageServlet?searchcontent="+searchContent;
	}
$(function(){	
	//导航切换
	$(".imglist li").click(function(){
		$(".imglist li.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>
</head>


<body>
<form action="/LoveToGoOut/DeleteServlet" method="post">
<% 
	PlacePage page1=(PlacePage)request.getAttribute("page");
	List<PlaceView> data=page1.getData();
 %>
	<div class="place">
    
    <ul class="placeul">
    <li><a href="#">攻略中心</a></li>
    <li><a href="#">景点列表</a></li>
    </ul>
    </div>
    
    <div class="rightinfo">
    
    <div class="tools">
    	<ul class="toolbar">
        <li onclick="add()"><img src="images/index1_86.gif" /></li>
        <li><input type="image" class="Sumbit"  src="images/index1_84.gif" /></li>
        <li><input type="text" name="searchcontent" id="searchid"/></li>
        <li><a href="#" onclick="find()">搜索</a></li>
        </ul>
        
    </div>
    
    
    <table class="imgtable">
    
    <thead>
    <tr>
     <th align="center"  bgcolor="#FFFFFF">选项</th>
    <th width="100px;">景点图片</th>
    <th>景点名称</th>
    <th>景点简介</th>
    <th>景点经纬度</th>
    <th>城市</th>
   
    
    <th align="center"  bgcolor="#FFFFFF">操作</th>
    </tr>
    </thead>
    
    <tbody>
    
    <% for(int i=0;i<data.size();i++){
    PlaceView d=data.get(i);
   %>
    <tr>
    <td  align="center" bgcolor="#FFFFFF">
        <label>
             <input type="checkbox" name="checkbox" value="<%=d.getP_Id() %>" />
        </label>
    </td>
    <td class="imgtd"><img src="images/img11.png" /></td>
    <td><a href="/LoveToGoOut/ShowPriceServlet?name=<%=d.getP_Name()%>"><%=d.getP_Name() %></a><p><%=d.getP_Ename() %></p></td>
    <td><%=d.getP_Text() %></td>
    <td><%=d.getP_Local() %></td>
    <td><a href="/LoveToGoOut/ShowCityServlet?cityname=<%=d.getC_Name()%>"><%=d.getC_Name() %></a><p><%=d.getC_Ename() %></td>
    
    <td><a href="/LoveToGoOut/ShowServlet?id=<%=d.getP_Id() %>" />编辑</td>
    </tr>
    
  <%} %>
    </tbody>
    
    </table>
    
    
   
    <div class="pagin">
    	<tr align="center">
			<td colspan="6">当前<%=page1.getCurrentPage()%>页 共<%=page1.getTotalPage() %>页
				<% if(page1.getCurrentPage() == 1){ %> 上一页 <%}else{%> <a
				href="/LoveToGoOut/PageServlet?currentPage=<%=page1.getCurrentPage() - 1%>">上一页</a>
				<%} %> <% if(page1.getTotalPage() <= page1.getCurrentPage()){ %>
				下一页 <%}else{%> <a
				href="/LoveToGoOut/PageServlet?currentPage=<%=page1.getCurrentPage() + 1%>">下一页</a>
				<%} %>
			</td>
		</tr>
    </div>
    
    
  
<script type="text/javascript">
	$('.imgtable tbody tr:odd').addClass('odd');
	</script>
    </form>
</body>

</html>
