package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(ProductDTO productDTO) {
        if (productDTO.getName().length() < 3 || productDTO.getName().length() > 32) {
            throw new ValidationException("product name must be bigger than 3 and smaller than 32 letters.");
        }
    }

    public void checkNotNull(ProductDTO productDTO) {
        if (productDTO.getName() == null) {
            throw new ValidationException("Product name must be not null.");
        }
    }
}