package com.javaguru.shoppinglist.domain;


import java.util.Objects;

public class ShoppingCart {

    private String name = "Shopping cart";
    private Product cartList;

   // public Product getCartList(){
   //     return cartList;
   // }
   // public void setCartList(Product product){
    //    this.cartList = product;
   // }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "name='" + name + '\'' +
                '}';
    }
}

