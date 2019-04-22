package com.javaguru.shoppinglist.controller;


import com.javaguru.shoppinglist.domain.ShoppingCartProduct;
import com.javaguru.shoppinglist.service.CartProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/shoppingcart_products")
public class ShoppingCartProductController {

    private final CartProductService service;


    public ShoppingCartProductController(CartProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({ShoppingCartProduct.Create.class}) @RequestBody ShoppingCartProduct shoppingCartProduct,
                                       UriComponentsBuilder builder) {
        Long id = service.save(shoppingCartProduct);
        return ResponseEntity.created(builder.path("/shoppingcart_products/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping
    public List<ShoppingCartProduct> showAllCartProducts() {
        return service.showAllCartProducts();
    }
}
