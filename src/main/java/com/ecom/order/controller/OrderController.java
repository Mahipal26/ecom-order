package com.ecom.order.controller;

import com.ecom.order.entity.Orders;
import com.ecom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/orders")
@RestController
public class OrderController {

    @Autowired
    OrderService service;

    @GetMapping(value = "/")
    public List<Orders> getAllOrders(){

        return service.getOrders();
    }

    @GetMapping("/{id}")
    public Orders getOrderByOrderNumber(@PathVariable long id) {

       return service.getOrdersByOrderNumber(id);

    }
    @GetMapping("/status")
    public List<Orders> getOrderByOrderStatus(@RequestParam(value="status") String status) {

        return service.getOrdersBystatus(status);

    }

    @GetMapping("/customer/{customerId}")
    public List<Orders> getOrderByCustomerNumber(@PathVariable int customerId) {

        return service.getOrderByCustomerNumber(customerId);

    }



}
