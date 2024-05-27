package com.trendyol.trainingapi.infrastracture.rest;


import com.trendyol.trainingapi.domain.port.in.OrderItemUseCase;
import com.trendyol.trainingapi.domain.port.in.OrderUseCase;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderRequest;
import com.trendyol.trainingapi.infrastracture.rest.request.OrderUpdateRequest;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemInfo;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<List<OrderItemInfo>> getOrderItemInfosByOrderId(@PathVariable Long orderId) {
        final var orders = orderItemUseCase.getOrderItemInfosByOrderId(orderId);
        return ResponseEntity.ok(orders);
    }

}
