package com.mrn.productservice.dto;

import com.mrn.productservice.models.Category;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    String productCode;
    String name;
    Category category;
    String brand;
    Float size;
    String description;
    String color;
    BigDecimal price;
    Integer stock;
    LocalDateTime createdDate;
    LocalDateTime updatedDate;
};
