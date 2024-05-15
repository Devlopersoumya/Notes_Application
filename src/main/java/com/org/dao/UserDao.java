package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {

	public void SaveAndUpdateUser(User user) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(user);
		et.commit();
	}
	public User FetchUserById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		
		User user = em.find(User.class, id);
		
		return user;
	}
	
	public User FetchAllUser() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(null);
		EntityManager em = emf.createEntityManager();
		Query query = em.createNamedQuery("select s from User s");
		List<User> list = query.getResultList();
		
		
		return null;
	}
}
