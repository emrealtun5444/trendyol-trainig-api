package com.trendyol.trainingapi.application.port.in;

import com.trendyol.trainingapi.application.annotation.UseCase;
import com.trendyol.trainingapi.application.usecase.OrderItemUseCase;
import com.trendyol.trainingapi.application.port.out.OrderItemPersistencePort;
import com.trendyol.trainingapi.application.dto.response.OrderItemProjection;
import com.trendyol.trainingapi.application.dto.response.OrderItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@UseCase
@Service
@RequiredArgsConstructor
public class OrderItemInputPort implements OrderItemUseCase {

    private final OrderItemPersistencePort orderItemPersistencePort;

    public List<OrderItemResponse> getOrderItemsByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrderId(id);
    }

    public List<OrderItemProjection> getOrderItemInfosByOrderId(Long id) {
        return orderItemPersistencePort.findOrderItemByOrder_Id(id);
    }

}
