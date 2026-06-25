package com.example.hyadm.cart.model;

import com.example.hyadm.product.model.ProductVariantModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

//- id
//- cartId
//- variantId
//- quantity

@Entity
@Table(name = "tb_cart_item", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cart_id", "variant_id"})
})
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItemModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartModel cart;
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private ProductVariantModel variant;
    @NonNull
    private Integer quantity;
}
