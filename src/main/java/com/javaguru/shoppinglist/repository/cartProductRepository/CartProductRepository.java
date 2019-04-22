package com.javaguru.shoppinglist.repository.cartProductRepository;

import com.javaguru.shoppinglist.domain.ShoppingCartProduct;

import java.util.List;

public interface CartProductRepository {

    Long save(ShoppingCartProduct shoppingCartProduct);

    List<ShoppingCartProduct> showAllCartProducts();
}