package com.kylin.jpa.helloworld.service;

import java.util.List;

import javax.ejb.Stateful;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.kylin.jpa.helloworld.po.User;

@Stateful
@Alternative
public class UserDaoSession implements UserDao {

   @Inject
   private EntityManager em;

   public User getForUsername(String username) {
      try {
         Query query = em.createQuery("select u from User u where u.username = ?");
         query.setParameter(1, username);
         return (User) query.getSingleResult();
      } catch (NoResultException e) {
         return null;
      }
   }

	public void createUser(User user) {
		EntityTransaction ts = em.getTransaction();
		ts.begin();
		em.persist(user);
		ts.commit();
	}

	@Override
	public List<User> getUsers() {
		try {
			Query query = em.createQuery("from User");
            return query.getResultList();
	      } catch (NoResultException e) {
	         return null;
	      }
	}

}

















