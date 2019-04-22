package com.javaguru.shoppinglist.service;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.mapper.ProductConverter;
import com.javaguru.shoppinglist.repository.productRepository.ProductRepository;
import com.javaguru.shoppinglist.service.validation.ProductValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private final ProductRepository repository;
    private final ProductValidationService validationService;
    private final ProductConverter converter;

    @Autowired
    public ProductService(ProductRepository repository, ProductValidationService validationService, ProductConverter converter) {
        this.repository = repository;
        this.validationService = validationService;
        this.converter = converter;
    }

    @Transactional
    public Long createProduct(ProductDTO productDTO) {
        validationService.validate(productDTO);
        Product product = converter.convert(productDTO);
        return repository.create(product);
    }

    public ProductDTO findProductById(Long id) {
        return repository.findProductById(id)
                .map(converter::convert)
                .orElseThrow(() -> new NoSuchElementException("Product not found, id: " + id));
    }

    public ProductDTO findProductByName(String name) {
        return repository.findProductByName(name)
                .map(converter::convert)
                .orElseThrow(() -> new NoSuchElementException("Product not found, name: " + name));
    }

    public List<Product> showAllProducts() {
        return repository.showAllProducts();
    }

    public void removeProduct(Long id) {
        repository.findProductById(id)
                .ifPresent(repository::delete);
    }
}