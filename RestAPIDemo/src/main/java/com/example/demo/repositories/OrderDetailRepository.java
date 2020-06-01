package com.example.demo.repositories;

import com.example.demo.model.Address;
import com.example.demo.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
