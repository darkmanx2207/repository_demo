package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;

import java.math.BigDecimal;

public class ProductDiscountValidationRuleTest {
    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();
    private Product input;

    @Test
    public void shouldThrowValidationException() {
        input = product(BigDecimal.valueOf(111));

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Discount must be less than 100 and can't be less than 0.");
    }

    @Test
    public void shouldThrowDiscountValidationException() {
        input = product(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product discount must be not null.");
    }

    private Product product(BigDecimal discount) {
        Product product = new Product();
        product.setDiscount(discount);
        return product;
    }
}