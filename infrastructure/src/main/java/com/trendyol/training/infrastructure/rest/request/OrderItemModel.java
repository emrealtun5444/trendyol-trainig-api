package com.trendyol.training.infrastructure.rest.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemModel {

    @NotEmpty(message = "productCode can not be empty")
    private String productCode;

    @NotEmpty(message = "productName can not be empty")
    private String productName;

    @NotEmpty(message = "category can not be empty")
    @Pattern(regexp = "^(HOME|ELECTRONIC)$", message = "invalid category")
    private String category;

    @NotEmpty(message = "quantity can not be empty")
    private Integer quantity;

    private BigDecimal price;

}
