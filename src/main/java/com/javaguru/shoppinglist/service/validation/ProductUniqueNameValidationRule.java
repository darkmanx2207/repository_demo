package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.ProductInMemoryRepository;

public class ProductUniqueNameValidationRule implements ProductValidationRule {
    private final ProductInMemoryRepository repository;

    public ProductUniqueNameValidationRule(ProductInMemoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(Product product) {
        if (repository.existByName(product.getName())) {
            throw new ValidationException("Product name must be unique.");
        }
    }
}