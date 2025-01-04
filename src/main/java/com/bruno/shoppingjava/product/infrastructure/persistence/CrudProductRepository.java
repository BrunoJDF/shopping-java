package com.bruno.shoppingjava.product.infrastructure.persistence;

import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAO;
import org.springframework.data.repository.CrudRepository;

public interface CrudProductRepository extends CrudRepository<ProductDAO, Long> {
}
