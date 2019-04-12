package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules;


    public ProductValidationService(Set<ProductValidationRule> validationRules) {
        this.validationRules = validationRules;
    }

    public void validate(ProductDTO productDTO) {
        validationRules.forEach(s -> s.validate(productDTO));
    }
}