package com.javaguru.shoppinglist.repository.productRepository;

import com.javaguru.shoppinglist.domain.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Component
public class JdbcProductRepository implements ProductRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Product create(Product product) {
        String query = "insert into products (name,price,actualPrice,description,discount,productCategory) values (" +
                "?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection
                    .prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, product.getName());
            ps.setBigDecimal(2, product.getPrice());
            ps.setBigDecimal(3, product.getActualPrice());
            ps.setString(4, product.getDescription());
            ps.setBigDecimal(5, product.getDiscount());
            ps.setString(6, String.valueOf(product.getProductCategory()));
            return ps;

        }, keyHolder);
        return product;
    }

    @Override
    public Optional<Product> findBy(Long id) {
        String query = "select * from products where id= " + id;
        List<Product> products = jdbcTemplate.query(query,
                new BeanPropertyRowMapper(Product.class));
        if (!products.isEmpty()) {
            return Optional.ofNullable(products.get(0));
        }
        return Optional.empty();
    }

    @Override
    public boolean existByName(String name) {
        String query = "SELECT CASE WHEN count(*)> 0 " +
                "THEN true ELSE false END " +
                "FROM products where name='" + name + "'";
        return jdbcTemplate.queryForObject(query, Boolean.class);
    }

    @Override
    public Optional<Product> findByName(String name) {
        String query = "select * from products where name='" + name + "'";
        return jdbcTemplate.query(query, new BeanPropertyRowMapper(Product.class)).stream()
                .findFirst();
    }
}