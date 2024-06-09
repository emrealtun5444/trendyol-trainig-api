package com.trendyol.training.application.usecase;


import com.trendyol.training.application.dto.OrderItemProjection;
import com.trendyol.training.application.dto.OrderItemResponse;

import java.util.List;

public interface OrderItemUseCase {

    List<OrderItemResponse> getOrderItemsByOrderId(Long id);
    List<OrderItemProjection> getOrderItemInfosByOrderId(Long id);
}
