package com.enderase.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.enderase.entities.Task;

/**
 * Service for handling task related stuffs
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class TaskService {
	
	/**
	 * Pending spring for injection and DAO implementation
	 */
	private SessionFactory sessionFactory;
	
	public TaskService(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * add new task
	 * @todo - is there a need to have bulk addition?
	 * @param task
	 * @return boolean
	 */
	public boolean addTask(Task task) {
		
        Session session = this.sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(task);
        tx.commit();
		
        return true;
	}
	
	/**
	 * Get specific task by id
	 * @param id
	 * @return
	 */
	public Task getTask(Long id) {
		return null;
	}
	
	/**
	 * Update the given task
	 * @param task
	 * @return
	 */
	public Task update(Task task) {
		return task;
	}
}
