package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.CartInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.shoppingCartValidation.ShoppingCartValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartService {
    private final CartInMemoryRepository memoryRepository;
    private final ProductService productService;
    private final ShoppingCartValidationService shoppingCartValidationService;

    @Autowired
    public CartService(CartInMemoryRepository memoryRepository, ProductService productService, ShoppingCartValidationService shoppingCartValidationService) {
        this.memoryRepository = memoryRepository;
        this.productService = productService;
        this.shoppingCartValidationService = shoppingCartValidationService;
    }

    public Long createCart(ShoppingCart shoppingCart) {
        shoppingCartValidationService.validate(shoppingCart);
        ShoppingCart createdCart = memoryRepository.create(shoppingCart);
        return createdCart.getId();
    }

    public void addProductInCart(String name, ShoppingCart shoppingCart) {
        Product product = productService.findByName(name);
        shoppingCart.addProduct(product);
    }

    public void showCarts() {
        memoryRepository.showShoppingCart();
    }

    public ShoppingCart findCartByName(String name) {
        return memoryRepository.findByName(name);
    }

    public void getPrice(ShoppingCart shoppingCart) {
        shoppingCart.sumOfAllProducts();
    }

    public void removeCartByName(String name) {
        memoryRepository.removeCartByName(name);
    }
}