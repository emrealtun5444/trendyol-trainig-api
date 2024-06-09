package com.trendyol.training.infrastructure.persistence;

import com.trendyol.training.infrastructure.rest.response.OrderItemResponse;
import com.trendyol.training.application.port.out.OrderItemPersistencePort;
import com.trendyol.training.application.annotation.Adapter;
import com.trendyol.training.infrastructure.persistence.repository.OrderItemRepository;
import com.trendyol.training.infrastructure.rest.response.OrderItemProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class OrderItemPersistenceAdapter implements OrderItemPersistencePort {

    private final OrderItemRepository orderItemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemResponse> findOrderItemByOrderId(Long orderId) {
        return orderItemRepository.findOrderItemByOrderId(orderId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderItemProjection> findOrderItemByOrder_Id(Long orderId) {
        return orderItemRepository.findOrderItemByOrder_Id(orderId);
    }
}
