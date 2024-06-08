package com.trendyol.training.domain.service;



import com.trendyol.training.domain.annotation.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
@RequiredArgsConstructor
public class OrderItemService implements OrderItemUseCase {

    private final OrderItemPersistencePort orderItemPersistencePort;

    public List<OrderItemResponse> getOrderItemsByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrderId(id);
    }

    public List<OrderItemProjection> getOrderItemInfosByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrder_Id(id);
    }

}
