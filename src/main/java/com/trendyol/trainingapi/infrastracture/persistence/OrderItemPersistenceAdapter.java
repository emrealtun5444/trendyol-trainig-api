package com.trendyol.trainingapi.infrastracture.persistence;

import com.trendyol.trainingapi.domain.port.out.OrderItemPersistencePort;
import com.trendyol.trainingapi.infrastracture.common.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.repository.OrderItemRepository;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemInfo;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Adapter
@RequiredArgsConstructor
public class OrderItemPersistenceAdapter implements OrderItemPersistencePort {

    private final OrderItemRepository orderItemRepository;

    @Override
    public List<OrderItemResponse> findOrderItemByOrderId(Long orderId) {
        return orderItemRepository.findOrderItemByOrderId(orderId);
    }

    @Override
    public List<OrderItemInfo> findOrderItemByOrder_Id(Long orderId) {
        return orderItemRepository.findOrderItemByOrder_Id(orderId);
    }
}
