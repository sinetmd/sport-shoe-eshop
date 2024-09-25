package com.mrn.productservice.service;

import com.mrn.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    Product findProduct(String name);

    Product updateProduct(Long productId);

    void deleteProduct(Long productId);

    List<Product> getProducts();

}
