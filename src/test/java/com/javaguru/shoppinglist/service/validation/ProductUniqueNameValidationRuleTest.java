package com.javaguru.shoppinglist.service.validation;
/*
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.repository.productRepository.ProductInMemoryRepository;

import org.junit.Test;

import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {
    @Mock
    private ProductInMemoryRepository productInMemoryRepository;
    @InjectMocks
    private ProductUniqueNameValidationRule victim;
    private Product product = product();

    @Test
    public void shouldThrowException() {
        when(productInMemoryRepository.existByName(product.getName()))
                .thenReturn(true);

        assertThatThrownBy(() -> victim.validate(product()))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product name must be unique.");
    }

    private Product product() {
        Product product = new Product();
        product.setName("John");
        product.setDiscount(BigDecimal.valueOf(2));
        product.setDescription("Java guru level 2");
        product.setPrice(BigDecimal.valueOf(20));
        product.setId(1L);
        product.setProductCategory(ProductCategory.MILK);
        return product;
    }
}         */