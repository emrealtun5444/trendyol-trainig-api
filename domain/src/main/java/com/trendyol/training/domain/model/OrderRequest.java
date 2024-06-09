package com.trendyol.training.domain.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @NotNull(message = "user can not be empty")
    private Long userId;

    @NotEmpty(message = "status can not be empty")
    @Pattern(regexp = "^(CREATED|SHIPPED|DELIVERED)$", message = "invalid status")
    private String status;

    private OrderAddressModel addressInfo;

    private List<OrderItemModel> orderItems;

}
