<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
<style >
.change{
  color:yellow;
}

</style>
</head>
<body>
<%User user=(User)session.getAttribute("userobj"); 
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>


<% int id=user.getId(); 
  UserDao dao=new UserDao();
	User u=dao.FetchUserById(id);
%>

<%@ include file="components/homenavbare.jsp" %>
<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">User Details</p>
						<a href="editprofile.jsp" class="text-decoration-none btn btn-primary">Edit User Profile</a>
					</div>
				</div>
			</div>


 <h3 style="text-align: center;color:blue">
User name:<p class="change"><%=u.getName() %></p><br>
User age:<p class="change"><%=u.getAge() %></p><br>
User mobile:<p class="change"><%=u.getMobile() %></p><br>
User email:<p class="change"><%=u.getEmail() %></p><br>
</h3>


<%} %>
</body>
</html>