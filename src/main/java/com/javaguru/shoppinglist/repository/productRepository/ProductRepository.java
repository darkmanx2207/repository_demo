package com.javaguru.shoppinglist.repository.productRepository;

import com.javaguru.shoppinglist.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Long create(Product product);

    Optional<Product> findProductById(Long id);

    Optional<Product> findProductByName(String name);

    boolean existByName(String name);

    List<Product> showAllProducts();

    void delete(Product product);
}