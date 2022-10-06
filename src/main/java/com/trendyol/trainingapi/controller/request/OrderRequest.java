package com.trendyol.trainingapi.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
