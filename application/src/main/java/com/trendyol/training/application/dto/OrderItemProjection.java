package com.trendyol.training.application.dto;


import java.math.BigDecimal;
import java.util.Date;

public interface OrderItemProjection {
    Date getCreatedDate();

    String getCategory();

    String getProductCode();

    String getProductName();

    BigDecimal getPrice();

    Integer getQuantity();

    OrderInfo getOrder();

    interface OrderInfo {
        String getStatus();
    }

}
