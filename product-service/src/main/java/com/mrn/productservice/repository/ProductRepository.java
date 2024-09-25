package com.mrn.productservice.repository;

import com.mrn.productservice.models.Category;
import com.mrn.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findProductByName(String name);

    Optional<List<Product>> findProductByCategory(Category category);

    Optional<List<Product>> findProductBySize(Integer size);
}
