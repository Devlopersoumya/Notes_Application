package com.org.dao;
 
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Notes;
import com.org.dto.User;

public class NotesDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sonu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Notes fetchNotesById(int id) {
		
		Notes note=em.find(Notes.class,id);
		return note;
	}
	
	
	public void deleteById(int id) {
		
		Notes note = em.find(Notes.class,id);
		
		User user = note.getUser();
		
		List<Notes> list = user.getNotes();
		
		  for(Notes n:list) {
			  if(n.getId()==id) {
				  list.remove(n);
				  break;
			  }
		  }
		
		et.begin();
		em.merge(user);
		em.remove(note);
		et.commit();
	}
}
