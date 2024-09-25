package com.mrn.productservice.dto;

import com.mrn.productservice.models.Category;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ProductDTO(
        Long productId, String name, String description,
        Float size, Category category, BigDecimal price,
        Set<String> imagesUrl, LocalDateTime createdAt) {
}
