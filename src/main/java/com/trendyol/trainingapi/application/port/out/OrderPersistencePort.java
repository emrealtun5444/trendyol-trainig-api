package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.domain.aggregate.Order;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {

    Optional<Order> findById(Long id);

    void save(Order order);

    List<Order> findByUser_Id(Long userId);

    Optional<Order> findOrderByJpql(Long id);

    List<Order> findOrders();

    Page<Order> getOrders(int page, int size);
}
