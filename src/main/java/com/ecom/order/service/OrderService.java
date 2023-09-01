package com.ecom.order.service;


import com.ecom.order.entity.Orders;

import java.util.List;

public interface OrderService {


    List<Orders> getOrders();

    Orders getOrdersByOrderNumber(long id);

    List<Orders> getOrdersBystatus(String status);

    List<Orders> getOrderByCustomerNumber(int customerId);


    Orders insertOrder(Orders order);

    void deleteOrder(long id);
}
