package com.mrn.productservice.repository;

import com.mrn.productservice.models.Category;
import com.mrn.productservice.models.Product;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainingIgnoreCase(String name);

    @Query("SELECT p FROM Product p WHERE p.productCode = :code")
    Optional<Product> findProductByProductCode(@Param("code") String productCode);

    @Query("SELECT p FROM Product p WHERE (:brand IS NULL OR p.brand ILIKE :brand) " +
            "AND (:category IS NULL OR p.category = :category) " +
            "AND (:size IS NULL OR p.size = :size)"
    )
    List<Product> findProducts(String brand, Category category, Float size);

    @Query("SELECT p FROM Product p WHERE p.category = :category OR p.category = 'UNISEX'")
    List<Product> findProductsByCategoryOrUnisex(@Param("category") Category category);

    @Query("SELECT p FROM Product p WHERE p.size = : size AND p.size >= 1 AND p.size <= 56")
    List<Product> findProductsBySize(@Param("size") @Min(1) @Max(56) Float size);
}
