package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductDescriptionValidationRule implements ProductValidationRule {
    @Override
    public void validate(Product product) {
        if (product.getDescription().length() < 5 || product.getDescription().length() > 50) {
            throw new ValidationException("Description can't be less than 5 and more than 50 letters!!!");
        }
    }

    public void checkNotNull(Product product) {
        if (product.getDescription() == null) {
            throw new ValidationException("Product description must be not null!!!");
        }
    }
}