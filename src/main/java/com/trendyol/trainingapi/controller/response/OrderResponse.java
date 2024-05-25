package com.trendyol.trainingapi.controller.response;

import com.trendyol.trainingapi.controller.request.OrderAddressModel;
import com.trendyol.trainingapi.controller.request.OrderItemModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long orderId;
    private OrderUserModel user;

    private String status;

    private OrderAddressModel addressInfo;

    private List<OrderItemModel> orderItems;


}
