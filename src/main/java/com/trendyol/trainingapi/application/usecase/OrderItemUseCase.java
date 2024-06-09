package com.trendyol.trainingapi.application.usecase;

import com.trendyol.trainingapi.application.dto.response.OrderItemProjection;
import com.trendyol.trainingapi.application.dto.response.OrderItemResponse;

import java.util.List;

public interface OrderItemUseCase {

    List<OrderItemResponse> getOrderItemsByOrderId(Long id);
    List<OrderItemProjection> getOrderItemInfosByOrderId(Long id);
}
