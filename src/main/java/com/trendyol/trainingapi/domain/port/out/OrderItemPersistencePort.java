package com.trendyol.trainingapi.domain.port.out;


import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemInfo;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;

import java.util.List;

public interface OrderItemPersistencePort {
    List<OrderItemResponse> findOrderItemByOrderId(Long orderId);

    List<OrderItemInfo> findOrderItemByOrder_Id(Long orderId);

}
