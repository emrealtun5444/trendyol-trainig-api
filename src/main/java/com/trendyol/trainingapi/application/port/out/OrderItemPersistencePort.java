package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.application.dto.response.OrderItemProjection;
import com.trendyol.trainingapi.application.dto.response.OrderItemResponse;

import java.util.List;

public interface OrderItemPersistencePort {

    List<OrderItemResponse> findOrderItemByOrderId(Long orderId);

    List<OrderItemProjection> findOrderItemByOrder_Id(Long orderId);

}
