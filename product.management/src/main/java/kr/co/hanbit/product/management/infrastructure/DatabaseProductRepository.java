package kr.co.hanbit.product.management.infrastructure;

import kr.co.hanbit.product.management.domain.Product;
import kr.co.hanbit.product.management.presentation.ProductController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class DatabaseProductRepository {
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public DatabaseProductRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public Product add(Product product) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        SqlParameterSource namedParameter = new BeanPropertySqlParameterSource(product);
        namedParameterJdbcTemplate
                .update("INSERT INTO products (name, price, amount) VALUES (:name, :price, :amount)",
                        namedParameter, keyHolder);
        Long generatedId = keyHolder.getKey().longValue();
        product.setId(generatedId);

        return product;
    }

    public Product findById(Long id) {
        return null;
    }

    public List<Product> findAll() {
        return Collections.EMPTY_LIST;
    }

    public List<Product> findByNameContaining(String name) {
        return Collections.EMPTY_LIST;
    }

    public Product update(Product product) {
        return null;
    }

    public void delete(Long id) {

    }
}
