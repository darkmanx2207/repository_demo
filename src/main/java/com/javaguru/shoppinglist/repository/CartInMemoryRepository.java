package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CartInMemoryRepository {

    public List<ShoppingCart> cart = new ArrayList<>();

    private Long cartId = 1l;

    public ShoppingCart create(ShoppingCart shoppingCart) {
        shoppingCart.setId(cartId);
        cart.add(shoppingCart);
        cartId++;
        System.out.println(cart);//
        return shoppingCart;
    }


    public Product addProduct(ShoppingCart shoppingCart,Product product) {
        cart.add(shoppingCart);
        return product;
    }
    public List<ShoppingCart> base(){
        return cart;
    }

}
