<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'memberRegister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="css/shopping.css" rel="stylesheet" type="text/css" >
 	<script language="javascript">
	function checkEmpty(memberForm){
		for(i=0;i<memberForm.length;i++){
			if(memberForm.elements[i].value==""){
				alert("表单信息不能为空");
				return false;
			}
		}
		if(document.memberForm.password.value!=document.memberForm.passwordOne.value){
			window.alert("您两次输入的密码不一致，请重新输入");
			return false;
		}
		if(isNaN(document.memberForm.age.value)){
			window.alert("年龄只能为数字");
			return false;
		}
	}
	function check(memberForm){
	    var ff=document.getElementById("memberForm");
	    var name=ff.name.value;
	    if(name==""){
			alert("用户名不能为空！");
			return false;
		}else{
	    	parent.location.href="memberAction.do?action=7&name="+name;   
        }
	}
	
	
  </script>

  </head>
  
  <body>
 	
    <div id="container"> 
    <div id="main">
    <center>
    <div id="allGoods">
    <table width="576" height="26" background="images/13.jpg">
      <tr><td align="center"><font size="3" color="white" face="宋体"><strong>景点添加</strong></font></td></tr>
	</table>
    <form id="memberForm" action="/LoveToGoOut/AddServlet" method="post" onSubmit="return checkEmpty(memberForm)">
    <table width="510"  border="1" id="table1" cellpadding="1" cellspacing="1" bordercolorlight="#FFFFFF" bordercolordark="#819BBC" >
       <tr>
        <td bgcolor="EAF2F5" align="center" height="35">景点名称</td>
        <td id="td1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="p_Name" />
        &nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
      <tr>
        <td bgcolor="EAF2F5" align="center" height="35">景点英文名</td> 
        <td id="td1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="p_Ename" />
        &nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
      <tr>
        <td bgcolor="EAF2F5" align="center" height="35">景点简介</td>
        <td id="td1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="p_Text" />
        &nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
     
     
      <tr>
        <td bgcolor="EAF2F5" align="center" height="35">城市名称</td>
        <td id="td1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="c_Name" />
        &nbsp;&nbsp;&nbsp;&nbsp;</td>
      </tr>
     
     
    </table>
	<br>  
	 <input type="image" class="Sumbit"  src="images/save.jpg" width="51" height="20" />
	 &nbsp;&nbsp;
	 <a href="#" onClick="javascript:memberForm.reset()"><img src="images/clear.gif" /></a>
	 &nbsp;&nbsp;
	 <a href="javascript:history.go(-1)"><img src="images/back.gif" /></a>
    </form>
    </div>
    </center>
    </div>
    </div> 
  </body>
</html>
