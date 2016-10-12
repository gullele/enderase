package com.enderase.web;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.hibernate.SessionFactory;

import com.enderase.services.TaskService;
import com.enderase.util.HibernateUtil;

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
	public Response getTasks() {
		HibernateUtil hibernateUtil = new HibernateUtil();
		SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
		TaskService taskService = new TaskService(sessionFactory);
		
		com.enderase.entities.Task task = new com.enderase.entities.Task();
        task.setId(new Long(1));
        task.setTitle("Test task two");
        task.setDescription("This is with modification to the original one");
        task.setDeadLine(new Date());
        task.setDateCreated(new Date());
        task.setDateModified(new Date());
        
        taskService.addTask(task);
        
		String output = "Performed";
		return Response.status(200).entity(output).build();
	}
}