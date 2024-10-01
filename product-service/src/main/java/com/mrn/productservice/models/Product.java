package com.mrn.productservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@NoArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @NotEmpty(message = "Product should have a code")
    @Column(nullable = false, unique = true)
    private String productCode;

    @NotEmpty(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private String brand;

    @Min(1)
    @Max(56)
    private Float size;

    @Column(nullable = false)
    private String description;

    private String color;

    @NotNull(message = "Product price is required")
    @DecimalMin("0.1")
    @Column(nullable = false)
    private BigDecimal price;

    @Min(0)
    private int stock;

    @Column(updatable = false)
    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    // onCreate is going to be automatically set when a product is created
    @PrePersist
    public void onCreate() {
        this.createdDate = LocalDateTime.now();
    }

    // onUpdate will be automatically updated when the product is modified.
    @PreUpdate
    public void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
