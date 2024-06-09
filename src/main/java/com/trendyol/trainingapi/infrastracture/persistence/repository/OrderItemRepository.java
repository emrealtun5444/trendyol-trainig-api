package com.trendyol.trainingapi.infrastracture.persistence.repository;

import com.trendyol.trainingapi.infrastracture.persistence.entity.OrderItemEntity;
import com.trendyol.trainingapi.application.dto.response.OrderItemProjection;
import com.trendyol.trainingapi.application.dto.response.OrderItemResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {

    @Query("select new com.trendyol.trainingapi.infrastracture.rest.response.OrderItemResponse(" +
            "it.productCode, it.productName, it.category, it.quantity, it.price" +
            ") " +
            "from OrderItemEntity it " +
            "where it.order.id = :orderId")
    List<OrderItemResponse> findOrderItemByOrderId(@Param("orderId") Long orderId);

    List<OrderItemProjection> findOrderItemByOrder_Id(Long orderId);

}