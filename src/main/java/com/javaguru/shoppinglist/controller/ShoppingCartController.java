package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {

    private final CartService cartService;

    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<ShoppingCart> create(@RequestBody ShoppingCartDTO shoppingCartDTO) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName(shoppingCartDTO.getName());
        return ResponseEntity.ok(shoppingCart);
    }

    @GetMapping("/{name}")
    public ShoppingCartDTO findTaskByName(@PathVariable("name") String name) {
        ShoppingCart shoppingCart = cartService.findCartByName(name);
        return new ShoppingCartDTO(shoppingCart.getId(), shoppingCart.getName());
    }
}