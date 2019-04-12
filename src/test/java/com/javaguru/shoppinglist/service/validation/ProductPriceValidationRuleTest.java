package com.javaguru.shoppinglist.service.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.javaguru.shoppinglist.domain.Product;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductPriceValidationRuleTest {
    private ProductPriceValidationRule victim = new ProductPriceValidationRule();
    private ProductDTO input;

    @Test
    public void shouldThrowValidationException() {
        input = productDTO(BigDecimal.ZERO,BigDecimal.TEN);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Price must be more than zero.");
    }

    @Test
    public void shouldThrowDiscountValidationException() {
        input = productDTO(BigDecimal.TEN,BigDecimal.ONE);

        assertThatThrownBy(() -> victim.validate(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Discount can't be made if price less than 20.");
    }

    @Test
    public void checkNotNull() {
        input = productDTO(null,null);

        assertThatThrownBy(() -> victim.checkNotNull(input))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Product price must be not null.");
    }

    private Product product(BigDecimal price,BigDecimal discount) {
        Product product = new Product();
        product.setPrice(price);
        product.setDiscount(discount);
        return product;
    }
    private ProductDTO productDTO(BigDecimal price,BigDecimal discount) {
        ProductDTO product = new ProductDTO();
        product.setPrice(price);
        product.setDiscount(discount);
        return product;

    }
}