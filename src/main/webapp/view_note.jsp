<%@page import="com.org.dao.NotesDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Note</title>
<%@ include file="components/bootstrapCss.jsp" %>
</head>
<body>
<%User user=(User)session.getAttribute("userobj"); 
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>
<%@ include file="components/homenavbare.jsp" %>
  <% int id=Integer.parseInt(request.getParameter("id"));
    NotesDao dao=new NotesDao();
   Notes notes= dao.fetchNotesById(id);
  %>
		   
		   <div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center"><%=user.getName() %> Note</p>
						
						<form action="update" method="post">
						<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control" value="<%=notes.getTitle()%>"required>
							</div>
								<label class="form-label">Description</label>
							<textarea rows="10" cols="46" name="description"><%=notes.getDescription() %></textarea>
							</div>
							<input type="hidden" name="id" value="<%=notes.getId()%>">
					<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
					<a href="home.jsp">Back</a>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	
   
<%} %>

</body>
</html>