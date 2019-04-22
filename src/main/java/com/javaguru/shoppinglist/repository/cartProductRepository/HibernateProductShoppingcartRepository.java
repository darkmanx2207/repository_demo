package com.javaguru.shoppinglist.repository.cartProductRepository;

import com.javaguru.shoppinglist.domain.ShoppingCartProduct;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class HibernateProductShoppingcartRepository implements CartProductRepository {

    private final SessionFactory sessionFactory;

    public HibernateProductShoppingcartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long save(ShoppingCartProduct shoppingCartProduct) {
        sessionFactory.getCurrentSession().save(shoppingCartProduct);
        return shoppingCartProduct.getId();
    }

    @Override
    public List<ShoppingCartProduct> showAllCartProducts() {
        return sessionFactory.getCurrentSession().createCriteria(ShoppingCartProduct.class).list();
    }
}