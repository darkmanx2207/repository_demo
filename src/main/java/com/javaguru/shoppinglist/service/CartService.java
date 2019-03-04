package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.CartInMemoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartService {
    private final CartInMemoryRepository memoryRepository;
    private final ProductService productService;
    private  ShoppingCart shoppingCart;

    @Autowired
    public CartService(CartInMemoryRepository memoryRepository, ProductService productService, ShoppingCart shoppingCart) {
        this.memoryRepository = memoryRepository;
        this.productService = productService;
        this.shoppingCart = shoppingCart;
    }

    public Long createCart(ShoppingCart shoppingCart) {//////String name) {
        ShoppingCart createdCart = memoryRepository.create(shoppingCart);
        return createdCart.getId();
    }

    public String addProductInCart(String name,Product product) {
        //ShoppingCart shoppingCart = new ShoppingCart();
       // Product product = new Product();
        for (Product list : productService.getBase().database.values()) {
            if (list.getName().equals(name)) {
                shoppingCart.setCartProductList(list);
                System.out.println(list);
                memoryRepository.cart.add(shoppingCart);

                System.out.println(memoryRepository.cart);//

            }
        }
        return name;
    }
}


// public Object showCarts() {
//      return memoryRepository.showCarts();
// }




