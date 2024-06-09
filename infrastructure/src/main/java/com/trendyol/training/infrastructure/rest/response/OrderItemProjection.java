package com.trendyol.training.infrastructure.rest.response;

import com.trendyol.training.infrastructure.persistence.entity.enm.Category;
import com.trendyol.training.infrastructure.persistence.entity.enm.Status;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderItemProjection {
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
