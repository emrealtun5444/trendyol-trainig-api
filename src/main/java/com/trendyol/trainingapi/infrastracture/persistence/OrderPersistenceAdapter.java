package com.trendyol.trainingapi.infrastracture.persistence;

import com.trendyol.trainingapi.domain.aggregate.Order;
import com.trendyol.trainingapi.application.port.out.OrderPersistencePort;
import com.trendyol.trainingapi.application.annotation.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.entity.OrderEntity;
import com.trendyol.trainingapi.infrastracture.persistence.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        orderRepository.save(OrderEntity.create(order));
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

    @Override
    public Page<Order> getOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        final var ordersPageable = orderRepository.findOrders(pageable);
        return ordersPageable.map(OrderEntity::toOrder);
    }
}
