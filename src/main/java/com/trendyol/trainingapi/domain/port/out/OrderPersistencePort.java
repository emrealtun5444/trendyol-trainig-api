package com.trendyol.trainingapi.domain.port.out;


import com.trendyol.trainingapi.domain.entity.Order;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {

    Optional<Order> findById(Long id);

    void save(Order order);

    List<Order> findByUser_Id(Long userId);

    Optional<Order> findOrderByJpql(Long id);

    List<Order> findOrders();
}
