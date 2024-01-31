package com.pair.orderservice.repository;

import com.pair.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long>{  //JpaRepository(Model, primary id datatype)

}
