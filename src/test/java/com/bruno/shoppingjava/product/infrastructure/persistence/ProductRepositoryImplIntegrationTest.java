package com.bruno.shoppingjava.product.infrastructure.persistence;

import com.bruno.shoppingjava.product.ProductInfrastructureTestCase;
import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAO;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAOMother;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductRepositoryImplIntegrationTest extends ProductInfrastructureTestCase {

  private List<ProductDAO> products;
  @Autowired
  private ProductRepositoryImpl systemUnderTest;

  @BeforeEach
  void setUp() {
    crudProductRepository.deleteAll();

    var productsToSave = ProductDAOMother.randomList();
    products = productsToSave.stream()
      .map(toSave -> systemUnderTest.save(toSave.toDomain()))
      .map(ProductDAO::fromDomain)
      .toList();
  }

  @Test
  void getAll() {
    List<Product> res = systemUnderTest.getAll();
    assertThat(res).isNotEmpty();
    assertEquals(res.size(), products.size());
  }

  @Test
  void save() {
    ProductDAO productDAO = ProductDAOMother.random();
    Product product = systemUnderTest.save(productDAO.toDomain());

    assertThat(product).isNotNull();
    assertThat(product.getId()).isNotNull();
    assertThat(product.getName()).isEqualTo(productDAO.getName());
    assertThat(product.getPrice()).isEqualTo(productDAO.getPrice());
  }

  @Test
  void findById() {
    ProductDAO productDAO = products.get(0);
    Product product = systemUnderTest.findById(productDAO.getId());

    assertThat(product).isNotNull();
    Product expectedProduct = productDAO.toDomain();
    assertThat(product.getId()).isEqualTo(expectedProduct.getId());
    assertThat(product.getName()).isEqualTo(expectedProduct.getName());
    assertThat(product.getPrice()).isEqualTo(expectedProduct.getPrice());
  }

  @Test
  void deleteById() {
    ProductDAO productDAO = products.get(0);
    boolean deleted = systemUnderTest.deleteById(productDAO.getId());

    assertThat(deleted).isTrue();
    assertThat(crudProductRepository.findById(productDAO.getId())).isEmpty();
  }
}
