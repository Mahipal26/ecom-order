package com.ecom.order.repository;

import com.ecom.order.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orders,Long> {
    Optional<Orders> findByOrderNumber(long id);


    List<Orders> findByStatus(String status);

    List<Orders> findByCustomerNumber(long customerId);
}