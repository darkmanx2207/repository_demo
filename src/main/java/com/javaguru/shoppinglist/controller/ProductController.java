package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@Validated({ProductDTO.Create.class}) @RequestBody ProductDTO productDTO,
                                       UriComponentsBuilder builder) {
        Long id = productService.createProduct(productDTO);
        return ResponseEntity.created(builder.path("/products/{id}").buildAndExpand(id).toUri()).build();
    }

    @GetMapping(params = "name")
    public ProductDTO findProductByName(@RequestParam("name") String name) {
        return productService.findProductByName(name);
    }

    @GetMapping("/{id}")
    public ProductDTO findProductById(@PathVariable("id") Long id) {
        return productService.findProductById(id);
    }

    @GetMapping
    public List<Product> showAllProducts() {
        return productService.showAllProducts();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.removeProduct(id);
    }
}