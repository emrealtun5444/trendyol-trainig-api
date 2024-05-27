package com.trendyol.trainingapi.domain.service;

import com.trendyol.trainingapi.domain.entity.Order;
import com.trendyol.trainingapi.domain.port.in.OrderUseCase;
import com.trendyol.trainingapi.domain.port.out.OrderPersistencePort;
import com.trendyol.trainingapi.infrastracture.common.UseCase;
import com.trendyol.trainingapi.infrastracture.exception.BusinessException;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderAddressModel;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderItemModel;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderRequest;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderUpdateRequest;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderResponse;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderUserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Service
@RequiredArgsConstructor
public class OrderService implements OrderUseCase {

    private final OrderPersistencePort orderPersistencePort;

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(OrderRequest orderRequest) {

        final var order = Order.create(orderRequest);
        orderPersistencePort.save(order);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void updateOrderStatus(Long orderId, OrderUpdateRequest orderUpdateRequest) {
        var orderOptional = orderPersistencePort.findById(orderId);
        if (orderOptional.isEmpty()) {
            throw new BusinessException("Order not found");
        }

        var order = orderOptional.get();
        order.update(orderUpdateRequest);
        orderPersistencePort.save(order);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getOrdersByUser(Long userId) {
        final var orders = orderPersistencePort.findByUser_Id(userId);
        return getOrderResponses(orders);
    }

    @Transactional(readOnly = true)
    public List<OrderResponse> getOrders() {
       // final var order = orderPersistencePort.findAll();
        final var orders = orderPersistencePort.findOrders();
        return getOrderResponses(orders);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        // final var order = orderPersistencePort.findById(id);
        final var order = orderPersistencePort.findOrderByJpql(id);
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
                    .orderId(order.getOrderId())
                    .user(OrderUserModel.builder()
                            .email(order.getUser().getEmail())
                            .nameSurname(order.getUser().getNameSurname())
                            .build())
                    .status(order.getStatus().name())
                    .addressInfo(OrderAddressModel.builder()
                            .address(order.getAddressInfo().getAddress())
                            .build())
                    .orderItems(orderItems)
                    .build();
        }).collect(Collectors.toList());
    }

}
