package com.enderase.services;

import javax.persistence.EntityManager;

import com.enderase.entities.Owner;
import com.enderase.entities.Task;

/**
 * Service for handling task related stuffs
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class TaskService extends Service<Task>{
	
	/**
	 * add new task
	 * @todo - is there a need to have bulk addition?
	 * @param task
	 * @return boolean
	 */
	public Task save(Task task) {
		EntityManager entityManager = super.getDatabase().getEntityManager();
		//to be moved to dao classes
		entityManager.getTransaction().begin();
		Owner owner = entityManager.find(Owner.class, task.getOwnerId().getId());
		task.setOwner(owner);
		entityManager.persist(task);
		entityManager.flush();
		entityManager.getTransaction().commit();
		
		return task;
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
		task = super.update(task);
		return task;
	}
}
