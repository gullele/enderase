package com.enderase.services;

import javax.persistence.EntityManager;

import com.enderase.entities.Owner;

/**
 * Service for owner. Taking care of any activities related to the owner.
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class OwnerService extends Service<Owner> {
	
	/**
	 * Save new owner
	 * @param Owner owner
	 * @return owner;
	 */
	public Owner save(Owner owner) {
		owner = super.save(owner);
		return owner;
	}
	
	/**
	 * Update the given owner object
	 */
	public Owner update(Owner owner) {
		owner = super.update(owner);
		return owner;
	}
	
	public Owner delete(Owner owner) {
		return null;
	}
	
	/**
	 * Get Owner by Id
	 * @param id
	 * @return Owner owner
	 */
	public Owner findById(Long id) {
		Owner owner = null;
		try {
			owner = super.getById(Owner.class, id);
		} catch (Exception ex) {
			throw ex;
		}
		
		return owner;
	}
	
	public Owner findByUsername(String username) {
		Owner owner = null;
		
		try {
			EntityManager entityManager = getDatabase().getEntityManager();
			owner = (Owner)entityManager
				.createQuery("FROM com.enderase.entities.Owner AS owner WHERE owner.username = :username")
				.setParameter("username", username)
				.getSingleResult();
		} catch (Exception ex) {
			throw ex;
		}
		
		return owner;
	}
}
