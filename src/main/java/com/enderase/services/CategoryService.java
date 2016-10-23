package com.enderase.services;

import com.enderase.entities.Category;

/**
 * Service for category. Taking care of any activities related to the category.
 * 
 * @author Kaleb Woldearegay <kaleb@gullele.com>
 */
public class CategoryService extends Service<Category> {
	
	/**
	 * Save new category
	 * @param Category category
	 * @return category
	 */
	public Category save(Category category) {
		category = super.save(category);
		return category;
	}
	
	/**
	 * Update the given owner object
	 */
	public Category update(Category category) {
		category = super.update(category);
		return category;
	}
	
	public Category delete(Category category) {
		return null;
	}
	
	/**
	 * Get Category by Id
	 * @param id
	 * @return Category category
	 */
	public Category findById(Long id) {
		Category category = null;
		try {
			category = super.getById(Category.class, id);
		} catch (Exception ex) {
			throw ex;
		}
		
		return category;
	}
}
