package com.org.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@WebServlet("/edit")
public class EditprofileServlet extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userobj");
		
		user.setName(name);
		user.setEmail(email);
		user.setAge(age);
		user.setMobile(mobile);
		user.setNotes(user.getNotes());
		
		Notes note =new Notes();
		note.setUser(user);
		
		UserDao dao=new UserDao();
		dao.SaveAndUpdateUser(user);
		
		session.setAttribute("editmsg", "Profile Edit Successfully");
		resp.sendRedirect("editprofile.jsp");
	}

}
