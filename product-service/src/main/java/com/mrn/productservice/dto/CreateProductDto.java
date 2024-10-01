package com.mrn.productservice.dto;

import com.mrn.productservice.models.Category;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record CreateProductDto(
        String productCode,
        String name,
        Category category,
        String brand,
        Float size,
        String description,
        String color,
        BigDecimal price,
        Integer stock,
        LocalDateTime createdDate) {}
