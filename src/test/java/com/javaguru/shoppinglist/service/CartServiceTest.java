package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.cartRepository.CartInMemoryRepository;
import com.javaguru.shoppinglist.service.validation.shoppingCartValidation.ShoppingCartValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
    @Mock
    private CartInMemoryRepository cartInMemoryRepository;
    @Mock
    private ShoppingCartValidationService cartService;
    @InjectMocks
    private CartService victim;
    @Captor
    private ArgumentCaptor<ShoppingCart> cartArgumentCaptor;

    @Test
    public void shouldFindShoppingCart() {
        ShoppingCart shoppingCart = shoppingCart();
        when(cartInMemoryRepository.create(shoppingCart)).thenReturn(shoppingCart);
        Long result = victim.createCart(shoppingCart);
        verify(cartService).validate(cartArgumentCaptor.capture());
        ShoppingCart captorResult = cartArgumentCaptor.getValue();
        assertEquals(captorResult, shoppingCart);
        assertEquals(shoppingCart.getId(), result);
    }

    private ShoppingCart shoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName("Milk");
        shoppingCart.setId(1L);
        return shoppingCart;
    }
}