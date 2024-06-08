package com.trendyol.training.infrastructure.rest;


import com.trendyol.training.domain.model.request.OrderRequest;
import com.trendyol.training.domain.model.request.OrderUpdateRequest;
import com.trendyol.training.domain.model.response.OrderItemResponse;
import com.trendyol.training.domain.aggregate.Order;
import com.trendyol.training.application.port.in.OrderItemUseCase;
import com.trendyol.training.application.port.in.OrderUseCase;
import com.trendyol.training.domain.model.response.OrderItemProjection;
import com.trendyol.training.domain.model.response.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/order")
@Slf4j
public class OrderController {

    private final OrderUseCase orderUseCase;
    private final OrderItemUseCase orderItemUseCase;

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody @Valid OrderRequest orderRequest) {
        orderUseCase.create(orderRequest);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/orders")
    public Page<Order> getOrders(@RequestParam int page, @RequestParam int size) {
        return orderUseCase.getOrders(page, size);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody @Valid OrderUpdateRequest orderUpdateRequest) {
        orderUseCase.updateOrderStatus(id, orderUpdateRequest);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponse>> getByUserId(@PathVariable Long userId) {
        final var orders = orderUseCase.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getByOrderId(@PathVariable Long orderId) {
        final var orders = orderUseCase.getOrderById(orderId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderResponse>> getByOrders() {
        final var orders = orderUseCase.getOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/items/{orderId}")
    public ResponseEntity<List<OrderItemResponse>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        final var orders = orderItemUseCase.getOrderItemsByOrderId(orderId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/v2/items/{orderId}")
    public ResponseEntity<List<OrderItemProjection>> getOrderItemInfosByOrderId(@PathVariable Long orderId) {
        final var orders = orderItemUseCase.getOrderItemInfosByOrderId(orderId);
        return ResponseEntity.ok(orders);
    }

}
