package com.javaguru.shoppinglist.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shoppingcart_products")
public class ShoppingCartProduct {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    @ManyToOne
    @JoinColumn(name = "shoppingcart_id", nullable = false)
    private ShoppingCart shoppingCart;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCartProduct that = (ShoppingCartProduct) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(product, that.product) &&
                Objects.equals(shoppingCart, that.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, product, shoppingCart);
    }

    @Override
    public String toString() {
        return "ShoppingCartProduct{" +
                "id=" + id +
                ", product=" + product +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}