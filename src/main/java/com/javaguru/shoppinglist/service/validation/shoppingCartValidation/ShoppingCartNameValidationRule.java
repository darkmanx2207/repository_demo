package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.validation.ValidationException;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartNameValidationRule implements ShoppingCartValidationRule {

    @Override
    public void validate(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO.getName().length() < 3 || shoppingCartDTO.getName().length() > 20) {
            throw new ValidationException("cart name must be bigger than 3 and less than 20 letters.");
        }
    }

    @Override
    public void checkNotNull(ShoppingCartDTO shoppingCartDTO) {
        if (shoppingCartDTO.getName() == null) {
            throw new ValidationException("cart name must be not null.");
        }
    }
}