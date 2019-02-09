package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {

    private Map<Long, Product> database = new HashMap<>();
    private Long PRODUCT_ID_SEQUENCE = 0L;


    public Product create(Product product) {
        product.setId(PRODUCT_ID_SEQUENCE);
        database.put(PRODUCT_ID_SEQUENCE, product);
        PRODUCT_ID_SEQUENCE++;
        return product;
    }

    public Product findBy(Long id) {
        return database.get(id);
    }
}
