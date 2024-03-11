package com.project.e_wallet.service;

import java.util.List;

import com.project.e_wallet.entity.Category;

public interface CategoryService {
	Category getCategoryById(Long id);
    List<Category> getAllCategories();
    void saveOrUpdateCategory(Category category);
    void deleteCategory(Long id);
}
