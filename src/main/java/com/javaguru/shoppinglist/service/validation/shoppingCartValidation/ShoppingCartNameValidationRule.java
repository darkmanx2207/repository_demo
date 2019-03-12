package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartNameValidationRule implements ShoppingCartValidationRule {

    @Override
    public void validate(ShoppingCart shoppingCart) {
        if (shoppingCart.getName().length() < 3 || shoppingCart.getName().length() > 20) {
            throw new ValidationException("cart name must be bigger than 3 and less than 20 letters.");
        }
    }

    @Override
    public void checkNotNull(ShoppingCart shoppingCart) {
        if (shoppingCart.getName() == null) {
            throw new ValidationException("cart name must be not null.");
        }
    }
}