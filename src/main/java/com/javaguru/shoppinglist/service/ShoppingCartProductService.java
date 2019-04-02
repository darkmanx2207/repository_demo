package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.domain.ShoppingCartProduct;
import com.javaguru.shoppinglist.repository.HibernateProductShoppingcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartProductService {

    private final CartService cartService;
    private final ProductService productService;
    private final HibernateProductShoppingcartRepository hibernateProductShoppingcartRepository;

    @Autowired
    public ShoppingCartProductService(CartService cartService, ProductService productService, HibernateProductShoppingcartRepository hibernateProductShoppingcartRepository) {
        this.cartService = cartService;
        this.productService = productService;
        this.hibernateProductShoppingcartRepository = hibernateProductShoppingcartRepository;
    }

    public void assignProduct(String cartName, Long productId) {
        Product product = productService.findProductById(productId);
        ShoppingCart shoppingCart = cartService.findCartByName(cartName);
        ShoppingCartProduct shoppingCartProduct = new ShoppingCartProduct();
        shoppingCartProduct.setProduct(product);
        shoppingCartProduct.setShoppingCart(shoppingCart);
        hibernateProductShoppingcartRepository.save(shoppingCartProduct);
    }
}