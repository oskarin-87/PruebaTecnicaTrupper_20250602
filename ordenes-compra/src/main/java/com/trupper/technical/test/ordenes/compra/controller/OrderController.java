package com.trupper.technical.test.ordenes.compra.controller;

import com.trupper.technical.test.ordenes.compra.entities.Orders;
import com.trupper.technical.test.ordenes.compra.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/orders")
@RestController
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Orders>> getAllRegisterOrders() {
        return orderService.getAllOrders();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<HttpStatus> deleteOrderById(@PathVariable Long id){
        return orderService.deleteOrderById(id);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Orders> updateOrder(@RequestBody Orders newOrderData, @PathVariable Long id){
        return orderService.updateOrder(newOrderData, id);
    }

    @PostMapping("/add")
    public ResponseEntity<List<Orders>> addOrder(@RequestBody List<Orders> newOrderList){
        return orderService.addOrder(newOrderList);
    }
}