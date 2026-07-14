package com.example.hyadm.product.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    private long id;
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String category;
    @NotBlank
    private boolean active;
    @NotBlank
    private LocalDateTime createdAt;
}
