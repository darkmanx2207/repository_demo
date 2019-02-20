package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class ProductDescriptionValidationRuleTest {
    @Rule
    public final ExpectedException expectedException = ExpectedException.none();
    private ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();
    private Product input1;

    @Test
    public void shouldThrowValidationException() {
        input1 = product("qq");

        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Description can't be less than 5 and more than 50 letters!!!");

        victim.validate(input1);
    }

    @Test
    public void checkNotNull() {
        input1 = product(null);

        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Product description must be not null!!!");

        victim.checkNotNull(input1);
    }

    private Product product(String description) {
        Product product = new Product();
        product.setDescription(description);
        return product;
    }
}