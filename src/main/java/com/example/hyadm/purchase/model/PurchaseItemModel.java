package com.example.hyadm.purchase.model;


import com.example.hyadm.product.model.ProductVariantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

//- id
//- purchaseId
//- variantId
//- quantity
//- costPrice
@Entity
@Table(name="tb_purchase_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"variant_id", "purchase_id"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "purchase_id", nullable = false)
    private PurchaseModel purchase;
    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariantModel variant;
    @NonNull
    private Integer quantity;
    @NonNull
    private BigDecimal costPrice;

}
