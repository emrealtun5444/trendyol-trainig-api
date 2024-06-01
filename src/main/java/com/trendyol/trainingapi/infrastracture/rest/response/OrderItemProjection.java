package com.trendyol.trainingapi.infrastracture.rest.response;

import com.trendyol.trainingapi.infrastracture.persistence.entity.enm.Category;
import com.trendyol.trainingapi.infrastracture.persistence.entity.enm.Status;

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
