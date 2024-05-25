package com.trendyol.trainingapi.repository;

import com.trendyol.trainingapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser_Id(Long userId);

    @Query("select o from Order o join fetch o.user join fetch o.fulfilmentAddress where o.id = :id")
    Optional<Order> findOrderByJpql(@Param("id") Long id);

    @Query("select o from Order o join fetch o.user join fetch o.fulfilmentAddress")
   // @Query("select o from Order o join fetch o.user join fetch o.fulfilmentAddress join fetch o.orderItems")
    List<Order> findOrders();

}