package com.bruno.shoppingjava.product.infrastructure.persistence;

import com.bruno.shoppingjava.product.domain.Product;
import org.springframework.data.repository.CrudRepository;

public interface CrudProductRepository extends CrudRepository<Product, Long> {
}
