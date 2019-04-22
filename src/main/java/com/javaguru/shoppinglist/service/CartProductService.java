package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCartProduct;
import com.javaguru.shoppinglist.repository.cartProductRepository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartProductService {

    private final CartProductRepository repository;

    @Autowired
    public CartProductService(CartProductRepository repository) {
        this.repository = repository;
    }

    public Long save(ShoppingCartProduct shoppingCartProduct) {
        return repository.save(shoppingCartProduct);
    }

    public List<ShoppingCartProduct> showAllCartProducts() {
        return repository.showAllCartProducts().stream()
                .collect(Collectors.toList());
    }
}