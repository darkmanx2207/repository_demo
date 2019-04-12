package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {
    private BigDecimal priceNumberValidation = BigDecimal.valueOf(20);

    @Override
    public void validate(ProductDTO productDTO) {

        if (productDTO.getPrice().compareTo(BigDecimal.ZERO) == 0 || productDTO.getPrice().compareTo(BigDecimal.ZERO) == -1) {
            throw new ValidationException("Price must be more than zero.");
        }
        if (productDTO.getPrice().compareTo(priceNumberValidation) == -1 && productDTO.getDiscount().compareTo(BigDecimal.ZERO) == 1) {
            throw new ValidationException("Discount can't be made if price less than 20.");
        }
    }

    public void checkNotNull(ProductDTO productDTO) {
        if (productDTO.getPrice() == null) {
            throw new ValidationException("Product price must be not null.");
        }
    }
}