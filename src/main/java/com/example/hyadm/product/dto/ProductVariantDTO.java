package com.example.hyadm.product.dto;

import com.example.hyadm.product.model.ProductModel;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantDTO {

   private long id;
   @NotBlank
   private ProductModel productId;
   @NotBlank
    private String size;
   @NotBlank
    private String color;
   @NotBlank
    private String sku;
   @NotBlank
    private java.math.BigDecimal price;
   @NotBlank
    private boolean active;
}
