package com.java_store_api_name.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDTO {

    private long id;
    private String productName;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Boolean available;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private String imageUrl;
}
