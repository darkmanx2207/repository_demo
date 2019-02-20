package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) == 1 || product.getDiscount().compareTo(BigDecimal.ZERO) == -1) {
            throw new ValidationException("Discount must be less than 100 and can't be less than 0!!!");
        }
    }

    public void checkNotNull(Product product) {
        if (product.getDiscount() == null) {
            throw new ValidationException("Product discount must be not null!!!");
        }
    }
}