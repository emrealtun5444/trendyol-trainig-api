package com.trendyol.trainingapi.infrastracture.persistence.repository;

import com.trendyol.trainingapi.infrastracture.persistence.entity.OrderItemEntity;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemInfo;
import com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    @Query("select new com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse(it.productCode, it.productName, it.category, it.quantity, it.price) from OrderItemEntity it where it.order.id = :orderId")
    List<OrderItemResponse> findOrderItemByOrderId(@Param("orderId") Long orderId);

    List<OrderItemInfo> findOrderItemByOrder_Id(Long orderId);

}