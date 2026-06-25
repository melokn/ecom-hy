package com.example.hyadm.sale.model;

//- id
//- saleId
//- variantId
//- quantity
//- unitPrice
//- totalPrice

import com.example.hyadm.product.model.ProductVariantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_sale_items", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"variant_id", "sale_id"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sale_id", nullable = false)
    private SaleModel sale;
    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariantModel variant;
    @NonNull
    private Integer quantity;
    @NonNull
    private BigDecimal unitPrice;
    @NonNull
    private BigDecimal totalPrice;
}
