package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.ProductCategory;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.repository.productRepository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductUniqueNameValidationRuleTest {
    @Mock
    private ProductRepository hibernateProductRepository;

    @Spy
    @InjectMocks
    private ProductUniqueNameValidationRule victim;

    private ProductDTO productDTO = productDTO();

    @Test
    public void shouldThrowException() {
        when(hibernateProductRepository.existByName(productDTO.getName()))
                .thenReturn(true);

        assertThatThrownBy(() -> victim.validate(productDTO))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product name must be unique.");
    }

    @Test
    public void shouldValidateSuccess() {
        when(hibernateProductRepository.existByName(productDTO.getName()))
                .thenReturn(false);

        victim.validate(productDTO);
    }

    private ProductDTO productDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("John");
        productDTO.setDiscount(BigDecimal.valueOf(2));
        productDTO.setDescription("Java guru level 2");
        productDTO.setPrice(BigDecimal.valueOf(20));
        productDTO.setId(1L);
        productDTO.setProductCategory(ProductCategory.MILK);
        return productDTO;
    }
}