<%@page import="java.text.SimpleDateFormat,java.util.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>无标题文档</title>

<script type="text/javascript" src="js/login.js"></script>
<style type="text/css">
	body{
		width:100%;
		font:normal 100% Arial, Helvetica, sans-serif;
		margin:0 auto;
		}
	header{
		width:100%;
		height:400px;
		background-image: url(images/background2.jpg);
		
	}
	nav{
		width:100%;
		height:60px;
		background-color:#FFF;
		border:none;
		
	}
	#navtable{
		width:100%;
		height:100%;
		border: solid 1px;
		color:#727272;
		}
	#top{
		width:100%;
		height:45px;
		background-color:#353f4f;
	}
	#left{
		width:10%;
		height:800px;
		/*background-color:red;*/
		float:left;
		}
	#center{
		width:80%;
		height:800px;
		/*background-color:green;*/
		float:left;
		}
	#right{
		width:10%;
		height:800px;
		/*background-color:blue;*/
		float:right;
		/*clear:both;*/
		}
	#foot{
		width:100%;
		height:100px;
		background-color:yellow;
		float:right;
		/*clear:both;*/
		}
	#nav td{
		text-align:center;
		border-bottom:solid 1px #FFF;
		
	}
	#topnav a{
		text-align:right;
		border-bottom:solid 1px #FFF;
	}
	#nav td:hover{
		background-color:#fff;
		font-weight:900;
		color:#009;
		border-bottom:solid 1px #FFF;
		cursor:pointer;
		}

	[id^="test"]{
		width:100%;
		background-color:#333;
		color:#FFF;
		font-size:2em;
		padding-left:30px;
		padding-bottom:40px;
		padding-top:10px;
		border-bottom:solid 3px #999999;
		}
	[id^="test"]:hover{
		width:100%;
		background-color:#fff;
		color:#333;
		font-size:2em;
		padding-left:30px;
		padding-bottom:40px;
		padding-top:10px;
		border-bottom:solid 3px #999999;
		}
	iframe{
		width:100%;
		height:700px;
		border:none;
		}
		a{text-decoration: none;}
		#fade { 
  display:none; 
  position:absolute; 
  top:0%; 
  left:0%; 
  width:100%; 
  height:100%; 
  background-color:black; 
  z-index:1001; 
  -moz-opacity:0.8; 
  opacity:.80; 
  filter:alpha(opacity=80); 
} 
#light{ 
  
  display:none; 
  position:absolute; 
  top:25%; 
  left:25%; 
  width:55%; 
  height:50%;
  padding:16px;
  border:3px #CCCCCC; 
  z-index:1002; 
  overflow:auto; 
}
#bg{
	background-image:url(images/login2.jpg);
	width:342px;
	height:280px;
	margin:auto;
} 
#username{
	width:290px;
	height:35px;
	margin-right:2px;
	margin-top:56px;
}
#password{ 
	width:290px;
	height:35px;
	margin-right:25px;
	margin-top:45px;
}
#remember{
	background:transparent;
	border:0;
	margin-top:66px;
	margin-right:70px;
}
label{
	font-size:15px;
	color:#999;
}
#click{
	background:transparent;
	background-color:#6CF;
	color:#FFF;
	border-radius:20px;
	border:none;
	width:70px;
	height:30px;
    margin-right:20px;
	
}
#click:hover{
	background-color:#0FF;
}
#closebt{
	text-decoration: none;
	float:right;
	color:#6CF;
    height: 24px;
    width: 24px;
	font-size:24px;
}
#closebt:hover{
	text-decoration: none;
}
	
</style>

<script language="javascript">
	function changeweb(){
		document.getElementById("myframe").setAttribute("src","Notes.html");
	}
	function changeweba(){
		document.getElementById("myframe").setAttribute("src","LeaveMessage.jsp");
	}
	window.onload=function(){ 
   var linkbt=document.getElementById("linkbt"); 
   var light=document.getElementById('light'); 
   var fade=document.getElementById('fade'); 
   var closebt=document.getElementById("closebt"); 
   linkbt.onclick=function(){ 
     light.style.display='block'; 
     fade.style.display='block'; 
   } 
   closebt.onclick=function(){ 
     light.style.display='none'; 
     fade.style.display='none'; 
   } 
} 
	
</script>
</head>

<body>
 
<form action="/LoveToGoOut/AccountServlet" method="post">

	<div id="top" style="text-align: right;">
		<tr id="topnav">
			<a  href="#" style="color: #FFF; font-size:22px;" id="linkbt" >登录&nbsp&nbsp</a>
    <div id="light" >
    <div id="bg">
        <a href="javascript:void(0)" id="closebt">×</a>
    	<input type="text"  id="username" name="username"><br/>
        <input type="password" id="password" name="psw"><br/>
        <input type="checkbox" id="remember" name="remb">
        <label id="chksave" for="remember">keep me logged in</label>
        <button type="submit" id="click" name="click">LOGIN</button>
    </div>
    </div>   
	<div id="fade""></div> 
			<a href="index.html" style="color: #FFF; font-size:22px;">进入后台管理</a>
		</tr>
	</div>
	<header></header>
    <nav>
    <table id="navtable" border="0">
  <tr id="nav">
    <td width="15%" onclick="changeweb()">发现好游记</td>
    <td width="15%">使用手册</td>
    <td width="15%" >关于</td>
   
  </tr>
</table>
    </nav>
    <div id="main">
    	 <div id="left">
         </div>
         <div id="center">
        
         	<iframe src="Notes.html" id="myframe"/>
         </div>
         <div id="right"></div>
    </div>
     <div id="foot"></div>
     </form>
</body>
</html>
