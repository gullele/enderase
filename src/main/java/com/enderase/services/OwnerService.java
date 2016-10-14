package com.enderase.services;

import java.util.List;

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
	
	/**
	 * Get Owner by Id
	 * @param id
	 * @return Owner owner
	 */
	public Owner findById(Long id) {
		Owner owner = super.getById(id);
		return owner;
	}
	
	/**
	 * Get the owners if they are active or not 0 = inactive and 1 active
	 * @param active
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Owner> getByActiveness(int active) {
		List<Owner> owners = null;
		
		try {
			EntityManager em = this.getDatabase().getEntityManager();		
			owners = (List<Owner>)em
					.createQuery("SELECT t FROM TABLE t WHERE t.active = :active")
					.setParameter("active", active)
					.getResultList();
		} catch (Exception ex) {
			throw ex;
		}
		
		return owners;
	}
}
