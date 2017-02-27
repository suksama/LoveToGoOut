<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
body{
	background:#39F;
}
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
	background-image:url(../images/login1.jpg);
	width:342px;
	height:280px;
	margin:auto;
} 
#username{ 
	width:280px;
	height:30px;
	margin-left:30px;
	margin-top:56px;
}
#password{ 
	width:280px;
	height:30px;
	margin-left:30px;
	margin-top:49px;
}
#remember{
	background:transparent;
	border:0;
	opacity: 0.8;
	border-radius:10px;
	margin-top:60px;
	margin-left:25px;
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
    margin-left:70px;
	
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

<script type="text/javascript" src="js/cookie.js"></script>  
<script type="text/javascript" src="js/common.js"></script>  

</head>
<body>
<a href="javascript:void(0)" id="linkbt" >登录</a>
<div id="light" >
    <div id="bg">
    <form action="">
        <a href="javascript:void(0)" id="closebt">×</a>
    	<input type="text"  id="username" name="username"><br/>
        <input type="password" id="password" name="password"><br/>
        <input type="checkbox" id="remember" name="remb">
        <label for="remember">keep me logged in</label>
        <input type="submit" id="click" name="click" value="LOGIN">
     </form>   
    </div>
    
</div> 
<div id="fade""></div> 
</body>
</html>