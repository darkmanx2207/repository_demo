package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;

public class ProductNameValidationRuleTest {
    private ProductNameValidationRule victim = new ProductNameValidationRule();
    private Product input;

    @Test
    public void shouldThrowValidationException() {
        input = product("dd");

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("product name must be bigger than 3 and smaller than 32 letters.");
    }

    @Test
    public void shouldThrowProductNullException() {
        input = product(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product name must be not null.");
    }

    private Product product(String name) {
        Product product = new Product();
        product.setName(name);
        return product;
    }
}