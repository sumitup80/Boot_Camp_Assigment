package com.example.demo.services;

import com.example.demo.model.Product;
import com.example.demo.repositories.CustomerRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Integer deleteProduct(Product product) {
        productRepository.delete(product);
        return product.getProductId();
    }
}
