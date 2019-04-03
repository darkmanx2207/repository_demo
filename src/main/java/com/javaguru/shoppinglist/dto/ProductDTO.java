package com.javaguru.shoppinglist.dto;

import com.javaguru.shoppinglist.domain.ProductCategory;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal actualPrice;
    private String description;
    private BigDecimal discount;
    private ProductCategory productCategory;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, BigDecimal price, BigDecimal actualPrice, String description, BigDecimal discount, ProductCategory productCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.actualPrice = actualPrice;
        this.description = description;
        this.discount = discount;
        this.productCategory = productCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(BigDecimal actualPrice) {
        this.actualPrice = actualPrice;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}