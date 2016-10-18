package com.enderase.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * This is the default entry point for the API implementation. It would be used to give some
 * basic information on how the API works and probably some more static pages on how to contact 
 * nothing much with UI stuff here.
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 *
 */
@Path("/")
public class Home
{
	@GET
	@Produces("text/html")
	public Response getStartingPage()
	{
		String output = "<h1>Welcome to Enderase API - http://api.enderase.com<h1>" +
				"<center><p>More can be found at https://github.com/gullele/enderase</p></center>";
		return Response.status(200).entity(output).build();
	}
}