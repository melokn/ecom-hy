package com.example.hyadm.stock.model;

import com.example.hyadm.product.model.ProductVariantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

//- id
//- variantId
//- totalQuantity
//- updatedAt
@Entity
@Table(name = "tb_stock")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="variant_id", nullable=false, unique=true)
    private ProductVariantModel variant;
    @NonNull
    private Integer totalQuantity;
    @NonNull
    private LocalDateTime updatedAt;

}
