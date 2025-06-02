package com.trupper.technical.test.ordenes.compra.repository;

import com.trupper.technical.test.ordenes.compra.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
}
