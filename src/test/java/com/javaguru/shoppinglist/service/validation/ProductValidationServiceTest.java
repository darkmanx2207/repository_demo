package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;

import static org.mockito.Mockito.verify;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)

public class ProductValidationServiceTest {
    @Mock
    private ProductUniqueNameValidationRule productUniqueNameValidationRule;
    @Mock
    private ProductDescriptionValidationRule productDescriptionValidationRule;
    @Mock
    private ProductDiscountValidationRule productDiscountValidationRule;
    @Mock
    private ProductNameValidationRule productNameValidationRule;
    @Mock
    private ProductPriceValidationRule productPriceValidationRule;
    @Captor
    private ArgumentCaptor<Product> captor;

    private ProductValidationService victim;
    private Product input = product();

    @Before
    public void setUp() {
        Set<ProductValidationRule> rules = new HashSet<>();
        rules.add(productDescriptionValidationRule);
        rules.add(productDiscountValidationRule);
        rules.add(productNameValidationRule);
        rules.add(productPriceValidationRule);
        rules.add(productUniqueNameValidationRule);

        victim = new ProductValidationService(rules);
    }


    @Test
    public void shouldValidate() {
        victim.validate(input);

        verify(productDescriptionValidationRule).validate(captor.capture());
        verify(productDiscountValidationRule).validate(captor.capture());
        verify(productNameValidationRule).validate(captor.capture());
        verify(productPriceValidationRule).validate(captor.capture());
        verify(productUniqueNameValidationRule).validate(captor.capture());

        List<Product> resultList = captor.getAllValues();
        assertThat(resultList).containsOnly(input);
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
}