package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@WebServlet("/change")
public class ChangepwdServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String currentpwd = req.getParameter("currentpwd");
		String newpwd = req.getParameter("newpwd");
		String confompwd = req.getParameter("confompwd");
		
		HttpSession session = req.getSession();
		User user =(User) session.getAttribute("userobj");
		
		if(currentpwd.equals(user.getPassword())) {
			 if(newpwd.equals(confompwd)) {
				 user.setPassword(confompwd);
				 user.setNotes(user.getNotes());
				 new Notes().setUser(user);
				 
				 UserDao dao=new UserDao();
				 dao.SaveAndUpdateUser(user);
				 
				 session.setAttribute("success", "Password is changed");
			 }else {
				 session.setAttribute("success", "new & conform password is not matched");
			 }
		}else {
			session.setAttribute("success", "Invalid password");
		}
	}
}
