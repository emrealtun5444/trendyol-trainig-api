package com.trendyol.trainingapi.controller;


import com.trendyol.trainingapi.controller.request.OrderItemModel;
import com.trendyol.trainingapi.controller.request.OrderRequest;
import com.trendyol.trainingapi.controller.request.OrderUpdateRequest;
import com.trendyol.trainingapi.controller.response.OrderItemInfo;
import com.trendyol.trainingapi.controller.response.OrderResponse;
import com.trendyol.trainingapi.service.OrderItemService;
import com.trendyol.trainingapi.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/order")
@Slf4j
public class OrderController {

    private final OrderService orderService;
    private final OrderItemService orderItemService;

    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody @Valid OrderRequest orderRequest) {
        orderService.saveOrder(orderRequest);
        return ResponseEntity.ok(true);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody @Valid OrderUpdateRequest orderUpdateRequest) {
        orderService.updateOrderStatus(id, orderUpdateRequest);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderResponse>> getByUserId(@PathVariable Long userId) {
        final var orders = orderService.getOrdersByUser(userId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getByOrderId(@PathVariable Long orderId) {
        final var orders = orderService.getOrderById(orderId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/items/{orderId}")
    public ResponseEntity<List<OrderItemModel>> getOrderItemsByOrderId(@PathVariable Long orderId) {
        final var orders = orderItemService.getOrderItemsByOrderId(orderId);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/v2/items/{orderId}")
    public ResponseEntity<List<OrderItemInfo>> getOrderItemInfosByOrderId(@PathVariable Long orderId) {
        final var orders = orderItemService.getOrderItemInfosByOrderId(orderId);
        return ResponseEntity.ok(orders);
    }

}
