package com.javaguru.shoppinglist.repository.productRepository;

import com.javaguru.shoppinglist.config.AppConfig;
import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.domain.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@Import(value = {HibernateProductRepository.class, AppConfig.class})
public class ProductRepositoryIT {

    @Autowired
    private ProductRepository victim;

    @Test
    public void shouldCreateProduct() {
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setPrice(BigDecimal.TEN);
        product.setDiscount(BigDecimal.ZERO);
        product.setActualPrice(BigDecimal.ONE);
        product.setDescription("TEST_DESCRIPTION");
        product.setProductCategory(ProductCategory.MILK);

        Long result = victim.create(product);

        assertThat(result).isNotNull();
    }

    @Test
    public void shouldFindProductByName() {
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setPrice(BigDecimal.TEN);
        product.setDiscount(BigDecimal.ZERO);
        product.setActualPrice(BigDecimal.ONE);
        product.setDescription("TEST_DESCRIPTION");
        product.setProductCategory(ProductCategory.MILK);

        Long id = victim.create(product);

        Optional<Product> result = victim.findProductByName("TEST_NAME");

        assertThat(result).hasValue(expectedProduct(id));
    }

    @Test
    public void shouldFindProductById() {
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setPrice(BigDecimal.TEN);
        product.setDiscount(BigDecimal.ZERO);
        product.setActualPrice(BigDecimal.ONE);
        product.setDescription("TEST_DESCRIPTION");
        product.setProductCategory(ProductCategory.MILK);

        Long id = victim.create(product);

        Optional<Product> result = victim.findProductById(id);

        assertThat(result).hasValue(expectedProduct(id));

    }

    @Test
    public void shouldExistByName() {
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setPrice(BigDecimal.TEN);
        product.setDiscount(BigDecimal.ZERO);
        product.setActualPrice(BigDecimal.ONE);
        product.setDescription("TEST_DESCRIPTION");
        product.setProductCategory(ProductCategory.MILK);

        victim.create(product);

        boolean result = victim.existByName("TEST_NAME");

        assertThat(result).isTrue();
    }

    @Test
    public void shouldShowAllProducts() {
        Product product = new Product();
        product.setName("TEST_NAME");
        product.setPrice(BigDecimal.TEN);
        product.setDiscount(BigDecimal.ZERO);
        product.setActualPrice(BigDecimal.ONE);
        product.setDescription("TEST_DESCRIPTION");
        product.setProductCategory(ProductCategory.MILK);

        victim.create(product);

        List<Product> result = victim.showAllProducts();

        assertThat(result).isNotNull();
    }

    public Product expectedProduct(Long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("TEST_NAME");
        product.setPrice(BigDecimal.TEN);
        product.setDiscount(BigDecimal.ZERO);
        product.setActualPrice(BigDecimal.ONE);
        product.setDescription("TEST_DESCRIPTION");
        product.setProductCategory(ProductCategory.MILK);
        return product;
    }
}