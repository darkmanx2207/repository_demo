package com.javaguru.shoppinglist.mapper;


import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setActualPrice(productDTO.getActualPrice());
        product.setDescription(productDTO.getDescription());
        product.setDiscount(productDTO.getDiscount());
        product.setProductCategory(productDTO.getProductCategory());
        product.discountPrice();
        return product;
    }

    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setActualPrice(product.getActualPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setDiscount(product.getDiscount());
        productDTO.setProductCategory(product.getProductCategory());
        productDTO.discountPrice();
        return productDTO;
    }
}