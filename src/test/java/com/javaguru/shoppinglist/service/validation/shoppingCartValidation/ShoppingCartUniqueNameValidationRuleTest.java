package com.javaguru.shoppinglist.service.validation.shoppingCartValidation;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import com.javaguru.shoppinglist.dto.ShoppingCartDTO;
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
    private ShoppingCartDTO shoppingCartDTO = shoppingCartDTO();

    @Test
    public void shouldThrowValidationException() {
        when(cartRepository.existByName(shoppingCartDTO.getName()))
                .thenReturn(true);

        assertThatThrownBy(() -> victim.validate(shoppingCartDTO))
                .isInstanceOf(ValidationException.class)
                .hasMessage("Shopping cart must be unique.");
    }

    private ShoppingCartDTO shoppingCartDTO() {
        ShoppingCartDTO shoppingCartDTO = new ShoppingCartDTO();
        shoppingCartDTO.setName("Milk");
        shoppingCartDTO.setId(1L);
        return shoppingCartDTO;
    }
}