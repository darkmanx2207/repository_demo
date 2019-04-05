package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.junit.Test;

public class ProductNameValidationRuleTest {
    private ProductNameValidationRule victim = new ProductNameValidationRule();
    private ProductDTO input;

    @Test
    public void shouldThrowValidationException() {
        input = productDTO("dd");

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("product name must be bigger than 3 and smaller than 32 letters.");
    }

    @Test
    public void shouldThrowProductNullException() {
        input = productDTO(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product name must be not null.");
    }

    private ProductDTO productDTO(String name) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName(name);
        return productDTO;
    }
}