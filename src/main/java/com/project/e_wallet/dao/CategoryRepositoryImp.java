package com.project.e_wallet.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.e_wallet.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CategoryRepositoryImp implements CategoryRepository{
	
	@Autowired
	private EntityManager entityManager;
	
	 @Override
	 @Transactional
	    public Category getCategoryById(Long id) {
	        return entityManager.find(Category.class, id);
	    }

	    @Override
	    @Transactional
	    public List<Category> getAllCategories() {
	        return entityManager.createQuery("SELECT c FROM Category c", Category.class).getResultList();
	    }

	    @Override
	    @Transactional
	    public void saveOrUpdateCategory(Category category) {
	        if (category.getId() == null) {
	            entityManager.persist(category);
	        } else {
	            entityManager.merge(category);
	        }
	    }

	    @Override
	    @Transactional
	    public void deleteCategory(Long id) {
	        Category category = entityManager.find(Category.class, id);
	        if (category != null) {
	            entityManager.remove(category);
	        }
	    }
	
}
