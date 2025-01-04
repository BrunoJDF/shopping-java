package com.bruno.shoppingjava.product.infrastructure.persistence;

import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import com.bruno.shoppingjava.product.infrastructure.persistence.model.ProductDAO;
import com.bruno.shoppingjava.shared.application.exception.ShoppingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
  private final CrudProductRepository crudProductRepository;

  @Override
  public List<Product> getAll() {
    List<ProductDAO> products = (List<ProductDAO>) crudProductRepository.findAll();
    return products.stream()
      .map(ProductDAO::toDomain)
      .toList();
  }

  @Override
  public Product save(Product product) {
    ProductDAO productDAO = ProductDAO.fromDomain(product);
    ProductDAO saved = crudProductRepository.save(productDAO);
    return saved.toDomain();
  }

  @Override
  public Product findById(Long id) {
    return crudProductRepository.findById(id)
      .map(ProductDAO::toDomain)
      .orElseThrow(() ->
        new ShoppingNotFoundException(Product.class)
      );
  }

  @Override
  public boolean deleteById(Long id) {
    return crudProductRepository.findById(id)
      .map(product -> {
        crudProductRepository.delete(product);
        return true;
      })
      .orElse(false);
  }
}
