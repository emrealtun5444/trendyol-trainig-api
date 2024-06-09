package com.trendyol.training.application.port.out;


import com.trendyol.training.application.dto.PageImpl;
import com.trendyol.training.domain.aggregate.Order;

import java.util.List;
import java.util.Optional;

public interface OrderPersistencePort {

    Optional<Order> findById(Long id);

    void save(Order order);

    List<Order> findByUser_Id(Long userId);

    Optional<Order> findOrderByJpql(Long id);

    List<Order> findOrders();

    PageImpl<Order> getOrders(int page, int size);
}
