package com.mrn.productservice.controllers;

import com.mrn.productservice.dto.ProductDTO;
import com.mrn.productservice.models.Product;
import com.mrn.productservice.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getProducts();
//        List<Product> products = productService.getProducts();
//
//        return products.stream()
//                .map(product -> {
//                    Set<String> imageUrls = product.getImage().stream()
//                            .map(Image::getImageUrl).collect(Collectors.toSet());
//
//                    return new ProductDTO(
//                            product.getProductId(),
//                            product.getName(),
//                            product.getDescription(),
//                            product.getSize(),
//                            product.getGenders(),
//                            product.getPrice(),
//                            imageUrls,
//                            product.getCreatedAt()
//                    );
//                }
//        ).collect(Collectors.toList());
    }
}
