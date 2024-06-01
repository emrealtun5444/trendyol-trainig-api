package com.trendyol.trainingapi.domain.service;

import com.trendyol.trainingapi.application.port.in.OrderItemUseCase;
import com.trendyol.trainingapi.application.port.out.OrderItemPersistencePort;
import com.trendyol.trainingapi.application.annotation.UseCase;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemProjection;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@Service
@RequiredArgsConstructor
public class OrderItemService implements OrderItemUseCase {

    private final OrderItemPersistencePort orderItemPersistencePort;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderItemResponse> getOrderItemsByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrderId(id);
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<OrderItemProjection> getOrderItemInfosByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrder_Id(id);
    }

}
