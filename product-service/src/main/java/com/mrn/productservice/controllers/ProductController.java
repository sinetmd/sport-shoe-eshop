package com.mrn.productservice.controllers;

import com.mrn.productservice.dto.ProductDto;
import com.mrn.productservice.mapper.ProductMapper;
import com.mrn.productservice.models.Category;
import com.mrn.productservice.models.Product;
import com.mrn.productservice.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @PostMapping
    public ResponseEntity<String> createProduct(@Valid @RequestBody ProductDto productDto) {
        productService.createProduct(productDto);
        return new ResponseEntity<>("Product Successfully created", HttpStatus.CREATED);
    }

    @GetMapping(path = "/byName")
    public ResponseEntity<List<ProductDto>> getProductsByName(@RequestParam(value = "name") String name) {
        List<ProductDto> productsDto = productService.getProductsByName(name);

        return new ResponseEntity<>(productsDto, HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(required = false) String brand,
                                                        @RequestParam(required = false) Category category,
                                                        @RequestParam(required = false) Float size) {
        List<ProductDto> productsDto = productService.getProducts(brand, category, size);

        return new ResponseEntity<>(productsDto, HttpStatus.OK);
    }

    //    @GetMapping("/{code}")
    //    public ResponseEntity<ProductDTO> getProductByCode(@PathVariable("code") String code) {
    //        return null;
    //    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long productId,
                                                    @Valid @RequestBody ProductDto productDto) {

        Product product = productService.updateProduct(productId, productDto);
        return ResponseEntity.ok(productMapper.toProductDto(product));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        List<ProductDto> productDtoList = productService.getProducts();
        return new ResponseEntity<>(productDtoList, HttpStatus.OK);
    }
}
