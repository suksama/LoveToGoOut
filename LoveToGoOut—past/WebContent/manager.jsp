<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
<script type="text/javascript" src="js/index.js"></script>
<script language="javascript">
	function changeweb(){
		document.getElementById("myframe").setAttribute("src","/LoveToGoOut/ShowTravelNoteServlet");
	}
	function changeweb1(){
		document.getElementById("myframe").setAttribute("src","LeaveMessage.jsp");
	}
	function changeweb2(){
		document.getElementById("myframe").setAttribute("src","Setting.html");
	}
	function changeweb3(){
		document.getElementById("myframe").setAttribute("src","managerRegister.jsp");
	}
	function changeweb4(){
		document.getElementById("myframe").setAttribute("src","/LoveToGoOut/ShowManagerServlet");
	}
	function changeweb5(){
		document.getElementById("myframe").setAttribute("src","/LoveToGoOut/PageServlet");
	}
</script>
<style type="text/css">
iframe{
		width:100%;
		height:1400px;
		border:none;
		}
</style>


</head>

<body>
<div class="nav-top">
	<span>个人后台管理系统</span>
    <div class="nav-topright">
    	<p>上次登陆时间：2015-09-05 22:33:50   登陆IP：192.168.1.1</p>
        <span>您好：<%=request.getSession().getAttribute("user").toString() %></span><span>注销</span>
    </div>
</div>
<div class="nav-down">
	<div class="leftmenu1">
        <div class="menu-oc"><img src="images/menu-all.png" /></div>
    	<ul>
        	
            <li>
            	<a class="a_list a_list2">权限管理</a>
                <div class="menu_list">
                	<a onclick="changeweb2()">基本权限</a>
                  
                    <a onclick="changeweb3()">添加管理员</a>
                </div>
            </li>
            <li>
            	<a class="a_list a_list3">游记管理</a>
                <div class="menu_list">
                	<a onclick="changeweb()">游记中心</a>
                    <a onclick="changeweb1()">添加游记</a>
                    <a href="#">修改游记</a>
                    <a href="#">删除游记</a>
                </div>
            </li>
            <li>
            	<a class="a_list a_list3">攻略管理</a>
                <div class="menu_list">
                	<a onclick="changeweb5()">攻略中心</a>
                    <a href="#">添加攻略</a>
                    <a href="#">修改攻略</a>
                    <a href="#">删除攻略</a>
                </div>
            </li>
        </ul>
    </div>
    <div class="leftmenu2">
    	<div class="menu-oc1"><img src="images/menu-all.png" /></div>
        <ul>
        	<li>
            	<a class="j_a_list j_a_list1"></a>
                <div class="j_menu_list j_menu_list_first">
                	<span class="sp1"><i></i>全局设置</span>
                	<a class="j_lista_first" onclick="changeweb()">游记中心</a>
                    <a onclick="changeweb5()">攻略中心</a>
                    <a href="#">帮助</a>
                    <a href="#">关于</a>
                </div>
            </li>
            <li>
            	<a class="j_a_list j_a_list2"></a>
                <div class="j_menu_list">
                	<span class="sp2"><i></i>权限管理</span>
                	<a onclick="changeweb2()">超级管理员</a>
                    <a onclick="changeweb4()">用户管理</a>
                </div>
            </li>
            
        </ul>
        
    </div>
    <div class="rightcon">
    	<div class="right_con">
        	<p style="text-align:left; margin-top:50px"></p>
            <p style="text-align:center">
            	<iframe src="/LoveToGoOut/ShowTravelNoteServlet" id="myframe"/>
            </p>
            <p style="text-align:right"></p>
           
        </div>
    </div>
</div>
<div style="text-align:center;">
	
</div>

</body>
</html>