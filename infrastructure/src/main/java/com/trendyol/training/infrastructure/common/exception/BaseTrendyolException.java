package com.trendyol.training.infrastructure.common.exception;


import lombok.Getter;

@Getter
public class BaseTrendyolException extends RuntimeException {

    private final String key;
    private final String[] args;

    public BaseTrendyolException(String key, String... args) {
        this.key = key;
        this.args = args;
    }

    @Override
    public String getMessage() {
        return "Exception occurred " + key;
    }

}
