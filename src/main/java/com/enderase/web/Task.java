package com.enderase.web;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
	@GET
	@Produces("text/html")
	@Path("add/{title}")
	public Response addTask(@PathParam("title") String title) {
		TaskService taskService = new TaskService();
		
		com.enderase.entities.Task task = new com.enderase.entities.Task();
        task.setId(new Long(1));
        task.setTitle(title);
        task.setDescription("This is with modification to the original one");
        task.setDeadLine(new Date());
        task.setOwnerId(1234l);
        task.setDateCreated(new Date());
        task.setDateModified(new Date());
        
        taskService.save(task);
        
		String output = "Performed";
		return Response.status(200).entity(output).build();
	}
}