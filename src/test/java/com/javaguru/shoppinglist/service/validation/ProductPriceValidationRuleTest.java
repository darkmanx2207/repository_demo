package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;

import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {
    private ProductPriceValidationRule victim = new ProductPriceValidationRule();
    private Product input;

    @Test
    public void shouldThrowValidationException() {
        input = product(BigDecimal.ZERO);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Price must be more than zero.");
    }

    @Test
    public void shouldThrowDiscountValidationException() {
        input = product(BigDecimal.valueOf(19));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Discount can't be made if price less than 20.");
    }

    @Test
    public void checkNotNull() {
        input = product(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product price must be not null.");
    }

    private Product product(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }
}