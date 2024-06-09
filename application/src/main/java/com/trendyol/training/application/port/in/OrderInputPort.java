package com.trendyol.training.application.port.in;

import com.trendyol.training.application.dto.PageImpl;
import com.trendyol.training.application.usecase.OrderUseCase;
import com.trendyol.training.application.port.out.OrderPersistencePort;
import com.trendyol.training.domain.aggregate.Order;
import com.trendyol.training.domain.exception.BusinessException;
import com.trendyol.training.domain.model.OrderAddressModel;
import com.trendyol.training.domain.model.OrderItemModel;
import com.trendyol.training.domain.model.OrderRequest;
import com.trendyol.training.domain.model.OrderUpdateRequest;
import com.trendyol.training.application.dto.OrderResponse;
import com.trendyol.training.application.dto.OrderUserModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderInputPort implements OrderUseCase {

    private final OrderPersistencePort orderPersistencePort;

    public void create(OrderRequest orderRequest) {
        final var order = Order.create(orderRequest);
        orderPersistencePort.save(order);
    }

    public void updateOrderStatus(Long orderId, OrderUpdateRequest orderUpdateRequest) {
        var orderOptional = orderPersistencePort.findById(orderId);
        if (orderOptional.isEmpty()) {
            throw new BusinessException("Order not found");
        }

        var order = orderOptional.get();
        order.update(orderUpdateRequest);
        orderPersistencePort.save(order);
    }

    public List<OrderResponse> getOrdersByUser(Long userId) {
        final var orders = orderPersistencePort.findByUser_Id(userId);
        return getOrderResponses(orders);
    }

    public List<OrderResponse> getOrders() {
        // final var order = orderPersistencePort.findAll();
        final var orders = orderPersistencePort.findOrders();
        return getOrderResponses(orders);
    }

    public PageImpl<Order> getOrders(int page, int size) {
        return orderPersistencePort.getOrders(page, size);
    }

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
