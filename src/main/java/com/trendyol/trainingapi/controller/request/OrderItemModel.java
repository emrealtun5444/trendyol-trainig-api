package com.trendyol.trainingapi.controller.request;

import com.trendyol.trainingapi.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
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

    public OrderItemModel(String productCode, String productName, Category category, Integer quantity, BigDecimal price) {
        this.productCode = productCode;
        this.productName = productName;
        this.category = category.name();
        this.quantity = quantity;
        this.price = price;
    }
}
