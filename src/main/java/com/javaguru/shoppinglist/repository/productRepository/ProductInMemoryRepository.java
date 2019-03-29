package com.javaguru.shoppinglist.repository.productRepository;

import com.javaguru.shoppinglist.domain.Product;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@Component
public class ProductInMemoryRepository implements ProductRepository {

    private Long productIdSequence = 0L;

    private Map<Long, Product> database = new HashMap<>();

    public Product create(Product product) {
        product.setId(productIdSequence);
        database.put(productIdSequence, product);
        productIdSequence++;
        return product;
    }

    public Optional<Product> findBy(Long id) {
        return Optional.ofNullable(database.get(id));
    }

    public boolean existByName(String name) {
        return database.values().stream()
                .anyMatch(product -> product.getName().equalsIgnoreCase(name));
    }

    public Optional<Product> findByName(String name) {
        return database.values().stream()
                .filter(product -> product.getName().equals(name))
                .findFirst();
    }
}