/**
 * 
 */
function $(objStr){return document.getElementById(objStr);}  
window.onload = function(){  
	   var linkbt=document.getElementById("linkbt"); 
	   var light=document.getElementById('light'); 
	   var fade=document.getElementById('fade'); 
	   var closebt=document.getElementById("closebt"); 
	   linkbt.onclick=function(){ 
	     light.style.display='block'; 
	     fade.style.display='block'; 
	   //分析cookie值，显示上次的登陆信息  
	     var userNameValue = getCookieValue("username");  
	     $("username").value = userNameValue;
	     var passwordValue = getCookieValue("password");  
	     $("password").value = passwordValue;      
	     //写入点击事件  
	     $("click").onclick = function()  
	     {  
	    	 
	    	 var userNameValue = $("username").value;  
	         var passwordValue = $("password").value;  
	         //服务器验证（模拟）      
	         var isAdmin = userNameValue == "admin" && passwordValue =="123456";  
	         var isUserA = userNameValue == "userA" && passwordValue =="userA";  
	         var isMatched = isAdmin || isUserA;  
	         if(isMatched){  
	             if( $("remember").checked){ 
	                 setCookie("username",$("username").value,24,"/");  
	                 setCookie("password",$("password").value,24,"/");  
	             }else{
	            	 deleteCookie("password","/");
	             } 
	             location.href = "/LoveToGoOut/manager.jsp"; 
//	             self.location.replace("welcome.html");  
	         }  
	         else {
	        	 deleteCookie("password","/");
	        	 alert("用户名或密码错误，请重新输入！");      
	         }
	     }  
	 } 
	   } 
	   closebt.onclick=function(){ 
	     light.style.display='none'; 
	     fade.style.display='none'; 
	   } 
    