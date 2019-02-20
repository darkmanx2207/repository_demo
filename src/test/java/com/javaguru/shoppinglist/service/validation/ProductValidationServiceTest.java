package com.javaguru.shoppinglist.service.validation;

import org.junit.Test;

import static org.junit.Assert.*;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)

public class ProductValidationServiceTest {
    @Mock
    private ProductValidationRule rule;
    @Captor
    private ArgumentCaptor<Product> captor;

    @Test
    public void testValidate() {
        Product product = product();
        rule.validate(product);
        verify(rule).validate(captor.capture());
        Long captorResultById = captor.getValue().getId();
        String captorResultByName = captor.getValue().getName();
        assertEquals(product.getName(), captorResultByName);
        assertEquals(product.getId(), captorResultById);
    }

    private Product product() {
        Product product = new Product();
        product.setName("test");
        product.setDiscount(BigDecimal.valueOf(2));
        product.setDescription("qqqqqq");
        product.setPrice(BigDecimal.valueOf(20));
        product.setId(1L);
        product.setProductCategory(ProductCategory.MILK);
        product.discountPrice();
        return product;
    }
}