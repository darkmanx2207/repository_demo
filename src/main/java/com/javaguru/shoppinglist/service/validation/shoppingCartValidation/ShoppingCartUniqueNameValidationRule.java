package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.cartRepository.CartRepository;
import com.javaguru.shoppinglist.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartUniqueNameValidationRule implements ShoppingCartValidationRule {
    private final CartRepository cartRepository;

    @Autowired
    public ShoppingCartUniqueNameValidationRule(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @Override
    public void validate(ShoppingCart shoppingCart) {
        if (cartRepository.existByName(shoppingCart.getName())) {
            throw new ValidationException("Shopping cart must be unique.");
        }
    }
}