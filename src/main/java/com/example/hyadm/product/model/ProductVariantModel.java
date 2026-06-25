package com.example.hyadm.product.model;

//- id
//        - productId
//        - size
//        - color
//        - sku
//        - price
//        - active

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name="tb_product_variant")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ProductVariantModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="product_id")
    private ProductModel product;
    @NonNull
    private String size;
    @NonNull
    private String color;
    @NonNull
    @Column(unique = true)
    private String sku;
    @NonNull
    private java.math.BigDecimal price;
    @NonNull
    private boolean active;

}
