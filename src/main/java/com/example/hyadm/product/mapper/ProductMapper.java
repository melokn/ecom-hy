package com.example.hyadm.product.mapper;

import com.example.hyadm.product.dto.ProductDTO;
import com.example.hyadm.product.model.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductModel toEntity(ProductDTO dto) {
        ProductModel productModel = new ProductModel();
        productModel.setId(dto.getId());
        productModel.setName(dto.getName());
        productModel.setDescription(dto.getDescription());
        productModel.setCategory(dto.getCategory());
        productModel.setCreatedAt(dto.getCreatedAt());
        productModel.setActive(dto.isActive());

        return productModel;
    }

    public ProductDTO toProductDto(ProductModel model){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(model.getId());
        productDTO.setUsername(model.getUsername());
        productDTO.setEmail(model.getEmail());
        productDTO.setPassword(model.getPassword());
        return productDTO;
    }
}
