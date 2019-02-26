package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductInMemoryRepository {

    private Long productIdSequence = 0L;

    public Map<Long, Product> database = new HashMap<>();

    public Product create(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findBy(Long id) {
        return database.get(id);
    }

    public boolean existByName(String name) {
        return database.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }
}