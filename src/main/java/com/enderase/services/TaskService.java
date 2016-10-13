package com.enderase.services;

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
		task = super.save(task);
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
