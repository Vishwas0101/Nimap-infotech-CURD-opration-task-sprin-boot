package com.project.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.application.entities.Category;
import com.project.application.repo.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<Category> getAllCategories(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return categoryRepository.findAll(pageRequest);
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }


    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = categoryRepository.findById(id).orElse(null);

        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            // Update other fields as needed

            return categoryRepository.save(existingCategory);
        } else {
            throw new NullPointerException();
        }
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
