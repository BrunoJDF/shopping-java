package com.bruno.shoppingjava.product.domain;

import java.util.List;

public interface ProductRepository {
  List<Product> getAll();

  Product save(Product product);

  Product findById(Long id);
}
