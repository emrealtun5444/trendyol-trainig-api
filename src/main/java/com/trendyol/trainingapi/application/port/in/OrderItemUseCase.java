package com.trendyol.trainingapi.application.port.in;

import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemProjection;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;

import java.util.List;

public interface OrderItemUseCase {

    List<OrderItemResponse> getOrderItemsByOrderId(Long id);
    List<OrderItemProjection> getOrderItemInfosByOrderId(Long id);
}
