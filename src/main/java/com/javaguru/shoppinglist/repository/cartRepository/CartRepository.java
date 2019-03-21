package com.javaguru.shoppinglist.repository.cartRepository;

import com.javaguru.shoppinglist.domain.ShoppingCart;

public interface CartRepository {

    ShoppingCart create(ShoppingCart shoppingCart);

    void showShoppingCart();

    ShoppingCart findByName(String name);

    void removeCartByName(String name);

    boolean existByName(String name);
}