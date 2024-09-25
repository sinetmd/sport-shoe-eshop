package com.mrn.productservice.service.impl;

import com.mrn.productservice.models.Product;
import com.mrn.productservice.repository.ProductRepository;
import com.mrn.productservice.service.ProductService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        Product newProduct = new Product();
        newProduct.setName(product.getName());
        newProduct.setDescription(product.getDescription());
        newProduct.setImagesUrl(product.getImagesUrl());
        newProduct.setSize(product.getSize());
        newProduct.setPrice(product.getPrice());
        newProduct.setCreatedAt(LocalDateTime.now());
        newProduct.setUpdatedAt(null);

        return productRepository.save(newProduct);
    }

    @Override
    public Product updateProduct(Long productId) {
        return null;
    }

    @Override
    public void deleteProduct(Long productId) {

    }

    @Override
    public List<Product> getProducts() {
        return List.of();
    }
}
