package com.example.hyadm.purchase.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_suppliers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupplierModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String contact;
    private String email;
    @NonNull
    private LocalDateTime createdAt;

}
