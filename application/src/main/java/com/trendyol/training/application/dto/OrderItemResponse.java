package com.trendyol.training.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemResponse {

    private String productCode;
    private String productName;
    private String category;
    private Integer quantity;
    private BigDecimal price;

}
