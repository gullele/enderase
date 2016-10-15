package com.enderase.web;

import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.enderase.entities.Owner;
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
public class Task {
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("add/{ownerId}")
	public com.enderase.entities.Task add(@PathParam("ownerId") String ownerId,
			com.enderase.entities.Task task) {
		
		Long ownerIdentifier = Long.parseLong(ownerId);
		OwnerService ownerService = new OwnerService();
		Owner owner = ownerService.findById(ownerIdentifier);//try catch
		
		if (owner instanceof Owner) {
			
			task.setDeadLine(new Date());
			task.setOwner(owner);
			task.setDateCreated(new Date());
			task.setDateModified(new Date());

			TaskService taskService = new TaskService();
			taskService.save(task);
		}
		
		return task;	
	}
}