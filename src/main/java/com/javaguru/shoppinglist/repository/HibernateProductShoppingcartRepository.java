package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductShoppingCart;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class HibernateProductShoppingcartRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductShoppingcartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Long save(ProductShoppingCart productShoppingCart) {
        sessionFactory.getCurrentSession().save(productShoppingCart);
        return productShoppingCart.getId();
    }

    public List<Product> findAllProductsByShoppingcartId(Long shoppingCartId) {
        return sessionFactory.getCurrentSession().createQuery("select t from ProductShoppingCart ut, Product t join ut.shoppingCart u where u.id = :shoppingCartId")
                .setParameter("shoppingCartId", shoppingCartId)
                .list();
    }
}