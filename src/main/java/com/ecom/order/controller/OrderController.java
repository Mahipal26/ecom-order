package com.ecom.order.controller;

import com.ecom.order.entity.Orders;
import com.ecom.order.others.CustomResponse;
import com.ecom.order.repository.OrderRepository;
import com.ecom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/orders")
@RestController
public class OrderController {

    @Autowired
    OrderService service;
    @Autowired
    OrderRepository orderRepository;

    @GetMapping(value = "/")
    public List<Orders> getAllOrders() {

        return service.getOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse> getOrderByOrderNumber(@PathVariable long id) {


        Orders data = service.getOrdersByOrderNumber(id);
        String message = "Order details for order number: " + data.getOrderNumber();


        CustomResponse customResponse = new CustomResponse(data, message);

        return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        // return service.getOrdersByOrderNumber(id);
    }

    @GetMapping("/status")
    public List<Orders> getOrderByOrderStatus(@RequestParam(value = "status") String status) {

        return service.getOrdersBystatus(status);

    }

    @GetMapping("/customer/{customerId}")
    public List<Orders> getOrderByCustomerNumber(@PathVariable int customerId) {

        return service.getOrderByCustomerNumber(customerId);

    }

    @PostMapping("/order")
    public Orders insertOrder(@RequestBody Orders order) {

        return service.insertOrder(order);

    }

    @DeleteMapping("/order/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable long id) {


        Optional<Orders> order = orderRepository.findByOrderNumber(id);
        orderRepository.delete(order.get());

        return ResponseEntity.status(HttpStatus.OK).body("Order deleted successfully");


    }


}
