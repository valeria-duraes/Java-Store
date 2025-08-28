package com.java_store_api_name.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "products")
@Entity
public class ProductEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(nullable = false, name = "product_name")
   private String productName;

   @Column
   private String description;

   @Column(nullable = false, scale = 15, precision = 2)
   private BigDecimal price;

   @Column
   private Integer stock;

   @Column
   private Boolean available;

   @Column(name = "create_date")
   @CreationTimestamp
   private LocalDateTime createDate;

   @Column(name = "last_update")
   @UpdateTimestamp
   private LocalDateTime lastUpdate;

   @Column(name = "image_url")
   private String imageUrl;
}
