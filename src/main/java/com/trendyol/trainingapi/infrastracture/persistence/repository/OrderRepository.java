package com.trendyol.trainingapi.infrastracture.persistence.repository;

import com.trendyol.trainingapi.infrastracture.persistence.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Long> {

    @EntityGraph(attributePaths = {"fulfilmentAddress"})
    List<OrderEntity> findByUser_Id(Long userId);

    @Query("select o from OrderEntity o join fetch o.user join fetch o.fulfilmentAddress where o.id = :id")
    Optional<OrderEntity> findOrderByJpql(@Param("id") Long id);

    @EntityGraph(attributePaths = {"user", "fulfilmentAddress"})
    Optional<OrderEntity> findOrderEntityById(Long id);

    @Query("select o from OrderEntity o join fetch o.user join fetch o.fulfilmentAddress")
   // @Query("select o from OrderEntity o join fetch o.user join fetch o.fulfilmentAddress join fetch o.orderItems")
    List<OrderEntity> findOrders();

    @Query("select o from OrderEntity o join fetch o.user join fetch o.fulfilmentAddress")
    Page<OrderEntity> findOrders(Pageable pageable);

}