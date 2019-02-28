package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {
    private BigDecimal priceNumberValidation = BigDecimal.valueOf(20);

    @Override
    public void validate(Product product) {

        if (product.getPrice().compareTo(BigDecimal.ZERO) == 0 || product.getPrice().compareTo(BigDecimal.ZERO) == -1) {
            throw new ValidationException("Price must be more than zero.");
        }
        if (product.getPrice().compareTo(priceNumberValidation) == -1 && product.getDiscount().compareTo(BigDecimal.ZERO) == 1) {
            throw new ValidationException("Discount can't be made if price less than 20.");
        }
    }

    public void checkNotNull(Product product) {
        if (product.getPrice() == null) {
            throw new ValidationException("Product price must be not null.");
        }
    }
}