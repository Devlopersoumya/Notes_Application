<%@page import="com.org.dao.UserDao"%>
<%@page import="com.org.dto.Notes"%>
<%@page import="java.util.List"%>
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
<h3 style="text-align: center; color:green"> welcome to Home page</h3>

  <% String addnotemsg=(String)session.getAttribute("addnotemsg"); 
    if(addnotemsg!=null){%>
		<p class="text-center text-success fs-4"><%= addnotemsg%></p>
	 <% 
	 session.removeAttribute("addnotemsg");
						    }
	%>
	<% 
	    int id=user.getId();
	    UserDao dao=new UserDao();
	    User u=dao.FetchUserById(id);
	   List<Notes> list= u.getNotes();
	%>
<div class="container border">
  <div>
  <a href="add_note.jsp" class="btn btn-sm btn-primary">Add Note</a>
  </div>

<div class="row">
   <% for(Notes n:list){
	   %>
	   
	   <div class="col-md-4 card border border-primary m-4" style="width:15em;" > 
	       <div class="card-body">
	       
	       <div class="d-flex flex-wrap justly-content-evenly">
	       <div>
	         <h2 class="text-success card-title"><%=n.getTitle() %></h2>
	         <a href="view_note.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">view</a>
	         <a href="view_note.jsp?id=<%=n.getId()%>" class="btn btn-sm btn-info">update</a>
	         <a href="delete?id=<%=n.getId()%>" class="btn btn-sm btn-info">delete</a>
	         </div>
	       </div>
	       
	       </div>
	   </div>
	   <% 
   }
	   %>
   </div>
</div>
<%} %>
</body>
</html>