package com.project.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.application.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
