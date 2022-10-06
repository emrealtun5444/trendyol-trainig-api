package com.trendyol.trainingapi.controller.response;

import com.trendyol.trainingapi.domain.Category;
import com.trendyol.trainingapi.domain.Status;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderItemInfo {
    Date getCreatedDate();

    Category getCategory();

    String getProductCode();

    String getProductName();

    BigDecimal getPrice();

    Integer getQuantity();

    OrderInfo getOrder();

    interface OrderInfo {
        Status getStatus();
    }
}
