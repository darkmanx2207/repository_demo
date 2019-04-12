package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
import com.javaguru.shoppinglist.mapper.ShoppingCartConverter;
import com.javaguru.shoppinglist.repository.cartRepository.CartRepository;
import com.javaguru.shoppinglist.service.validation.shoppingCartValidation.ShoppingCartValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {
    @Mock
    private CartRepository cartRepository;
    @Mock
    private ShoppingCartValidationService cartService;
    @Mock
    private ShoppingCartConverter cartConverter;
    @InjectMocks
    private CartService victim;
    @Captor
    private ArgumentCaptor<ShoppingCartDTO> cartArgumentCaptor;

    @Test
    public void shouldFindShoppingCart() {
        ShoppingCartDTO shoppingCartDTO = shoppingCartDTO();
        ShoppingCart shoppingCart = new ShoppingCart();
        when(cartConverter.convert(shoppingCartDTO())).thenReturn(shoppingCart());
        when(cartRepository.create(shoppingCart())).thenReturn(shoppingCart.getId());

        Long result = victim.createCart(shoppingCartDTO);

        verify(cartService).validate(cartArgumentCaptor.capture());

        ShoppingCartDTO captorResult = cartArgumentCaptor.getValue();

        assertEquals(captorResult, shoppingCartDTO);
        assertEquals(shoppingCart.getId(), result);
    }

    @Test
    public void shouldFindCartById() {
        when(cartRepository.findCartById(1001L)).thenReturn(Optional.ofNullable(shoppingCart()));
        when(cartConverter.convert(shoppingCart())).thenReturn(shoppingCartDTO());

        ShoppingCartDTO result = victim.findCartById(1001L);

        assertThat(result).isEqualTo(shoppingCartDTO());
    }

    private ShoppingCartDTO shoppingCartDTO() {
        ShoppingCartDTO shoppingCart = new ShoppingCartDTO();
        shoppingCart.setName("Milk");
        shoppingCart.setId(1L);
        return shoppingCart;
    }

    private ShoppingCart shoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName("Milk");
        shoppingCart.setId(1L);
        return shoppingCart;
    }
}