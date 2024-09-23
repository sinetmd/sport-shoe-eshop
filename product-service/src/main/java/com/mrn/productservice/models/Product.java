package com.mrn.productservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @NotEmpty(message = "Product name is required")
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Image> imagesUrl;

    // I think this should be a floating point
    // there is size that is 33.5, 42.5 that I wear always
    // TODO: Come back to here!
    @Min(1)
    @Max(56)
    private Float size;

    // Shoes can have unisex
    // both for male and female
    @Enumerated(EnumType.STRING)
    private Set<Gender> genders;

    @NotNull(message = "Product price is required")
    @DecimalMin("0.1")
    @Column(nullable = false)
    private BigDecimal price;

    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
