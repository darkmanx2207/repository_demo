package com.javaguru.shoppinglist.repository;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ShoppingCartProduct;
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

    public Long save(ShoppingCartProduct shoppingCartProduct) {
        sessionFactory.getCurrentSession().save(shoppingCartProduct);
        return shoppingCartProduct.getId();
    }

    public List<Product> findAllProductsByShoppingcartId(Long shoppingCartId) {
        return sessionFactory.getCurrentSession().createQuery("select t from ShoppingCartProduct ut, Product t join ut.shoppingCart u where u.id = :shoppingCartId")
                .setParameter("shoppingCartId", shoppingCartId)
                .list();
    }
}