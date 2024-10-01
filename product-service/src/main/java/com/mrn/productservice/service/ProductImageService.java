package com.mrn.productservice.service;

import com.mrn.productservice.models.ProductImage;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

public interface ProductImageService {
    void uploadImage(MultipartFile file);

    void deleteImage(Long id);

    ProductImage updateImage(ProductImage productImage);

    List<ProductImage> getProductImages();

    Optional<ProductImage> getProductImageById(Long id);
}
