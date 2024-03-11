package com.project.e_wallet.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.e_wallet.entity.Category;
import com.project.e_wallet.service.CategoryService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/categories")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/{id}")
	@Transactional
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    @Transactional
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping("/save")
    @Transactional
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveOrUpdateCategory(category);
    }

    @PutMapping("/update")
    @Transactional
    public void updateCategory(@RequestBody Category category) {
        categoryService.saveOrUpdateCategory(category);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}
