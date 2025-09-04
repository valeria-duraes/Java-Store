package com.java_store_api_name.service;

import com.java_store_api_name.dto.ProductResponseDTO;
import com.java_store_api_name.exception.ResourceNotFoundException;
import com.java_store_api_name.model.ProductEntity;
import com.java_store_api_name.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

//    public void TrainingLoop(String name){
//        List<ProductEntity> products = productRepository.findByProductNameContainingIgnoreCase(name);
//
//        products.forEach(product -> {
//            System.out.println("Produto encontrado com o forEach: " + product.getProductName());
//        });
//    }

    public List<ProductResponseDTO> searchProductByName(String productName) {
        // 1. Busca no repositório e recebe a lista de entidades
        List<ProductEntity> products = productRepository.findByProductNameContainingIgnoreCase(productName);

        // 2. Cria uma nova lista vazia para guardar os DTOs
        List<ProductResponseDTO> productsDTOs = new ArrayList<>();

        // 3. Percorre a lista de entidades com um forEach
        // for (ProductEntity product : products) {}

        products.forEach(product -> {

        // 4. Cria um DTO para cada entidade e adiciona na nova lista
            ProductResponseDTO dto = ProductResponseDTO.builder()
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

            productsDTOs.add(dto);
        });

        // 5. Retorna a lista de DTOs preenchida
        return productsDTOs;
    }


}
