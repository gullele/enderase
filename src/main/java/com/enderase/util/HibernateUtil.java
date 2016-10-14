
package com.enderase.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;

/**
 * Hibernate utility class to provide the sesion and related stuff.
 * @todo - this would be mostly used in the intiial state of the spring implementation as 
 * almost all the services need database connection object 
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class HibernateUtil {
	
	/**
	 * Create a static class instance of the entityManagerFactory.
	 */
	private static final EntityManagerFactory entityManagerFactory;
	
	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("enderase-JPA");
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	/**
	 * Get entityManager from the entityManagerFactory
	 * @return Session
	 */
    public static EntityManager getEntityManager() throws HibernateException{
        return entityManagerFactory.createEntityManager();
    }
}