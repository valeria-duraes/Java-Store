package com.java_store_api_name.service;

import com.java_store_api_name.dto.ProductResponseDTO;
import com.java_store_api_name.exception.ResourceNotFoundException;
import com.java_store_api_name.model.ProductEntity;
import com.java_store_api_name.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponseDTO getProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));

        // Lógica para converter a entidade em DTO e retornar
        // Mapeia a Entidade para o DTO de resposta
        return ProductResponseDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .available(product.getAvailable())
                .createDate(product.getCreateDate())
                .lastUpdate(product.getLastUpdate())
                .imageUrl(product.getImageUrl())
                .build();
    }
}
