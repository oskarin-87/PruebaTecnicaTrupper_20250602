package com.trupper.technical.test.ordenes.compra.service;

import com.trupper.technical.test.ordenes.compra.advise.TrackExecutionTime;
import com.trupper.technical.test.ordenes.compra.entities.Orders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Service
public interface OrderService {
    //Definition of the method to obtain all orders registered in the database.
    @TrackExecutionTime
    ResponseEntity<List<Orders>> getAllOrders();

    //Definition of the method to delete an order registered in the database, passing its ID as a parameter.
    @TrackExecutionTime
    ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id);

    //Definition of the method to update any data of an order registered in the database, passing their ID as a parameter.
    @TrackExecutionTime
    ResponseEntity<Orders> updateOrder(@RequestBody Orders newOrderData, @PathVariable Long id);

    //Definition of the method for registering one or more orders in the database.
    @TrackExecutionTime
    ResponseEntity<List<Orders>> addOrder(@RequestBody List<Orders> orderList);

}
