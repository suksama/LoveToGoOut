<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'managerRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link href="css/shopping.css" rel="stylesheet" type="text/css" >
	<script language="javascript">
	function checkEmpty(form){
	for(i=0;i<form.length;i++){
	if(form.elements[i].value==""){
	alert("表单信息不能为空");
	return false;
	}
	}
	}
	</script>
  </head>
  
  <body>
  <div id="container">
   
  <center>
  <form action="managerServlet" method="post"  name="form" onSubmit="return checkEmpty(form)" >
    <table width="559" height="26" background="image/02.png">
     <tr><td align="center"><font size="3" color="#F36D13" face="宋体"><strong>${editManager==null?'添加':'编辑'}管理员</strong></font>
         <!-- 在表单中增加一个隐藏域，用于传递一个参数 -->
         <input type="hidden" name="mid" value="${editManager.id}"/>
	     <input type="hidden" name="acode" value="${editManager==null?2:6}">
     </td></tr>
    </table>
    <!-- EL表达式语言 -->
    <br><br>
    <table width="510" id="table2" border="1" cellpadding="0" cellspacing="0" bordercolor="#D3DABF" bgcolor="#5DC3F8">
     <tr>
       <td width="23%" height="30"><div align="center">用户名</div></td>
       <td width="77%" bgcolor="#FFFFFF">&nbsp;
       <input name="account" type="text" size="35" value="${editManager.account}"></td>
     </tr>
     <tr>
       <td height="30"><div align="center">密&nbsp;码</div></td>
       <td bgcolor="#FFFFFF">&nbsp;
       <input name="password" type="password" size="35" value="${editManager.password}"></td>
     </tr>
     <tr>
       <td height="30"><div align="center">姓&nbsp;名</div></td>
       <td bgcolor="#FFFFFF">&nbsp;
       <input name="name" type="text" size="35" value="${editManager.name}"> 
       <input name="sign" type="hidden" value="0"></td>
     </tr>
     <tr>
       <td height="30"><div align="center">管理员角色</div></td>
       <td bgcolor="#FFFFFF">&nbsp; 
	       <input name="sign" type="radio" value="0" ${editManager.sign==0?"checked='checked'":""}>一般管理员
	       <input name="sign" type="radio" value="1" ${editManager.sign==1?"checked='checked'":""}>超级管理员
       </td>
     </tr>
     </table>
	 <br>  
     <input type="image" class="Submit"  src="images/save1.jpg" width="51" height="20">
     &nbsp;&nbsp;
     <a href="#" onClick="javascript:managerForm.reset()"><img src="images/clear1.gif"></a>
     &nbsp;&nbsp;
     <a href="javascript:history.go(-1)"><img src="images/back1.gif" /></a>
     </form>
	 <%
	 if(request.getAttribute("reslut")!=null){
	 %>
	 <P align="center"><%=request.getAttribute("reslut")%></P>
	 <%}%>	
	 </center>	
 </div>
    
  </body>
</html>
