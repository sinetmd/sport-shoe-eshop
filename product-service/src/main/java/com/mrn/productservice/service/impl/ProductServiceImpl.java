package com.mrn.productservice.service.impl;

import com.mrn.productservice.models.Product;
import com.mrn.productservice.repository.ProductRepository;
import com.mrn.productservice.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
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
        newProduct.setSize(product.getSize());
        newProduct.setCategory(product.getCategory());
        newProduct.setPrice(product.getPrice());
        newProduct.setCreatedDate(LocalDateTime.now());
        newProduct.setUpdatedDate(null);

        return productRepository.save(newProduct);
    }

    @Override
    public Product findProduct(String name) {
        return productRepository.findProductByName(name).orElseThrow(
                () -> new RuntimeException("Product not found!")
        );
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
        return productRepository.findAll();
    }
}
