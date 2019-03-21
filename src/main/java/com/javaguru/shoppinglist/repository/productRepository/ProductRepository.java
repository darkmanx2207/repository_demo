package com.javaguru.shoppinglist.repository.productRepository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.Optional;

public interface ProductRepository {

    Product create(Product product);

    Optional<Product> findBy(Long id);

    boolean existByName(String name);

    Optional<Product> findByName(String name);
}