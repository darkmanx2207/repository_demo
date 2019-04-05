package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDTO productDTO) {
        if (productDTO.getDescription().length() < 5 || productDTO.getDescription().length() > 50) {
            throw new ValidationException("Description can't be less than 5 and more than 50 letters.");
        }
    }

    public void checkNotNull(ProductDTO productDTO) {
        if (productDTO.getDescription() == null) {
            throw new ValidationException("Product description must be not null.");
        }
    }
}