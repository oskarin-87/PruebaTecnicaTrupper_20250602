package com.trupper.technical.test.ordenes.compra.controller;

import com.trupper.technical.test.ordenes.compra.entities.Product;
import com.trupper.technical.test.ordenes.compra.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/products")
@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Product>> getAllRegisterProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<HttpStatus> deleteProductById(@PathVariable Long id){
        return productService.deleteProductById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProductData, @PathVariable Long id){
        return productService.updateProduct(newProductData, id);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Product>> addProduct(@RequestBody List<Product> newProductList){
        return productService.addEmployees(newProductList);
    }
}
