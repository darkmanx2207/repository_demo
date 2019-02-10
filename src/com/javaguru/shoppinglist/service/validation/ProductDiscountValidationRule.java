package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDiscount() == null) {
            throw new ValidationException("Discount must be not null!!!");
        }
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) == 1) {
            throw new ValidationException("Discount must be less than 100!!!");
        }
    }

    public void checkNotNull(Product product) {
        if (product.getDiscount() == null) {
            throw new ValidationException("Product name must be not null!!!");
        }
    }
}