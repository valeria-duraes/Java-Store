package com.java_store_api_name.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateDTO {

    @NotBlank(message = "O campo nome do produto é obrigatório!")
    private String productName;

    private String description;

    @NotBlank(message = "O preço do produto é obrigatório!")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que zero!")
    private BigDecimal price;

    private Integer stock;

    private Boolean available;

    private String imageUrl;
}
