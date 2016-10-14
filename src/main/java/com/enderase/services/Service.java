package com.enderase.services;

import com.enderase.util.persistence.Database;

/**
 * Generic abstract class that would act on inheriting class.
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public abstract class Service<T> {
	
	/**
	 * Delegate the task of saving to the underlying database
	 * @param t
	 * @return
	 */
	protected T save(T t) {
		if (t == null) {
			//log?
			return null;
		}
		this.getDatabase().save(t);
		return t;
	}
	
	/**
	 * Delegate the task of updating to the underlying database
	 * @param t
	 * @return
	 */
	protected T update(T t) {
		if (t == null) {
			//log ??
			return null;
		}
		this.getDatabase().update(t);
		return t;
	}
	
	protected T getById(Long id) {
		T t = null;
		return this.getDatabase().getById(t, id);
	}
	
	/**
	 * Get the database;
	 * @return
	 */
	protected Database<T> getDatabase() {
		return new Database<T>();
	}
}
