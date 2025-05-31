package com.coudevi.domain.repository;

import com.coudevi.domain.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Long> {
}
