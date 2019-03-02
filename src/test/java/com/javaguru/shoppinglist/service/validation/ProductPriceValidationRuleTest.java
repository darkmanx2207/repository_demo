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
        input = productPriceZero(BigDecimal.valueOf(0));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Price must be more than zero.");
    }

    @Test
    public void shouldThrowDiscountValidationException() {
        input = product();

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Discount can't be made if price less than 20.");
    }

    @Test
    public void checkNotNull() {
        input = productPriceZero(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product price must be not null.");
    }

    private Product product() {
        Product product = new Product();
        product.setDiscount(BigDecimal.valueOf(5));
        product.setPrice(BigDecimal.valueOf(15));
        return product;
    }

    private Product productPriceZero(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }
}