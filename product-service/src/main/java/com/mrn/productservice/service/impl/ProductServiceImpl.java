package com.mrn.productservice.service.impl;

import com.mrn.productservice.dto.ProductDto;
import com.mrn.productservice.exception.ProductNotFoundException;
import com.mrn.productservice.mapper.ProductMapper;
import com.mrn.productservice.models.Category;
import com.mrn.productservice.models.Product;
import com.mrn.productservice.repository.ProductRepository;
import com.mrn.productservice.service.ProductService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public void createProduct(ProductDto productDto) {
        if (productDto == null) {
            throw new IllegalArgumentException("Product data cannot be null");
        }

        if (productRepository
                .findProductByProductCode(productDto.getProductCode())
                .isPresent()) {
            throw new IllegalArgumentException("Product already present in database");
        }

        // because we use methods to set date (onCreate() and onUpdate())
        // see Product.class
        Product newProduct = productMapper.toProductEntity(productDto);

        productRepository.save(newProduct);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name).stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProducts(String brand, Category category, Float size) {

        return productRepository.findProducts(brand, category, size).stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public Product updateProduct(Long productId, ProductDto productDTO) {
        Product product = productRepository
                .findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        System.err.println(product.getCreatedDate());

        // update the existing product
        productMapper.updateProductFromDto(productDTO, product);

        System.err.println("dto date: " + product.getCreatedDate());

        // update the last modified date
        product.setUpdatedDate(LocalDateTime.now());

        // save the updated product in the db
        return productRepository.save(product);
    }

    @Override
    public Optional<ProductDto> getProductByProductCode(String productCode) {
        return productRepository.findProductByProductCode(productCode).map(productMapper::toProductDto);
    }

    @Override
    public void deleteProduct(Long productId) {
        if (!productRepository.existsById(productId)) {
            throw new ProductNotFoundException("Product with id " + productId + " not found");
        }

        productRepository.deleteById(productId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();

        return products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }
}
