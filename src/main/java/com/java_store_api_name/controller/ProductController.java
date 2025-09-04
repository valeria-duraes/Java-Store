package com.java_store_api_name.controller;

import com.java_store_api_name.dto.ProductResponseDTO;
import com.java_store_api_name.model.ProductEntity;
import com.java_store_api_name.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/{id}")
    public ProductResponseDTO getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    };

//    @GetMapping("/{id}")
//    public ResponseEntity<Void> getProductById(@PathVariable Long id) {
//        // A lógica do Service ainda precisa ser executada para checar a existência
//        productService.getProductById(id);
//        // Retorna apenas o status 200 OK
//        return ResponseEntity.ok().build();
//    };

//    @GetMapping
//    public ResponseEntity<Void> testForEach(@RequestParam(required = false) String name) {
//
//        System.out.println("Chamando o método de treino com o nome: " + name);
//        productService.TrainingLoop(name);
//
//        // Retorna apenas o status 200 OK
//        return ResponseEntity.ok().build();
//    }

    @GetMapping
    public List<ProductResponseDTO> searchProductByName(@RequestParam(required = false) String name){
        // Adicionar uma verificação aqui para retornar todos os produtos se o nome não for fornecido

        return productService.searchProductByName(name);
    }
}
