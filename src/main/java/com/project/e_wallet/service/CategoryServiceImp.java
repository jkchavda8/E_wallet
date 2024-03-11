package com.project.e_wallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.e_wallet.dao.CategoryRepository;
import com.project.e_wallet.entity.Category;

import jakarta.transaction.Transactional;

@Service
public class CategoryServiceImp implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
    public Category getCategoryById(Long id) {
        return categoryRepository.getCategoryById(id);
    }

    @Override
    @Transactional
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    @Transactional
    public void saveOrUpdateCategory(Category category) {
        categoryRepository.saveOrUpdateCategory(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Long id) {
        categoryRepository.deleteCategory(id);
    }
}
