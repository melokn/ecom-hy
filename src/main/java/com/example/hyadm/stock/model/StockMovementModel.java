package com.example.hyadm.stock.model;

import com.example.hyadm.product.model.ProductVariantModel;
import com.example.hyadm.stock.model.enums.MovementType;
import com.example.hyadm.stock.model.enums.ReferenceType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

//- id
//- variantId
//- type (IN, OUT, ADJUSTMENT)
//- quantity
//- referenceType (SALE, PURCHASE, MANUAL)
//- referenceId
//- createdAt
@Entity
@Table(name="tb_stock_movement")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariantModel variant;
    @NonNull
    @Enumerated(EnumType.STRING)
    private MovementType movementType;
    @NonNull
    private Integer quantity;
    @NonNull
    @Enumerated(EnumType.STRING)
    private ReferenceType referenceType;
    @NonNull
    private LocalDateTime date;
    private Long referenceId;

}
