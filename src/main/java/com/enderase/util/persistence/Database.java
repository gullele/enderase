package com.enderase.util.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Session session = this.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
		
		return t;
	}
	
	/**
	 * Update the given entity
	 * @param t
	 * @return
	 */
	public T update(T t) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(t);
        tx.commit();
		
		return t;		
	}
	
	/**
	 * Get the session factory
	 * @return SessionFactory
	 */
	private SessionFactory getSessionFactory() {
		return HibernateUtil.getSessionFactory();
	}
}
