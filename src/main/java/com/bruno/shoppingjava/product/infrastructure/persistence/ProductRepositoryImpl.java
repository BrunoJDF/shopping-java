package com.bruno.shoppingjava.product.infrastructure.persistence;

import com.bruno.shoppingjava.product.domain.Product;
import com.bruno.shoppingjava.product.domain.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryImpl implements ProductRepository {
    private final CrudProductRepository crudProductRepository;

    @Override
    public List<Product> getAll() {
        return (List<Product>) crudProductRepository.findAll();
    }
}
