package com.org.dao;
 
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.org.dto.Notes;

public class NotesDao {

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sonu");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public Notes fetchNotesById(int id) {
		
		Notes note=em.find(Notes.class,id);
		return note;
	}
	public void updateNotesById(Notes notes) {
		
		
		et.begin();
		em.merge(notes);
		et.commit();
	}
	
	public void deleteById(int id) {
		
		Notes note = em.find(Notes.class,id);
		
		et.begin();
		em.remove(note);
		et.commit();
	}
}
