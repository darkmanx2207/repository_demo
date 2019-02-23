package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductInMemoryRepository {

    private Long productIdSequence = 0L;

    public static Map<Long, Product> database = new HashMap<>();

    public Map<Long,Product> getDatabase(){
        return database;
    }
    public void setDatabase(Map<Long,Product> database){
        this.database = database;
    }

    public Product create(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Product findBy(Long id) {
        return database.get(id);
    }
    public boolean existByName(String name){
        return database.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

}