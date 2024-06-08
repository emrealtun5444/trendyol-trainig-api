package com.trendyol.training.application.port.in;


import com.trendyol.training.infrastructure.rest.response.OrderItemProjection;
import com.trendyol.training.infrastructure.rest.response.OrderItemResponse;

import java.util.List;

public interface OrderItemUseCase {

    List<OrderItemResponse> getOrderItemsByOrderId(Long id);
    List<OrderItemProjection> getOrderItemInfosByOrderId(Long id);
}
