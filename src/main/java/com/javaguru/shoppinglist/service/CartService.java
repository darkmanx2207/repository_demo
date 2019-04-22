package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.mapper.ShoppingCartConverter;
import com.javaguru.shoppinglist.repository.cartRepository.CartRepository;
import com.javaguru.shoppinglist.service.validation.shoppingCartValidation.ShoppingCartValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public class CartService {
    private final CartRepository cartRepository;
    private final ProductService productService;
    private final ShoppingCartValidationService shoppingCartValidationService;
    private final ShoppingCartConverter shoppingCartConverter;

    @Autowired
    public CartService(CartRepository cartRepository, ProductService productService, ShoppingCartValidationService shoppingCartValidationService, ShoppingCartConverter shoppingCartConverter) {
        this.cartRepository = cartRepository;
        this.productService = productService;
        this.shoppingCartValidationService = shoppingCartValidationService;
        this.shoppingCartConverter = shoppingCartConverter;
    }

    public Long createCart(ShoppingCartDTO shoppingCartDTO) {
        shoppingCartValidationService.validate(shoppingCartDTO);
        ShoppingCart shoppingCart = shoppingCartConverter.convert(shoppingCartDTO);
        return cartRepository.create(shoppingCart);
    }

    public List<ShoppingCartDTO> showCarts() {
        return cartRepository.showShoppingCart().stream()
                .map(shoppingCartConverter::convert)
                .collect(Collectors.toList());
    }

    public ShoppingCartDTO findCartByName(String name) {
        return cartRepository.findCartByName(name)
                .map(shoppingCartConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Task not found, name: " + name));
    }

    public ShoppingCartDTO findCartById(Long id) {
        return cartRepository.findCartById(id)
                .map(shoppingCartConverter::convert)
                .orElseThrow(() -> new NoSuchElementException("Task not found, id: " + id));
    }

    public void removeCart(Long id) {
        cartRepository.findCartById(id)
                .ifPresent(cartRepository::delete);
    }
}