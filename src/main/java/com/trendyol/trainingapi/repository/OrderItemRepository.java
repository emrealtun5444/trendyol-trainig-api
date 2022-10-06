package com.trendyol.trainingapi.repository;

import com.trendyol.trainingapi.controller.request.OrderItemModel;
import com.trendyol.trainingapi.controller.response.OrderItemInfo;
import com.trendyol.trainingapi.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    @Query("select new com.trendyol.trainingapi.controller.request.OrderItemModel(it.productCode, it.productName, it.category, it.quantity, it.price) from OrderItem it where it.order.id = :orderId")
    List<OrderItemModel> findOrderItemByOrderId(@Param("orderId") Long orderId);

    List<OrderItemInfo> findOrderItemByOrder_Id(Long orderId);

}