package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemProjection;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;

import java.util.List;

public interface OrderItemPersistencePort {
    List<OrderItemResponse> findOrderItemByOrderId(Long orderId);

    List<OrderItemProjection> findOrderItemByOrder_Id(Long orderId);

}
