<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>My JSP 'list.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#selectAll").click(function(){
			$("[name=\"ids\"]").prop("checked",$(this).prop("checked"));
		});
		});
	</script>
  </head>
  <body>
  	
  	<form action="${pageContext.request.contextPath }/user/list.action" method="post">
  	用户名：<input type="text" name="username" value="${user.username }"/>
  	<br/>
  	姓名：<input type="text" name="name" value="${user.name }"/>
  	<br/>
  	地址：<input type="text" name="addr" value="${user.addr }"/>
  	<br/>
  	<input type="submit" value="search" />
  	
  	</form>
  	
  	<form action="${pageContext.request.contextPath }/user/batchDel.action" method="post">
  	<input type="submit" value="批量删除">
  	<hr/>
    <input type="checkbox" id="selectAll" />全选
    <br/>
    <c:forEach items="${userList }" var="user">
    	<input type="checkbox" name="ids" value="${user.uid }" />
    	${user.uid }  ${user.username }  ${user.name }  ${user.addr }
    	<a href="${pageContext.request.contextPath }/user/del.action?id=${user.uid }">删除</a>   	
    	<a href="${pageContext.request.contextPath }/user/edit.action?id=${user.uid }">更新</a>   	
    	<hr>  
    </c:forEach>
    </form>   
    <a href="${pageContext.request.contextPath }/user/add.action?">添加</a> 
    <hr/>
    
    <%@ include file="/WEB-INF/content/pager.jsp" %>
     
  </body>
</html>
