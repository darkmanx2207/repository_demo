package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.service.validation.ValidationException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CartMemoryRepository {
    private final ProductInMemoryRepository memoryRepository;

    private Long productIdSequence = 0L;

    public Map<Long, Product> cartbase = new HashMap<>();

    public CartMemoryRepository(ProductInMemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;
    }

    public String findProductByName(String name) {
        for (Product list : memoryRepository.database.values()) {
            if (list.getName().equals(name)) {
                cartbase.put(productIdSequence++, list);
            } else {
                throw new ValidationException("Incorretly introduced product.");
            }
        }
        if (memoryRepository.database.isEmpty()) {
            throw new ValidationException("incorrectly introduced product.");
        }

        return name;
    }

    public void getCart() {
        System.out.println(cartbase.entrySet());
    }

    public Product removeProductByName(Long id) {
        for (Product list : memoryRepository.database.values()) {
            if (list.getId().equals(id)) {
                cartbase.remove(list);
            } else {
                throw new ValidationException("Incorretly introduced id.");
            }
        }
        if (memoryRepository.database.isEmpty()) {
            throw new ValidationException("Incorretly introduced id.");
        }
        return cartbase.remove(id);
    }

    public BigDecimal sumOfCartPrices() {
        BigDecimal price = BigDecimal.ZERO;
        for (Product list : memoryRepository.database.values()) {
            price = price.add(list.getActualPrice());
        }
        return price;
    }
}