package com.example.javaasmserver.model.mapper;

import com.example.javaasmserver.entity.Product;
import com.example.javaasmserver.model.dto.ProductDTO;

public class ProductMapper {
    public static ProductDTO productDTO (Product product) {
        ProductDTO tmp = new ProductDTO();
        tmp.setName(product.getName());
        tmp.setPrice(product.getPrice());
        return tmp;
    }
}
