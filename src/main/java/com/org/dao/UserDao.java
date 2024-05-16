package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
        
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("sonu");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
	public void SaveAndUpdateUser(User user) {
		et.begin();
		em.merge(user);
		et.commit();
	}
	public User FetchUserById(int id) {

		return  em.find(User.class, id);
	
	}
	
	public User FetchAllUser() {
		
		Query query = em.createNamedQuery("select s from User s");
		List<User> list = query.getResultList();
	
		return null;
	}
	public User fetchUserByEmailAndPassword(String email,String pwd) {
		Query query = em.createQuery("select s from User s where s.Email=?1 and s.Password=?2");
		query.setParameter(1, email);
		query.setParameter(2, pwd);
		
		List<User> list = query.getResultList();
		if(list.isEmpty()) {
			return null;
		}else {
			return list.get(0);
		}
	}
}
