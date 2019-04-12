package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.validation.ValidationException;

public interface ShoppingCartValidationRule {
    void validate(ShoppingCartDTO shoppingCartDTO);

    default void checkNotNull(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO == null) {
            throw new ValidationException("Shopping cart must be not null.");
        }
    }
}