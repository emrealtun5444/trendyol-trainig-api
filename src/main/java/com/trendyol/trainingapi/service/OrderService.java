package com.trendyol.trainingapi.service;

import com.trendyol.trainingapi.common.exception.BusinessException;
import com.trendyol.trainingapi.controller.request.OrderAddressModel;
import com.trendyol.trainingapi.controller.request.OrderItemModel;
import com.trendyol.trainingapi.controller.request.OrderRequest;
import com.trendyol.trainingapi.controller.request.OrderUpdateRequest;
import com.trendyol.trainingapi.controller.response.OrderResponse;
import com.trendyol.trainingapi.controller.response.OrderUserModel;
import com.trendyol.trainingapi.domain.Order;
import com.trendyol.trainingapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveOrder(OrderRequest orderRequest) {

        final var order = Order.create(orderRequest);
        orderRepository.save(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateOrderStatus(Long orderId, OrderUpdateRequest orderUpdateRequest) {
        var orderOptional = orderRepository.findById(orderId);
        if (orderOptional.isEmpty()) {
            throw new BusinessException("Order not found");
        }

        var order = orderOptional.get();
        order.update(orderUpdateRequest);
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getOrdersByUser(Long userId) {
        final var orders = orderRepository.findByUser_Id(userId);
        return getOrderResponses(orders);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        // final var order = orderRepository.findById(id);
        final var order = orderRepository.findOrderByJpql(id);
        return order.map(value -> getOrderResponses(Collections.singletonList(value)).get(0)).orElse(null);
    }

    private List<OrderResponse> getOrderResponses(List<Order> orders) {
        return orders.stream().map(order -> {
            final var orderItems = order.getOrderItems().stream().map(orderItem -> {
                return OrderItemModel.builder()
                        .category(orderItem.getCategory().name())
                        .productCode(orderItem.getProductCode())
                        .productName(orderItem.getProductName())
                        .quantity(orderItem.getQuantity())
                        .price(orderItem.getPrice())
                        .build();
            }).collect(Collectors.toList());


            return OrderResponse.builder()
                    .user(OrderUserModel.builder()
                            .email(order.getUser().getEmail())
                            .nameSurname(order.getUser().getNameSurname())
                            .build())
                    .status(order.getStatus().name())
                    .addressInfo(OrderAddressModel.builder()
                            .address(order.getFulfilmentAddress().getAddress())
                            .build())
                    .orderItems(orderItems)
                    .build();
        }).collect(Collectors.toList());
    }

}
