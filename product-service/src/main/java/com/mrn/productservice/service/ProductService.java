package com.mrn.productservice.service;

import com.mrn.productservice.dto.ProductDto;
import com.mrn.productservice.models.Category;
import com.mrn.productservice.models.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    void createProduct(ProductDto productDto);

    List<ProductDto> getProductsByName(String name);

    List<ProductDto> getProducts(String brand, Category category, Float size);

    Product updateProduct(Long productId, ProductDto productDTO);

    Optional<ProductDto> getProductByProductCode(String productCode);

    void deleteProduct(Long productId);

    List<ProductDto> getProducts();
}
