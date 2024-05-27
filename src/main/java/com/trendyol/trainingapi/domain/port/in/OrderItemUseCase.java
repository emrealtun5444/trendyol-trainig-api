package com.trendyol.trainingapi.domain.port.in;

import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemInfo;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;

import java.util.List;

public interface OrderItemUseCase {

    List<OrderItemResponse> getOrderItemsByOrderId(Long id);
    List<OrderItemInfo> getOrderItemInfosByOrderId(Long id);
}
