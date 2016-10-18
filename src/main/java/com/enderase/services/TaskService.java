package com.enderase.services;

import java.util.List;

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
		Owner owner = entityManager.find(Owner.class, task.getOwner().getId());
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
		return super.getById(Task.class, id);
	}
	
	/**
	 * Update the given task
	 * @param task
	 * @return
	 */
	public Task update(Task task) {
		//attaching the entity - hibernate is complaining the entity is detached.
		EntityManager em = this.getDatabase().getEntityManager();
		em.getTransaction().begin();
		Task existing = em.find(Task.class, task.getId());
		existing.setTitle(task.getTitle());
		existing.setDescription(task.getDescription());
		existing.setDeadLine(task.getDeadLine());
		em.persist(existing);
		em.getTransaction().commit();
		return existing;
	}
	
	/**
	 * Get all the tasks created by the owner.
	 * @param owner
	 * @return List<Task>
	 */
	@SuppressWarnings("unchecked")
	public List<Task> getAllTasks(Owner owner) {
		List<Task> tasks = null;
		
		try {
			EntityManager em = this.getDatabase().getEntityManager();
			tasks = (List<Task>)em
				.createQuery("FROM com.enderase.entities.Task AS t WHERE t.owner = :owner")
				.setParameter("owner", owner)
				.getResultList();
		} catch (Exception ex) {
			throw ex;
		}
		
		return tasks;
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> getTasksByOwnerStatus(Owner owner, int statusId) {
		List<Task> tasks = null;
		
		try {
			EntityManager em = this.getDatabase().getEntityManager();
			tasks = (List<Task>)em
				.createQuery("FROM com.enderase.entities.Task AS t WHERE t.owner = :owner AND t.status = :status")
				.setParameter("owner", owner)
				.setParameter("status", statusId)
				.getResultList();
		} catch (Exception ex) {
			throw ex;
		}
		
		return tasks;
	}
}
