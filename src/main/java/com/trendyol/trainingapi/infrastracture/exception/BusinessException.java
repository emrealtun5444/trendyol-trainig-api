package com.trendyol.trainingapi.infrastracture.exception;

public class BusinessException extends BaseTrendyolException {

    public BusinessException(String key, String... args) {
        super(key, args);
    }

}
