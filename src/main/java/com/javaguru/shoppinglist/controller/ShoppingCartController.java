package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/shoppingcarts")
public class ShoppingCartController {

    private final CartService cartService;

    public ShoppingCartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({ShoppingCartDTO.Create.class}) @RequestBody ShoppingCartDTO shoppingCartDTO,
                                       UriComponentsBuilder builder) {
        Long id = cartService.createCart(shoppingCartDTO);
        return ResponseEntity.created(builder.path("/shoppingcarts/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping(params = "name")
    public ShoppingCartDTO findCartByName(@RequestParam("name") String name) {
        return cartService.findCartByName(name);
    }

    @GetMapping
    public List<ShoppingCartDTO> showCart() {
        return cartService.showCarts();
    }

    @GetMapping("/{id}")
    public ShoppingCartDTO findCartById(@PathVariable("id") Long id) {
        return cartService.findCartById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        cartService.removeCart(id);
    }
}