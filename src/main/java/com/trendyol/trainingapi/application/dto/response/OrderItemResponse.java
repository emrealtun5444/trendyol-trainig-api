package com.trendyol.trainingapi.application.dto.response;

import com.trendyol.trainingapi.infrastracture.persistence.entity.enm.Category;
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

    public OrderItemResponse(String productCode, String productName, Category category, Integer quantity, BigDecimal price) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category.name();
        this.quantity = quantity;
        this.price = price;
    }
}
