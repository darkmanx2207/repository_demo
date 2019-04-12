package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.productRepository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUniqueNameValidationRule implements ProductValidationRule {
    private final ProductRepository repository;

    @Autowired
    public ProductUniqueNameValidationRule(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public void validate(ProductDTO productDTO) {
        if (repository.existByName(productDTO.getName())) {
            throw new ValidationException("Product name must be unique.");
        }
    }
}