package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;

public interface ProductValidationRule {
    void validate(ProductDTO productDTO);

    default void checkNotNull(ProductDTO productDTO) {
        if (productDTO == null) {
            throw new ValidationException("Product must be not null!!!");
        }
    }
}