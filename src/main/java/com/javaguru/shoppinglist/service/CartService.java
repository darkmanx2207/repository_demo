package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CartMemoryRepository;

import java.math.BigDecimal;

public class CartService {
    private final CartMemoryRepository repository;

    public CartService(CartMemoryRepository repository) {
        this.repository = repository;
    }

    public String findProductByName(String name) {
        return repository.findProductByName(name);
    }

    public void getCart() {
        repository.getCart();
    }

    public Product removeProductByName(Long id) {
        return repository.removeProductByName(id);
    }

    public BigDecimal sumOfCartPrices() {
        return repository.sumOfCartPrices();
    }
}