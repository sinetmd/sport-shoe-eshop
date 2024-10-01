package com.mrn.productservice.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_images")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id")
    private Long imageId;

    @Column(nullable = false)
    @NotEmpty(message = "Image should not be empty")
    private String imageUrl;

    private Boolean isMain;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private LocalDateTime createdDate = LocalDateTime.now();

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
