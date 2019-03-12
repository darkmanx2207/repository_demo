package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CartInMemoryRepository {

    private List<ShoppingCart> cart = new ArrayList<>();

    private Long cartId = 1L;

    public ShoppingCart create(ShoppingCart shoppingCart) {
        shoppingCart.setId(cartId);
        cart.add(shoppingCart);
        cartId++;
        return shoppingCart;
    }

    public void showShoppingCart() {
        System.out.println(cart);
    }

    public ShoppingCart findByName(String name) {
        return cart.stream().filter(shoppingCart -> name.equals(shoppingCart.getName())).findAny().orElse(null);
    }

    public void removeCartByName(String name) {
        cart.removeIf(s -> s.getName().equals(name));
    }

    public boolean existByName(String name) {
        return cart.stream()
                .anyMatch(shoppingCart -> shoppingCart.getName().equalsIgnoreCase(name));
    }
}