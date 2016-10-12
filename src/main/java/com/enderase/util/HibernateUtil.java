package com.enderase.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate utility class to provide the sesion and related stuff.
 * @todo - this would be mostly used in the intiial state of the spring implementation as 
 * almost all the services need database connection object 
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class HibernateUtil {
	
    public SessionFactory getSessionFactory() {
    	//read the config from hibernate.cfg.xml
        SessionFactory sessionFactory;
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        return sessionFactory;
    }
}