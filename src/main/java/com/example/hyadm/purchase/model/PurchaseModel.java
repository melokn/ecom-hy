package com.example.hyadm.purchase.model;


//- id
//- supplierId
//- totalCost
//- status
//- createdAt

import com.example.hyadm.shared.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_purchases")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "supplier_id", nullable = false)
    private SupplierModel supplier;
    @NonNull
    private BigDecimal totalCost;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NonNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseItemModel> purchaseItems = new ArrayList<>();

    public void addPurchaseItem(@NonNull PurchaseItemModel purchaseItemModel) {
        this.purchaseItems.add(purchaseItemModel);
        purchaseItemModel.setPurchase(this);
    }
    public void removePurchaseItem(@NonNull PurchaseItemModel purchaseItemModel) {
        this.purchaseItems.remove(purchaseItemModel);
        purchaseItemModel.setPurchase(null);
    }

}
