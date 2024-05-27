package com.trendyol.trainingapi.infrastracture.common.exception;

public class BusinessException extends BaseTrendyolException {

    public BusinessException(String key, String... args) {
        super(key, args);
    }

}
