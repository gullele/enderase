package com.enderase.controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.enderase.entities.Owner;

/**
 * 
 * Service for owner class. Handling CRUD and other methods
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
@Path("owner")
public class OwnerController {

	@Path("{ownerUsername}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Owner getById(@PathParam("ownerUsername") String ownerUsername, Owner owner) {
		return owner;
	}
}
