package com.java_store_api_name.repository;

import com.java_store_api_name.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByProductNameContainingIgnoreCase(String productName);
}
