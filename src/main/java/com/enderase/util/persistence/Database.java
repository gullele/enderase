package com.enderase.util.persistence;

import javax.persistence.EntityManager;

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
        entityManager.flush();
        entityManager.getTransaction().commit();
		
		return t;		
	}
	
	public T getById(Class<T> c, Long id) {
		EntityManager entityManager = this.getEntityManager();
		T entity = (T)entityManager.find(c, id);
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
