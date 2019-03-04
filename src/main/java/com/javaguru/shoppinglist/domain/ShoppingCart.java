package com.javaguru.shoppinglist.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Component
public class ShoppingCart {
    private String name;
    private Long id;
    private Product cartProductList;

    public void setCartProductList(Product cartProductList) {
        this.cartProductList = cartProductList;
    }
//public Product add(Product product){
 //   return cartProductList;
//}


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
/*
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(cartProductList, that.cartProductList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, cartProductList);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", cartProductList=" + cartProductList +
                '}';
    }
}
