package com.trendyol.trainingapi.domain.service;

import com.trendyol.trainingapi.domain.port.in.OrderItemUseCase;
import com.trendyol.trainingapi.domain.port.out.OrderItemPersistencePort;
import com.trendyol.trainingapi.infrastracture.common.UseCase;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemInfo;
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
    public List<OrderItemInfo> getOrderItemInfosByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrder_Id(id);
    }

}
