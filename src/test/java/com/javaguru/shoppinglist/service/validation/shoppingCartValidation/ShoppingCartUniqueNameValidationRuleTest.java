package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.repository.cartRepository.CartRepository;
import com.javaguru.shoppinglist.service.validation.ValidationException;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ShoppingCartUniqueNameValidationRuleTest {
    @Mock
    private CartRepository cartRepository;
    @InjectMocks
    private ShoppingCartUniqueNameValidationRule victim;
    private ShoppingCart shoppingCart = shoppingCart();

    @Test
    public void shouldThrowValidationException() {
        when(cartRepository.existByName(shoppingCart.getName()))
                .thenReturn(true);

        assertThatThrownBy(() -> victim.validate(shoppingCart))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Shopping cart must be unique.");
    }

    private ShoppingCart shoppingCart() {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setName("Milk");
        shoppingCart.setId(1L);
        return shoppingCart;
    }
}