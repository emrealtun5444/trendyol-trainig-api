package com.trendyol.trainingapi.infrastracture.persistence;

import com.trendyol.trainingapi.application.port.out.OrderItemPersistencePort;
import com.trendyol.trainingapi.application.annotation.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.repository.OrderItemRepository;
import com.trendyol.trainingapi.application.dto.response.OrderItemProjection;
import com.trendyol.trainingapi.application.dto.response.OrderItemResponse;
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
