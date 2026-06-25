package com.example.hyadm.cart.model;

import com.example.hyadm.user.model.UserModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//- id
//- userId
//- createdAt
@Entity
@Table(name="tb_user_cart")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="user_id", nullable = false, unique = true)
    private UserModel user;
    @NonNull
    private LocalDateTime createdAt;
    @OneToMany(mappedBy = "cart")
    private List<CartItemModel> cartItems = new ArrayList<>();

    public void addCartItem(CartItemModel cartItem) {
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }
    public void removeCartItem(CartItemModel cartItem) {
        cartItems.remove(cartItem);
        cartItem.setCart(null);
    }

}
