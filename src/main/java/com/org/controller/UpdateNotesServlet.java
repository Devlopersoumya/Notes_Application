package com.org.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.NotesDao;
import com.org.dao.UserDao;
import com.org.dto.Notes;
import com.org.dto.User;

@WebServlet("/update")
public class UpdateNotesServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String description = req.getParameter("description");
		int id=Integer.parseInt(req.getParameter("id"));
		
		
		Notes note=new Notes();
		note.setId(id);
		note.setTitle(title);
		note.setDescription(description);
		
		HttpSession session = req.getSession();
		User user = (User)session.getAttribute("userobj");
		
		List<Notes> list=new ArrayList<Notes>();
		list.add(note);		
		user.setNotes(list);
		note.setUser(user);
		
		UserDao dao=new UserDao();
		dao.SaveAndUpdateUser(user);
		
		
		
		session.setAttribute("addnotemsg", "Update Notes Successful");
		resp.sendRedirect("home.jsp");
	}
}
