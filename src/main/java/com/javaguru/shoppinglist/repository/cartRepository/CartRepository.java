package com.javaguru.shoppinglist.repository.cartRepository;

import com.javaguru.shoppinglist.domain.ShoppingCart;

import java.util.List;
import java.util.Optional;

public interface CartRepository {

    Long create(ShoppingCart shoppingCart);

    Optional<ShoppingCart> findCartById(Long id);

    List<ShoppingCart> showShoppingCart();

    Optional<ShoppingCart> findCartByName(String name);

    boolean existByName(String name);

    void delete(ShoppingCart shoppingCart);
}