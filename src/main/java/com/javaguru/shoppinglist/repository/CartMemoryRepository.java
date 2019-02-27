package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.service.validation.ValidationException;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class CartMemoryRepository {
    private final ProductInMemoryRepository memoryRepository;

    public Set<ShoppingCart> cartbase = new HashSet<>();

    public CartMemoryRepository(ProductInMemoryRepository memoryRepository) {
        this.memoryRepository = memoryRepository;


    }
    // public ShoppingCart addShoppingCart(ShoppingCart shoppingCart){
      ///  cartbase.add(shoppingCart);
      //  return shoppingCart;
    // }

    public String createCart(String name) {
        for (Product list : memoryRepository.database.values()) {

            ShoppingCart shoppingCart = new ShoppingCart();
            if (list.getName().equals(name)) {


            }

        }
        return name;

    }


    public void getCart() {
        System.out.println(cartbase);
    }

    public String removeProductByName(String name) {
        for (ShoppingCart list : cartbase) {//
            if (list.getName().equals(name)) {
                cartbase.remove(list);
            } else {
                throw new ValidationException("Incorretly introduced id.");
            }
        }
        if (memoryRepository.database.isEmpty()) {
            throw new ValidationException("Incorretly introduced id.");
        }
        return name;
    }

    public BigDecimal sumOfCartPrices() {
        BigDecimal price = BigDecimal.ZERO;
        for (ShoppingCart list : cartbase) {//
            // price = price.add();//
        }
        return price;
    }
}