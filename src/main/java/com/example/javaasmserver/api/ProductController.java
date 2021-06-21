package com.example.javaasmserver.api;

import com.example.javaasmserver.entity.Product;
import com.example.javaasmserver.model.dto.ProductDTO;
import com.example.javaasmserver.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping()
    public ProductDTO create(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping()
    public List<ProductDTO> findAll() {
        return productService.findAll();
    }

    @GetMapping("/seeding")
    public boolean seeding() {
        return productService.seeding();
    }
}
