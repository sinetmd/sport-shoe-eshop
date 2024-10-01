package com.mrn.productservice.repository;

import com.mrn.productservice.models.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {}
