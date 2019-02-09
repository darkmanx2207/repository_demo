package com.javaguru.shoppinglist.service.validation;

import com.javaguru.shoppinglist.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        checkNotNull(product);
        if (product.getName() == null) {
            throw new ValidationException("Product name must be not null!!!");
        }
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ValidationException("product name must be bigger than 3 and smaller than 32 letters!!!");
        }
    }
}