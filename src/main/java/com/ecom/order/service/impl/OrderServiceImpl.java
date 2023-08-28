package com.ecom.order.service.impl;

import com.ecom.order.entity.Orders;
import com.ecom.order.repository.OrderRepository;
import com.ecom.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Orders> getOrders() {
        return orderRepository.findAll();
    }

    //@Query("SELECT u FROM orders u WHERE u.orderNumber = ?1")
    @Override
    public Orders getOrdersByOrderNumber(long id) {

        Optional<Orders> order = orderRepository.findByOrderNumber(id);

        return order.isPresent() ? order.get() :null;

    }

    @Override
    public List<Orders> getOrdersBystatus(String status) {
        return orderRepository.findByStatus(status);
    }

    @Override
    public List<Orders> getOrderByCustomerNumber(int customerId) {
        return orderRepository.findByCustomerNumber(customerId);
    }


}
