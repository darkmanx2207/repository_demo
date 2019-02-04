package com.javaguru.shoppinglist;

import java.math.BigDecimal;

public class ProductValidationService {
    public void checkTest(Product product) {
        if (product.getName().length() < 3 || product.getName().length() > 32) {
            throw new ValidationException("Name can't be less than 3 and more than 32 letters!!!");
        }
        if (product.getDiscount().compareTo(BigDecimal.valueOf(100)) == 1) {
            throw new ValidationException("Discount can't be more than 100!!!");
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) == 0) {
            throw new ValidationException("Price can't be zero!!!");
        }
        if (product.getDescription().length() < 5 || product.getDescription().length() > 50) {
            throw new ValidationException("Description can't be less than 5 and more than 50!!!");
        }

    }

}


