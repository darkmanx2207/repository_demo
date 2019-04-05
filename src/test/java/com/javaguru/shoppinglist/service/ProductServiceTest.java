package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.productRepository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository repository;
    @Mock
    private ProductValidationService validationService;
    @Mock
    private ProductConverter converter;
    @InjectMocks
    private ProductService victim;
    @Captor
    private ArgumentCaptor<ProductDTO> productCaptor;

    @Test
    public void shouldCreateProduct() {
        ProductDTO productDTO = new ProductDTO();
        Product product = new Product();
        when(converter.convert(productDTO)).thenReturn(product);
        when(repository.create(product)).thenReturn(product.getId());

        Long result = victim.createProduct(productDTO);

        verify(validationService).validate(productCaptor.capture());
        ProductDTO captorResult = productCaptor.getValue();

        assertThat(captorResult).isEqualTo(productDTO);
        assertThat(product.getId()).isEqualTo(result);
    }

    @Test
    public void shouldFindProductById() {
        when(repository.findProductById(1001L)).thenReturn(Optional.ofNullable(product()));
        when(converter.convert(product())).thenReturn(productDTO());

        ProductDTO result = victim.findProductById(1001L);

        assertThat(result).isEqualTo(productDTO());
    }

    private ProductDTO productDTO() {
        ProductDTO product = new ProductDTO();
        product.setName("TEST_NAME");
        product.setDescription("TEST_DESCRIPTION");
        product.setId(1001L);
        return product;
    }

    private Product product() {
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setDescription("TEST_DESCRIPTION");
        product.setId(1001L);
        return product;
    }
}