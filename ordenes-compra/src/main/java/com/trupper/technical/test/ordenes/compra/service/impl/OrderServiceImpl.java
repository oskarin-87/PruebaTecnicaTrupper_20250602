package com.trupper.technical.test.ordenes.compra.service.impl;

import com.trupper.technical.test.ordenes.compra.advise.TrackExecutionTime;
import com.trupper.technical.test.ordenes.compra.entities.Orders;
import com.trupper.technical.test.ordenes.compra.repository.OrderRepository;
import com.trupper.technical.test.ordenes.compra.service.OrderService;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    //Dependency injection by constructor.
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @TrackExecutionTime
    @Override
    public ResponseEntity<List<Orders>> getAllOrders() {
        try {

            List<Orders> orderList = new ArrayList<>();
            orderRepository.findAll().forEach(orderList::add);

            if(orderList.isEmpty()) {
                return new ResponseEntity<>(orderList, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(orderList, HttpStatus.OK);

        } catch( Exception  e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @TrackExecutionTime
    @Override
    public ResponseEntity<HttpStatus> deleteOrderById(Long id) {
        Optional<Orders> orderToBeDeleted = orderRepository.findById(id);
        if(orderToBeDeleted.isPresent()){
            orderRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @TrackExecutionTime
    @Override
    public ResponseEntity<Orders> updateOrder(Orders newProductData, Long id) {
        Optional<Orders> oldEmployeeData = orderRepository.findById(id);

        if(oldEmployeeData.isPresent()) {
            Orders updatedOrderData = oldEmployeeData.get();
            updatedOrderData.setSubsidiaryId(newProductData.getSubsidiaryId());
            updatedOrderData.setDate(newProductData.getDate());

            Orders ordersObj = orderRepository.save(updatedOrderData);
            return new ResponseEntity<>(ordersObj, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @TrackExecutionTime
    @Override
    public ResponseEntity<List<Orders>> addOrder(List<Orders> newProductList) {

        List<Orders> resultOrdersList = new ArrayList<>();
        newProductList.forEach( (e) -> {
                    Example<Orders> example = Example.of(e);
                    Optional<Orders> oldOrderData = orderRepository.findOne(example);
                    if(oldOrderData.isEmpty()) {
                        resultOrdersList.add(orderRepository.save(e));
                    }
                }
        );
        return new ResponseEntity<>(resultOrdersList, HttpStatus.OK);
    }
}
