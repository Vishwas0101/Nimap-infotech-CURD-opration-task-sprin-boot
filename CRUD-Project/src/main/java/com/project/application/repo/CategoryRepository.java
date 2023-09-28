package com.project.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.application.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
