package com.javaguru.shoppinglist.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Component
public class ShoppingCart {
    private String name;
    private Long id;
    private List<Product> addProducts = new ArrayList<>();

    public void addProduct(Product product) {
        addProducts.add(product);
    }

    public void sumOfAllProducts() {
        BigDecimal count = BigDecimal.ZERO;
        for (Product list : addProducts) {
            count = count.add(list.getActualPrice());
        }
        System.out.println("sum of all products cost is " + count);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(id, that.id) &&
                Objects.equals(addProducts, that.addProducts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, addProducts);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", addProduct=" + addProducts +
                '}';
    }
}