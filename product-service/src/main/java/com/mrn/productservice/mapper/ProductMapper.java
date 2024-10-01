package com.mrn.productservice.mapper;

import com.mrn.productservice.dto.ProductDto;
import com.mrn.productservice.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProductEntity(ProductDto productDto);

    ProductDto toProductDto(Product product);

    @Mapping(target = "createdDate", ignore = true)
    void updateProductFromDto(ProductDto productDto, @MappingTarget Product product);
}
