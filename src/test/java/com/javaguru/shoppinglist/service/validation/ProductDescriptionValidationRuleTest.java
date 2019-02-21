package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;

public class ProductDescriptionValidationRuleTest {
    private ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();
    private Product input;

    @Test
    public void shouldThrowValidationException() {
        input = product("qq");

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Description can't be less than 5 and more than 50 letters.");
    }

    @Test
    public void checkNotNull() {
        input = product(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product description must be not null.");
    }

    private Product product(String description) {
        Product product = new Product();
        product.setDescription(description);
        return product;
    }
}