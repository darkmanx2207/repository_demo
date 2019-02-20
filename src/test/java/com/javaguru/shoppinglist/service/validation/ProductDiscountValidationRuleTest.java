package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import java.math.BigDecimal;

public class ProductDiscountValidationRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDiscountValidationRule victim = new ProductDiscountValidationRule();

    private Product input1;
    private Product input2;

    @Test
    public void shouldThrowValidationException() {
        input1 = product(BigDecimal.valueOf(111));
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Discount must be less than 100 and can't be less than 0!!!");

        victim.validate(input1);
    }

    @Test
    public void shouldThrowDiscountValidationException() {
        input2 = product(null);
        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Product discount must be not null!!!");

        victim.checkNotNull(input2);
    }
    private Product product(BigDecimal discount){
        Product product = new Product();
        product.setDiscount(discount);
        return product;

    }
}