package com.project.application.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.application.entities.Product;
import com.project.application.repo.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> getAllProducts(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page, pageSize);
        return productRepository.findAll(pageRequest);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setCategory(updatedProduct.getCategory());
            // Update other fields as needed

            return productRepository.save(existingProduct);
        } else {
            // Handle the case where the product does not exist
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
