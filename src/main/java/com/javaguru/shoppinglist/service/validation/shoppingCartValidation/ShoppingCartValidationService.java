package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ShoppingCartValidationService {

    private final Set<ShoppingCartValidationRule> cartValidationRules;

    @Autowired
    public ShoppingCartValidationService(Set<ShoppingCartValidationRule> cartValidationRules) {
        this.cartValidationRules = cartValidationRules;
    }

    public void validate(ShoppingCartDTO shoppingCartDTO) {
        cartValidationRules.forEach(s -> s.validate(shoppingCartDTO));
    }
}