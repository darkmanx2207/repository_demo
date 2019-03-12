package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.validation.ValidationException;

public interface ShoppingCartValidationRule {
    void validate(ShoppingCart shoppingCart);

    default void checkNotNull(ShoppingCart shoppingCart) {
        if (shoppingCart == null) {
            throw new ValidationException("Shopping cart must be not null.");
        }
    }
}