package com.trendyol.trainingapi.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    private Long orderItemId;
    private ItemCategory category;
    private String productCode;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
}
