<%@page import="com.org.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="components/bootstrapCss.jsp" %>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
<%User user=(User)session.getAttribute("userobj"); 
	if(user==null){
		response.sendRedirect("login.jsp");
	}else{
%>

<%@ include file="components/homenavbare.jsp" %>

<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Add Note Here</p>
						
						<form action="addnotes" method="post">
						<div class="mb-3">
								<label class="form-label">Title</label> <input
									name="title" type="text" class="form-control" required>
							</div>
								<label class="form-label">Description</label>
								<textarea rows="10" cols="46" class="form-control" name="description"></textarea>	
							</div>
							<button type="submit" class="btn bg-primary text-white col-md-12">Add </button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


<%} %>
</body>
</html>