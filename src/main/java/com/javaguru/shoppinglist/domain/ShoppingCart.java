package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "shoppingcarts")
public class ShoppingCart {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @ElementCollection
    private List<Product> addProducts = new ArrayList<>();

    public void addProduct(Product product) {
        addProducts.add(product);
    }

    public List<Product> sumOfAllProducts() {
        return addProducts;
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