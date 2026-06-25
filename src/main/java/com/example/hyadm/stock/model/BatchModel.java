package com.example.hyadm.stock.model;

import com.example.hyadm.product.model.ProductVariantModel;
import com.example.hyadm.purchase.model.PurchaseItemModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import java.time.LocalDateTime;

//id
//variant (ProductVariant)
//purchaseItem (PurchaseItem)
//initialQuantity
//        remainingQuantity
//costPrice
//expirationDate (opcional)
//createdAt
@Entity
@Table(name = "tb_batches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BatchModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "variant_id", nullable = false)
    private ProductVariantModel variant;
    @ManyToOne
    @JoinColumn(name = "purchase_item_id", nullable = false)
    private PurchaseItemModel purchaseItem;
    @NonNull
    private Integer initialQuantity;
    @NonNull
    private Integer remainingQuantity;
    @NonNull
    private LocalDateTime creationDate;

}
