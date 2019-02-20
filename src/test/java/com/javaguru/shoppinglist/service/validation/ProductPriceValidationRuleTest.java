package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductPriceValidationRule victim = new ProductPriceValidationRule();
    private Product input1;
    private Product input2;
    private Product input3;

    @Test
    public void shouldThrowValidationException() {
        input1 = product(BigDecimal.ZERO);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Price must be more than zero!!!");

        victim.validate(input1);
    }

    @Test
    public void shouldThrowDiscountValidationException() {
        input2 = product(BigDecimal.valueOf(19));
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Discount can't be made if price less than 20!!!");

        victim.validate(input2);
    }

    @Test
    public void checkNotNull() {
        input3 = product(null);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Product price must be not null!!!");

        victim.checkNotNull(input3);
    }

    private Product product(BigDecimal price) {
        Product product = new Product();
        product.setPrice(price);
        return product;
    }
}