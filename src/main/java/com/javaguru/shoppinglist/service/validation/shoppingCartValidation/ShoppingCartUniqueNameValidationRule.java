package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.CartInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartUniqueNameValidationRule implements ShoppingCartValidationRule {
    private final CartInMemoryRepository cartInMemoryRepository;

    @Autowired
    public ShoppingCartUniqueNameValidationRule(CartInMemoryRepository cartInMemoryRepository) {
        this.cartInMemoryRepository = cartInMemoryRepository;
    }

    @Override
    public void validate(ShoppingCart shoppingCart) {
        if (cartInMemoryRepository.existByName(shoppingCart.getName())) {
            throw new ValidationException("Shopping cart must be unique.");
        }
    }
}