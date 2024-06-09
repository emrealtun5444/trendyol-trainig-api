package com.trendyol.training.domain.aggregate;

import com.trendyol.training.domain.entity.ItemCategory;
import com.trendyol.training.domain.entity.OrderAddress;
import com.trendyol.training.domain.entity.OrderItem;
import com.trendyol.training.domain.entity.OrderStatus;
import com.trendyol.training.domain.model.OrderRequest;
import com.trendyol.training.domain.model.OrderUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long orderId;
    private User user;
    private OrderStatus status;
    private OrderAddress addressInfo;
    private List<OrderItem> orderItems;

    public static Order create(OrderRequest orderRequest) {

        final var fulfilmentAddress = OrderAddress.builder()
                .address(orderRequest.getAddressInfo().getAddress())
                .build();

        final var user = User.builder()
                .userId(orderRequest.getUserId())
                .build();

        final var order = Order.builder()
                .user(user)
                .status(OrderStatus.valueOf(orderRequest.getStatus()))
                .addressInfo(fulfilmentAddress)
                .build();

        orderRequest.getOrderItems().forEach(orderItemRequest -> {
            order.getOrderItems().add(OrderItem.builder()
                    .category(ItemCategory.valueOf(orderItemRequest.getCategory()))
                    .price(orderItemRequest.getPrice())
                    .productCode(orderItemRequest.getProductCode())
                    .productName(orderItemRequest.getProductName())
                    .quantity(orderItemRequest.getQuantity())
                    .build());
        });

        return order;
    }

    public void update(OrderUpdateRequest orderUpdateRequest) {
        this.status = OrderStatus.valueOf(orderUpdateRequest.getStatus());
    }




}