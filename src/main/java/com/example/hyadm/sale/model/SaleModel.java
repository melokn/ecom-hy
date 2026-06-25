package com.example.hyadm.sale.model;

import com.example.hyadm.shared.enums.Status;
import com.example.hyadm.user.model.UserModel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//- id
//- userId
//- totalAmount
//- discount
//- status (PENDING, PAID, CANCELLED)
//- createdAt
@Entity
@Table(name = "tb_sales")
public class SaleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
    @NonNull
    private java.math.BigDecimal subtotal;
    @NonNull
    private java.math.BigDecimal totalAmount;
    @NonNull
    private java.math.BigDecimal discount;
    @NonNull
    @Enumerated(EnumType.STRING)
    private Status status;
    @NonNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "sale")
    private List<SaleItemModel> items = new ArrayList<>();

    public void addItem(SaleItemModel item) {
        this.items.add(item);
        item.setSale(this);
    }
    public void removeItem(SaleItemModel item) {
        this.items.remove(item);
        item.setSale(null);
    }
}
