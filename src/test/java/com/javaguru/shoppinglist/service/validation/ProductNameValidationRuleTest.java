package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {
    @Rule
    public final ExpectedException expectedException =  ExpectedException.none();
    private ProductNameValidationRule victim = new ProductNameValidationRule();
    private Product input1;
    private Product input2;

    @Test
    public void shouldThrowValidationException() {
        input1 = product("dd");

        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("product name must be bigger than 3 and smaller than 32 letters!!!");

        victim.validate(input1);
    }

    @Test
    public void shouldThrowProductNullException() {
        input2 = product(null);

        expectedException.expect(ValidationException.class);
        expectedException.expectMessage("Product name must be not null!!!");

        victim.checkNotNull(input2);
    }
    private Product product(String name){
        Product product = new Product();
        product.setName(name);
        return product;
    }
}