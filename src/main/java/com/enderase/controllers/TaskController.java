package com.enderase.controllers;

import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.enderase.entities.Category;
import com.enderase.entities.Owner;
import com.enderase.entities.Task;
import com.enderase.services.OwnerService;
import com.enderase.services.TaskService;

/**
 * End point for task related queries like adding, updating, deleting, finding tasks by specific category
 * and anything that would be towards task
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 *
 */
@Path("/task")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskController {
	
	private TaskService taskService;
	private OwnerService ownerService;
	
	/**
	 * Saves new task.
	 * Example of the payload with post http method looks
	 * {"title":"Pay tuition fee for family member", "description":"I need college tuition fee to be taken care of ", 
	 * "category":{"id":"1"}, "deadLine":"10-29-2016 00:00:00"}
	 * @param ownerUsername
	 * @param task
	 * @return
	 */
	@POST
	@Path("{ownerUsername}")
	public Task add(@PathParam("ownerUsername") String ownerUsername, Task task) {
		/*
		 * Category would be passed to the controller as part of the json payload 
		 */
		Category category = task.getCategory();
		
		if (!ownerUsername.isEmpty() && category != null) {
			Owner owner = new Owner();
			owner.setUsername(ownerUsername);
			task.setDeadLine(new Date());
			task.setOwner(owner);
			task.setDateCreated(new Date());
			task.setDateModified(new Date());
			task.setStatus(1);

			getTaskService().save(task);
		}
		
		return task;	
	}
	
	@GET
	@Path("{ownerUsername}")
	public List<Task> getTasksByOwner(@PathParam("ownerUsername") String ownerUsername) {
		List<Task> tasks = null;
		if (!ownerUsername.isEmpty()) {
			
			Owner owner = getOwnerService().findByUsername(ownerUsername);//try catch
			
			if (owner instanceof Owner) {
				tasks = getTaskService().getAllTasks(owner);
			}
			
		}
		
		return tasks;
	}
	
	@PUT
	@Path("{ownerUsername}")
	public Task update(@PathParam("ownerUsername") String ownerUsername, Task task) {//validation to be on going
		if (!ownerUsername.isEmpty()) {
			Owner owner = getOwnerService().findByUsername(ownerUsername);
			Task existingTask = getTaskService().getTask(task.getId());
			if (owner instanceof Owner && existingTask.getOwner().getId() == owner.getId()) { //validate task
				task = getTaskService().update(task);
			}
		}
		return task;
	}
	
	@DELETE
	@Path("{ownerUsername}")
	public boolean delete(@PathParam("ownerUsername") String ownerUsername, Task task) {
		return true;
	}
	
	@GET
	@Path("/{ownerUsername}/{statusId}")
	public List<Task> getByStatus(@PathParam("ownerUsername") String ownerUsername, 
			@PathParam("statusId") int statusId) {
		List<Task> tasks = null;
		if (!ownerUsername.isEmpty() && statusId > 0) {
			Owner owner = getOwnerService().findByUsername(ownerUsername);
			tasks = getTaskService().getTasksByOwnerStatus(owner, statusId);
		}
		
		return tasks;
	}
	
	/**
	 * get task service.
	 * @return TaskService
	 */
	private TaskService getTaskService() {
		if (this.taskService == null) {
			this.taskService = new TaskService();
		}
		return this.taskService;
	}
	
	private OwnerService getOwnerService() {
		if (this.ownerService == null) {
			this.ownerService = new OwnerService();
		}
		return this.ownerService;
	}
}