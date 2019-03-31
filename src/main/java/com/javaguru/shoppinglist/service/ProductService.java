package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.productRepository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;


@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    @Transactional
    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.create(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findBy(id);
    }

    Product findByName(String name) {
        return repository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("product not found"));
    }
}