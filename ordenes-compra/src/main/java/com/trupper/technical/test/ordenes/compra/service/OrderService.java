package com.trupper.technical.test.ordenes.compra.service;

import com.trupper.technical.test.ordenes.compra.entities.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public interface OrderService {
    //Definition of the method to obtain all products registered in the database.
    ResponseEntity<List<Orders>> getAllOrders();

    //Definition of the method to delete a product registered in the database, passing its ID as a parameter.
    ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id);

    //Definition of the method to update any data of a product registered in the database, passing their ID as a parameter.
    ResponseEntity<Orders> updateOrder(@RequestBody Orders newOrderData, @PathVariable Long id);

    //Definition of the method for registering one or more products in the database.
    ResponseEntity<List<Orders>> addOrder(@RequestBody List<Orders> orderList);

}
