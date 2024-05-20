<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%User user=(User)session.getAttribute("userobj"); 
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>
<%@ include file="components/homenavbare.jsp" %>

   <h3 style="text-align: center"> Are you sure to want logout</h3>
   <p style="text-align: center">
	<a href="logout" class="btn btn-danger decoration-none">Yes,logout </a><br>
	<a href="home.jsp" class="btn btn-success decoration-none">No,Go to Home page </a>
	</p>


<%} %>
</body>
</html>