package com.trendyol.training.application.port.in;

import com.trendyol.training.application.usecase.OrderItemUseCase;
import com.trendyol.training.application.port.out.OrderItemPersistencePort;
import com.trendyol.training.application.dto.OrderItemProjection;
import com.trendyol.training.application.dto.OrderItemResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
