package com.trendyol.trainingapi.domain.port.in;

import com.trendyol.trainingapi.infrastracture.rest.request.OrderRequest;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderUpdateRequest;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderResponse;

import java.util.List;

public interface OrderUseCase {

    void create(OrderRequest orderRequest);

    void updateOrderStatus(Long orderId, OrderUpdateRequest orderUpdateRequest);

    List<OrderResponse> getOrdersByUser(Long userId);

    List<OrderResponse> getOrders();

    OrderResponse getOrderById(Long id);

}
