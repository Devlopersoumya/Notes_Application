<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit profile</title>
<%@ include file="components/bootstrapCss.jsp" %>
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
<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Edit Profile Page</p>
						
						<% String msg=(String)session.getAttribute("editmsg"); 
						    if(msg!=null){%>
						    	<p class="text-center text-success fs-4"><%= msg%></p>
						 <% 
						 session.removeAttribute("editmsg");
						    }
						%>
						<form action="edit" method="post">
							<div class="mb-3">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" value="<%=u.getName()%>"required>
							</div>
							<div class="mb-3">
								<label class="form-label">Age</label> <input name="age"
									type="tel" class="form-control" value="<%=u.getAge()%>"required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile</label> <input name="mobile"
									type="tel" class="form-control" value="<%=u.getMobile()%>"required>
							</div>
							<div class="mb-3">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control" value="<%=u.getEmail()%>"required>
							</div>
							
							<button type="submit" class="btn bg-primary text-white col-md-12">Edit</button>
						</form>

					</div>
				</div>
			</div>
		</div>
	</div>


<%} %>
</body>
</html>