<%@page import="com.ltgo.model.ManagerPage"%>
<%@page import="com.ltgo.model.Manager"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
 /* $(document).ready(function(){
	 $("#select").click(function(){
		 $("input[name='checkbox']").attr("checked",this.checked);
	 });
	 var $checkbox=$("input[name='checkbox']");
	 $checkbox.click(function(){
		 $("#select").attr("checked",$checkbox.length==$("input[name='checkbox']:checked").length?true:false);
	 });
 }) */

  function deleteManager(account){
	var flag=window.confirm("您确定删除么？");
	if(flag){
		var chkvalue="";
	    var chk = document.getElementsByName("check");
		for(var i=0;i<chk.length;i++){
			if(chk[i].checked){
				chkvalue=chkvalue+","+chk[i].value+"";
				flag=true;
			}
		} 
		location.href = "${pageContext.request.contextPath}/DeleteManagerServlet?checkbox="+chkvalue;
	}
}
</script>
<body>
<%--
 ManagerPage managerPage=(ManagerPage)request.getAttribute("page");
--%>
<td width="70%" valign="top">
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
              
       <tr>
         <td background="images/index1_45.gif"></td>
           <td bgcolor="#FFFFFF" style="height:490px; vertical-align:top;">
             <table width="100%" border="0" cellspacing="10" cellpadding="0">
               <tr>
                 <td>
                   <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#C4E7FB">
                     <tr>
                       <td>
                         <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FFFFFF">
                         <tr>
                           <td>&nbsp;
                             <a href="#" class="font1">权限设置</a> &gt; 
                             <a href="#" class="font1">用户管理</a> 
                           </td>
                         </tr>
                         </table>
                       </td>
                     </tr>
                   </table>
                 </td>
               </tr>
               <tr>
                 <td>
                   <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#BBD3EB">
                     <tr height="50">
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">&nbsp;</td>
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">用户账号</td>
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">用户密码 </td>
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">性别</td>
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">EMAIL</td>
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">上次登录时间</td>
                       <td align="center" background="images/index1_72.gif" bgcolor="#FFFFFF">操作</td>
                     </tr>
                     
                     <c:forEach items="${page.data}" var="manager">
                     <tr>
                       <td height="35" align="center" bgcolor="#FFFFFF">
                         <label>
                           <input type="checkbox" name="check" value="${manager.account}" />
                         </label>
                       </td>
                       <td height="35" align="center" bgcolor="#FFFFFF">${manager.account}</td>
                       <td height="35" align="center" bgcolor="#FFFFFF">${manager.password}</td>
                       <td height="35" align="center" bgcolor="#FFFFFF">${manager.sex}</td>
                       <td height="35" align="center" bgcolor="#FFFFFF">${manager.email}</td>
                       <td height="35" align="center" bgcolor="#FFFFFF">${manager.time}</td>
                       <td height="35" align="center" bgcolor="#FFFFFF">
                         <a href="/LoveToGoOut/ToUpdateManagerServlet?account=${manager.account}">
                         <img src="images/index1_82.gif" width="74" height="31" border="0" /></a>
                       </td>
                     </tr>
                     </c:forEach>
                       
                  </table>
                </td>
              </tr>
              <tr>
                <td>
                  <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#E1E5E8">
                    <tr>
                      <td>
                        <table width="100%" border="0" cellpadding="0" cellspacing="5" bgcolor="#FDFDFF">
                          <tr>
                            <td>&nbsp; 
                              <label>
                                <input type="checkbox" name="checkbox" value="checkbox" />
                              </label>&nbsp;全选&nbsp;&nbsp;
                              <label>
                                <input type="checkbox" name="checkbox" value="checkbox" />
                              </label>&nbsp;全不选
                            </td>
                          </tr>
                        </table>
                      </td>
                    </tr>
                  </table>
                 </td>
               </tr>
                    <tr>
                      <td>
                        <a href="addManager.jsp"><img src="images/index1_86.gif" width="74" height="31" border="0" /></a>&nbsp;
                        <a href="#" onclick="deleteManager(${manager.account})"><img src="images/index1_84.gif" width="74" height="31" border="0" /></a>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <c:choose>
                          <c:when test="${page.currentPage == 1}">上一页
                          </c:when>
                          <c:otherwise>
                        <a href="/LoveToGoOut/ShowManagerServlet?currentPage=${page.currentPage-1}">上一页</a>
                        </c:otherwise>
                        </c:choose>
                        <c:choose >
                        <c:when test="${page.currentPage == page.totalPage}">下一页
                        </c:when>
                        <c:otherwise>
                        <a href="/LoveToGoOut/ShowManagerServlet?currentPage=${page.currentPage+1}">下一页</a>
                        </c:otherwise>
                        </c:choose>
                                                            第${page.currentPage}页 共${page.totalPage}页
                      </td>
                    </tr>
                    
         </table>
      </td>
                     
              
</body>
</html>