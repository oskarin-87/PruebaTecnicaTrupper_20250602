package com.trupper.technical.test.ordenes.compra.service;

import com.trupper.technical.test.ordenes.compra.advise.TrackExecutionTime;
import com.trupper.technical.test.ordenes.compra.entities.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

@Service
public interface ProductService {
    //Definition of the method to obtain all products registered in the database.
    @TrackExecutionTime
    ResponseEntity<List<Product>> getAllProducts();

    //Definition of the method to delete a product registered in the database, passing its ID as a parameter.
    @TrackExecutionTime
    ResponseEntity<HttpStatus> deleteProductById(@PathVariable Long id);

    //Definition of the method to update any data of a product registered in the database, passing their ID as a parameter.
    @TrackExecutionTime
    ResponseEntity<Product> updateProduct(@RequestBody Product newProductData, @PathVariable Long id);

    //Definition of the method for registering one or more products in the database.
    @TrackExecutionTime
    ResponseEntity<List<Product>> addEmployees(@RequestBody List<Product> productList);

}