<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import ="com.ltgo.model.*,java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'altertable.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="/LoveToGoOut/AlterServlet" method="post">
  <% List<PlaceView> list=(List<PlaceView>)request.getAttribute("list"); %>
   <table width="510" id="table2" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3DABF" bgcolor="#5DC3F8">
   <tr>
       <td width="23%" height="30"><div align="center">ID</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="id" type="text" size="35" value="<%=list.get(0).getP_Id() %>" disabled="disabled">
       <input type="hidden" name="id" value="<%=list.get(0).getP_Id() %>"/>
       </td>
     </tr>
     <tr>
       <td width="23%" height="30"><div align="center">景点名称</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="p_Name" type="text" size="35" value="<%=list.get(0).getP_Name() %>"></td>
     </tr>
      <tr>
       <td width="23%" height="30"><div align="center">景点英文名</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="p_Ename" type="text" size="35" value="<%=list.get(0).getP_Ename() %>"></td>
     </tr>
   	<tr>
       <td width="23%" height="30"><div align="center">景点简介</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="p_Text" type="text" size="35" value="<%=list.get(0).getP_Text() %>"></td>
     </tr>
     <tr>
       <td width="23%" height="30"><div align="center">经纬度</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="p_Local" type="text" size="35" value="<%=list.get(0).getP_Local() %>"></td>
     </tr>
     <tr>
       <td width="23%" height="30"><div align="center">城市Id</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="c_Id" type="text" size="35" value="<%=list.get(0).getC_Id() %>" ></td>
     </tr>
     <tr>
       <td width="23%" height="30"><div align="center">城市</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="c_Name" type="text" size="35" value="<%=list.get(0).getC_Name() %>" disabled="disabled"></td>
       <input type="hidden" name="c_Name" value="<%=list.get(0).getC_Name()%>"/>
     </tr>
     <tr>
       <td width="23%" height="30"><div align="center">城市英文名</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="c_Ename" type="text" size="35" value="<%=list.get(0).getC_Ename() %>" disabled="disabled"></td>
       <input type="hidden" name="c_Ename" value="<%=list.get(0).getC_Ename() %>"/>
     </tr>v
    
    
     
    
     
    
   </table>
   <div>
   	 <input type="image" class="Sumbit"  src="images/index1_82.gif" />
   </div>
   </form>
  </body>
</html>
