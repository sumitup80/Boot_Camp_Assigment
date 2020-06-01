package com.example.demo.controlller;

import com.example.demo.model.Product;
import com.example.demo.services.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<Product>> getAllproducts(){
        List<Product> list = productService.findAll();
        return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);

    }

    @PostMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> insertProduct(@RequestBody Product product){
        Product insertedProduct =  productService.insertProduct(product);
        return new ResponseEntity<Integer>(insertedProduct.getProductId(),new HttpHeaders(), HttpStatus.CREATED);

    }

    @PutMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> updateProduct(@RequestBody Product product){
        Product updated =  productService.updateProduct(product);
        return new ResponseEntity<Integer>(updated.getProductId(),new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Integer> deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
        return new ResponseEntity<Integer>(null,new HttpHeaders(), HttpStatus.NO_CONTENT);
    }
}
