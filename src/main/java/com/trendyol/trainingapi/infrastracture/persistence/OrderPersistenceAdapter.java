package com.trendyol.trainingapi.infrastracture.persistence;

import com.trendyol.trainingapi.domain.entity.Order;
import com.trendyol.trainingapi.domain.port.out.OrderPersistencePort;
import com.trendyol.trainingapi.infrastracture.common.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.entity.OrderEntity;
import com.trendyol.trainingapi.infrastracture.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Adapter
@RequiredArgsConstructor
public class OrderPersistenceAdapter implements OrderPersistencePort {

    private final OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(Order order) {
        orderRepository.save(new OrderEntity(order));
    }

    @Override
    @Cacheable(value = "OrderPersistenceAdapter.findById", key = "#id")
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id).map(OrderEntity::toOrder);
    }

    @Override
    public List<Order> findByUser_Id(Long userId) {
        return orderRepository.findByUser_Id(userId).stream().map(OrderEntity::toOrder).collect(Collectors.toList());
    }

    @Override
    public Optional<Order> findOrderByJpql(Long id) {
        return orderRepository.findOrderByJpql(id).map(OrderEntity::toOrder);
    }

    @Override
    public List<Order> findOrders() {
        return orderRepository.findOrders().stream().map(OrderEntity::toOrder).collect(Collectors.toList());
    }
}
