package com.trendyol.trainingapi.infrastracture.persistence.entity;

import com.trendyol.trainingapi.domain.entity.Order;
import com.trendyol.trainingapi.domain.entity.OrderAddress;
import com.trendyol.trainingapi.domain.entity.OrderStatus;
import com.trendyol.trainingapi.domain.entity.User;
import com.trendyol.trainingapi.infrastracture.persistence.entity.common.AbstractEntity;
import com.trendyol.trainingapi.infrastracture.persistence.entity.enm.Category;
import com.trendyol.trainingapi.infrastracture.persistence.entity.enm.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_id_gen")
    @SequenceGenerator(name = "orders_id_gen", sequenceName = "orders_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fulfilment_address_id")
    private FulfilmentAddressEntity fulfilmentAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.PERSIST)
    //@Fetch(FetchMode.SUBSELECT)
    @Fetch(FetchMode.JOIN)
    //@Fetch(FetchMode.SELECT)
    //@BatchSize(size=2)
    private Set<OrderItemEntity> orderItems = new LinkedHashSet<>();

    public static OrderEntity create(Order orderRequest) {

        final var fulfilmentAddress = FulfilmentAddressEntity.builder()
                .address(orderRequest.getAddressInfo().getAddress())
                .build();

        final var order = OrderEntity.builder()
                .user(new UserEntity(orderRequest.getUser().getUserId()))
                .status(Status.valueOf(orderRequest.getStatus().name()))
                .fulfilmentAddress(fulfilmentAddress)
                .build();

        orderRequest.getOrderItems().forEach(orderItemRequest -> {
            order.getOrderItems().add(OrderItemEntity.builder()
                    .category(Category.valueOf(orderItemRequest.getCategory().name()))
                    .price(orderItemRequest.getPrice())
                    .productCode(orderItemRequest.getProductCode())
                    .productName(orderItemRequest.getProductName())
                    .quantity(orderItemRequest.getQuantity())
                    .order(order)
                    .build());
        });

        return order;
    }

    public Order toOrder() {
        final var orderItems = this.orderItems.stream()
                .map(OrderItemEntity::toOrderItem)
                .toList();

        return Order.builder()
                .orderId(this.id)
                .user(User.builder()
                        .userId(user.getId())
                        .nameSurname(user.getNameSurname())
                        .email(user.getEmail())
                        .build())
                .status(OrderStatus.valueOf(status.name()))
                .orderItems(orderItems)
                .addressInfo(OrderAddress.builder()
                        .addressId(fulfilmentAddress.getId())
                        .address(fulfilmentAddress.getAddress())
                        .build())
                .build();
    }


}