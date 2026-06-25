package com.example.hyadm.product.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String description;
    @NonNull
    private String category;
    @NonNull
    private boolean active;
    @NonNull
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "product")
    private List<ProductVariantModel> variants = new ArrayList<>();

    public void addVariant(ProductVariantModel variant) {
        variants.add(variant);
        variant.setProduct(this);
    }
    public void removeVariant(ProductVariantModel variant) {
        variants.remove(variant);
        variant.setProduct(null);
    }

}
