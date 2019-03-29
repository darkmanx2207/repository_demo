package com.javaguru.shoppinglist.repository.cartRepository;

import com.javaguru.shoppinglist.domain.ShoppingCart;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Profile("hibernate")
@Transactional
public class HibernateCartRepository implements CartRepository {

    private final SessionFactory sessionFactory;

    @Autowired
    public HibernateCartRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public ShoppingCart create(ShoppingCart shoppingCart) {
        sessionFactory.getCurrentSession().save(shoppingCart);
        return shoppingCart;
    }

    @Override
    public void showShoppingCart() {
        sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class).list();
    }

    @Override
    public ShoppingCart findByName(String name) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        return shoppingCart;
    }

    @Override
    public void removeCartByName(String name) {
        ShoppingCart shoppingCart = (ShoppingCart) sessionFactory.getCurrentSession().createCriteria(ShoppingCart.class)
                .add(Restrictions.eq("name", name))
                .uniqueResult();
        sessionFactory.getCurrentSession().delete(name, shoppingCart);
    }

    @Override
    public boolean existByName(String name) {
        String query = "select case when count(*)> 0 " +
                "then true else false end " +
                "from ShoppingCart where name='" + name + "'";
        return (boolean) sessionFactory.getCurrentSession().createQuery(query)
                .setMaxResults(1)
                .uniqueResult();
    }
}