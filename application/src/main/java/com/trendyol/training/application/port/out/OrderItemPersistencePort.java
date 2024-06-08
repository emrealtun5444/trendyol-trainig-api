package com.trendyol.training.application.port.out;



import com.trendyol.training.infrastructure.rest.response.OrderItemProjection;
import com.trendyol.training.infrastructure.rest.response.OrderItemResponse;

import java.util.List;

public interface OrderItemPersistencePort {
    List<OrderItemResponse> findOrderItemByOrderId(Long orderId);

    List<OrderItemProjection> findOrderItemByOrder_Id(Long orderId);

}
