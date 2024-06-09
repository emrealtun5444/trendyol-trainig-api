package com.trendyol.trainingapi.application.usecase;

import com.trendyol.trainingapi.domain.aggregate.Order;
import com.trendyol.trainingapi.application.dto.request.OrderRequest;
import com.trendyol.trainingapi.application.dto.request.OrderUpdateRequest;
import com.trendyol.trainingapi.application.dto.response.OrderResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderUseCase {

    void create(OrderRequest orderRequest);

    void updateOrderStatus(Long orderId, OrderUpdateRequest orderUpdateRequest);

    List<OrderResponse> getOrdersByUser(Long userId);

    List<OrderResponse> getOrders();

    OrderResponse getOrderById(Long id);

    Page<Order> getOrders(int page, int size);

}
