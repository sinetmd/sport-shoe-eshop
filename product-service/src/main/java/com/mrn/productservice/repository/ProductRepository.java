package com.mrn.productservice.repository;

import com.mrn.productservice.models.Gender;
import com.mrn.productservice.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Integer> {
    Optional<Product> findProductByName(String name);

    Optional<List<Product>> findProductByGenders(String gender);

    Optional<List<Product>> findProductBySize(Integer size);
}
