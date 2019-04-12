package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.junit.Test;

public class ProductDescriptionValidationRuleTest {
    private ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();
    private ProductDTO input;

    @Test
    public void shouldThrowValidationException() {
        input = productDTO("qq");

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Description can't be less than 5 and more than 50 letters.");
    }

    @Test
    public void checkNotNull() {
        input = productDTO(null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product description must be not null.");
    }

    private ProductDTO productDTO(String description) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription(description);
        return productDTO;
    }
}