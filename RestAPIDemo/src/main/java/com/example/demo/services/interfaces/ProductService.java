package com.example.demo.services.interfaces;

import com.example.demo.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    Product insertProduct(Product product);
    Product updateProduct(Product product);
    Integer deleteProduct(Product product);
}
