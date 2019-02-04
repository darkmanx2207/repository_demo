package com.javaguru.shoppinglist;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String name;
    private BigDecimal price;
    private BigDecimal actualPrice;
    private String description;
    private BigDecimal discount;
    private ProductCategory productCategory;

    public Product(BigDecimal discount, ProductCategory productCategory, String description) {
        this.discount = discount;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription() {
        this.description = description;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }


    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
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

    public BigDecimal discountPrice() {
        actualPrice = price.subtract(price.multiply(discount).divide(BigDecimal.valueOf(100)));
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(actualPrice, product.actualPrice) &&
                Objects.equals(description, product.description) &&
                Objects.equals(discount, product.discount) &&
                productCategory == product.productCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, actualPrice, description, discount, productCategory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", actualPrice=" + actualPrice +
                ", description='" + description + '\'' +
                ", productCategory=" + productCategory +
                '}';
    }
}


