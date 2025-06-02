package com.trupper.technical.test.ordenes.compra.repository;


import com.trupper.technical.test.ordenes.compra.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
