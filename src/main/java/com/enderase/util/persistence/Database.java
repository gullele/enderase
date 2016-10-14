package com.enderase.util.persistence;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.enderase.util.HibernateUtil;

/**
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 *
 */
public class Database<T> {
	
	/**
	 * Insert the given entity
	 * @param t
	 * @return
	 */
	public T save(T t) {
		EntityManager entityManager = this.getEntityManager();
		
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
		
		return t;
	}
	
	/**
	 * Update the given entity
	 * @param t
	 * @return
	 */
	public T update(T t) {
		EntityManager entityManager = this.getEntityManager();
		
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
		
		return t;		
	}
	
	public T getById(T t, Long id) {
		EntityManager entityManager = this.getEntityManager();
		@SuppressWarnings("unchecked")
		T entity = (T)entityManager.find(t.getClass(), id);
		return entity;
	}
	
	/**
	 * Get the session factory
	 * @return SessionFactory
	 */
	public EntityManager getEntityManager() {
		return HibernateUtil.getEntityManager();
	}
}
