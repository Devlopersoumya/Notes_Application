package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.NotesDao;
import com.org.dto.User;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("userobj");
		if(user==null) {
			resp.sendRedirect("login.jsp");
		}else {
			NotesDao dao=new NotesDao();
			dao.deleteById(id);
			session.setAttribute("addnotemsg", "Delete successfully");
			resp.sendRedirect("home.jsp");
		}
	}
}
