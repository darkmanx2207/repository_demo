package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.validation.ValidationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShoppingCartNameValidationRuleTest {
    private ShoppingCartNameValidationRule victim = new ShoppingCartNameValidationRule();
    private ShoppingCartDTO input;

    @Test
    public void shouldThrowValidationException() {
        input = shoppingCartDTO("qq");

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("cart name must be bigger than 3 and less than 20 letters.");
    }

    @Test
    public void shouldThrowCartNullException() {
        input = shoppingCartDTO(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("cart name must be not null.");
    }

    private ShoppingCartDTO shoppingCartDTO(String name) {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setName(name);
        return shoppingCartDTO;
    }
}