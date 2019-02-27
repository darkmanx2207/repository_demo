package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.repository.CartMemoryRepository;

import java.math.BigDecimal;

public class CartService {
    private final CartMemoryRepository repository;

    public CartService(CartMemoryRepository repository) {
        this.repository = repository;
    }

    public String createCart(String name) {
        return repository.createCart(name);
    }

    public void getCart() {
        repository.getCart();
    }

    public String removeProductByName(String name) {
        return repository.removeProductByName(name);
    }

    public BigDecimal sumOfCartPrices() {
        return repository.sumOfCartPrices();
    }
}