<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'liandong.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$("#colleges").change(function(){
				var teacherSel=$("#teacher");
				
				teacherSel.find("option").not(":eq(0)").remove();
				
				var collegeid = this.value;
				
				if(collegeid){
					$.getJSON("${pageContext.request.contextPath }/example/ajaxTeacherList.action?collegeid="+collegeid,
					function(data){
						$(data).each(function() {
							teacherSel.append(new Option(this.tname,this.id));
							
						});
					
					});
					
				}	
			
			
			});
		
		});
	
	</script>

  </head>
  
  <body>
    
  	<select id="colleges">
  		<option>选择院校</option>
  		<c:forEach items="${collegeList }" var="college">
  			<option value="${college.id }">${college.cname }</option>
  		</c:forEach>
  	</select>
  	<select id="teacher">
  		<option>选择教师</option>
  	</select>
    
  </body>
</html>
