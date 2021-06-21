package com.example.javaasmserver.service;

import com.example.javaasmserver.entity.Product;
import com.example.javaasmserver.model.dto.ProductDTO;
import com.example.javaasmserver.model.mapper.ProductMapper;
import com.example.javaasmserver.repository.AccountRepository;
import com.example.javaasmserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;



    // save
    public ProductDTO save (Product product) {
        productRepository.save(product);
        ProductDTO rs = ProductMapper.productDTO(product);
        return rs;
    }

    // find all
    public List<ProductDTO> findAll(){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productDTOS = new ArrayList<>();

        for (Product item : products) {
            productDTOS.add(ProductMapper.productDTO(item));
        }
        return productDTOS;
    }

    // seeding hard code
    public boolean seeding() {
        Product product1 = new Product(1,"qua tao", 50);
        Product product2 = new Product(2,"qua cam", 60);
        Product product3 = new Product(3,"qua buoi", 70);
        Product product4 = new Product(4,"qua xoai", 80);
        Product product5 = new Product(5,"qua chuoi", 90);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        productRepository.saveAll(products);
        return true;
    }

}
