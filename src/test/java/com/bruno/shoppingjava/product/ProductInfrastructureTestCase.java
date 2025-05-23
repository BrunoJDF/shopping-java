package com.bruno.shoppingjava.product;

import com.bruno.shoppingjava.InfrastructureTestCase;
import com.bruno.shoppingjava.product.infrastructure.persistence.CrudProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class ProductInfrastructureTestCase extends InfrastructureTestCase {
  @Autowired
  protected CrudProductRepository crudProductRepository;
}
