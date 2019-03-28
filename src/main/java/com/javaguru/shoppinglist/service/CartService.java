package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.cartRepository.CartRepository;
import com.javaguru.shoppinglist.service.validation.shoppingCartValidation.ShoppingCartValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ShoppingCartValidationService shoppingCartValidationService;

    @Autowired
    public CartService(CartRepository cartRepository, ProductService productService, ShoppingCartValidationService shoppingCartValidationService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.shoppingCartValidationService = shoppingCartValidationService;
    }

    public Long createCart(ShoppingCart shoppingCart) {
        shoppingCartValidationService.validate(shoppingCart);
        ShoppingCart createdCart = cartRepository.create(shoppingCart);
        return createdCart.getId();
    }

    public void addProductInCart(String name, ShoppingCart shoppingCart) {
        Product product = productService.findByName(name);
        shoppingCart.addProduct(product);
    }

    public void showCarts() {
        cartRepository.showShoppingCart();
    }

    public ShoppingCart findCartByName(String name) {
        return cartRepository.findByName(name);
    }

    public void getPrice(ShoppingCart shoppingCart) {
        BigDecimal count = BigDecimal.ZERO;
        for (Product list : shoppingCart.sumOfAllProducts()) {
            count = count.add(list.getActualPrice());
        }
        System.out.println("sum of all products cost is " + count);
    }

    public void removeCartByName(String name) {
        cartRepository.removeCartByName(name);
    }
}