package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(ProductDTO productDTO) {
        if (productDTO.getDiscount().compareTo(BigDecimal.valueOf(100)) == 1 || productDTO.getDiscount().compareTo(BigDecimal.ZERO) == -1) {
            throw new ValidationException("Discount must be less than 100 and can't be less than 0.");
        }
    }

    public void checkNotNull(ProductDTO productDTO) {
        if (productDTO.getDiscount() == null) {
            throw new ValidationException("Product discount must be not null.");
        }
    }
}