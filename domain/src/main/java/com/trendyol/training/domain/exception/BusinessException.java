package com.trendyol.training.domain.exception;

public class BusinessException extends BaseTrendyolException {

    public BusinessException(String key, String... args) {
        super(key, args);
    }

}
