package com.trendyol.training.application.usecase;

import com.trendyol.training.application.dto.PageImpl;
import com.trendyol.training.domain.aggregate.Order;
import com.trendyol.training.domain.model.OrderRequest;
import com.trendyol.training.domain.model.OrderUpdateRequest;
import com.trendyol.training.application.dto.OrderResponse;

import java.util.List;

public interface OrderUseCase {

    void create(OrderRequest orderRequest);

    void updateOrderStatus(Long orderId, OrderUpdateRequest orderUpdateRequest);

    List<OrderResponse> getOrdersByUser(Long userId);

    List<OrderResponse> getOrders();

    OrderResponse getOrderById(Long id);

    PageImpl<Order> getOrders(int page, int size);

}
