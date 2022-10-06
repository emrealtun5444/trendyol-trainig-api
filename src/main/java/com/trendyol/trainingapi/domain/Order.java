package com.trendyol.trainingapi.domain;

import com.trendyol.trainingapi.common.model.AbstractEntity;
import com.trendyol.trainingapi.controller.request.OrderRequest;
import com.trendyol.trainingapi.controller.request.OrderUpdateRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order extends AbstractEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "fulfilment_address_id")
    private FulfilmentAddress fulfilmentAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Builder.Default
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "order", cascade = CascadeType.PERSIST)
    @Fetch(FetchMode.SUBSELECT)
    private Set<OrderItem> orderItems = new LinkedHashSet<>();

    public static Order create(OrderRequest orderRequest) {

        final var fulfilmentAddress = FulfilmentAddress.builder()
                .address(orderRequest.getAddressInfo().getAddress())
                .build();

        final var order = Order.builder()
                .user(new User(orderRequest.getUserId()))
                .status(Status.valueOf(orderRequest.getStatus()))
                .fulfilmentAddress(fulfilmentAddress)
                .build();

        orderRequest.getOrderItems().forEach(orderItemRequest -> {
            order.getOrderItems().add(OrderItem.builder()
                    .category(Category.valueOf(orderItemRequest.getCategory()))
                    .price(orderItemRequest.getPrice())
                    .productCode(orderItemRequest.getProductCode())
                    .productName(orderItemRequest.getProductName())
                    .quantity(orderItemRequest.getQuantity())
                    .order(order)
                    .build());
        });

        return order;
    }

    public void update(OrderUpdateRequest orderUpdateRequest) {
        this.status = Status.valueOf(orderUpdateRequest.getStatus());
    }

}