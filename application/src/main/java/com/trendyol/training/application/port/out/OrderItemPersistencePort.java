package com.trendyol.training.application.port.out;



import com.trendyol.training.application.dto.OrderItemProjection;
import com.trendyol.training.application.dto.OrderItemResponse;

import java.util.List;

public interface OrderItemPersistencePort {
    List<OrderItemResponse> findOrderItemByOrderId(Long orderId);

    List<OrderItemProjection> findOrderItemByOrder_Id(Long orderId);

}
