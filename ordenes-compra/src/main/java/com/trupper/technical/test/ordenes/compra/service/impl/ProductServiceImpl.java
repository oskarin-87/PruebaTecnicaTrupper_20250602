package com.trupper.technical.test.ordenes.compra.service.impl;

import com.trupper.technical.test.ordenes.compra.entities.Product;
import com.trupper.technical.test.ordenes.compra.repository.ProductRepository;
import com.trupper.technical.test.ordenes.compra.service.ProductService;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    //Dependency injection by constructor.
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> productList = new ArrayList<>();
            productRepository.findAll().forEach(productList::add);

            if(productList.isEmpty()) {
                return new ResponseEntity<>(productList, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(productList, HttpStatus.OK);

        } catch( Exception  e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<HttpStatus> deleteProductById(Long id) {
        Optional<Product> productToBeDeleted = productRepository.findById(id);
        if(productToBeDeleted.isPresent()){
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Product> updateProduct(Product newProductData, Long id) {
        Optional<Product> oldEmployeeData = productRepository.findById(id);

        if(oldEmployeeData.isPresent()) {
            Product updatedProductData = oldEmployeeData.get();
            updatedProductData.setOrderId(newProductData.getOrderId());
            updatedProductData.setCode(newProductData.getCode());
            updatedProductData.setDescription(newProductData.getDescription());
            updatedProductData.setPrice(newProductData.getPrice());

            Product productObj = productRepository.save(updatedProductData);
            return new ResponseEntity<>(productObj, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<List<Product>> addEmployees(List<Product> newProductList) {

        List<Product> resultEmployeeList = new ArrayList<>();
        newProductList.forEach( (e) -> {
                    Example<Product> example = Example.of(e);
                    Optional<Product> oldEmployeeData = productRepository.findOne(example);
                    if(oldEmployeeData.isEmpty()) {
                        resultEmployeeList.add(productRepository.save(e));
                    }
                }
        );
        return new ResponseEntity<>(resultEmployeeList, HttpStatus.OK);
    }
}
