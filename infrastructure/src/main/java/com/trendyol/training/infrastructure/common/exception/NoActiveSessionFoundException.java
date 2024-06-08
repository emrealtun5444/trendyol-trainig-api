package com.trendyol.training.infrastructure.common.exception;

public class NoActiveSessionFoundException extends BaseTrendyolException {
    private final static String DEFAULT_ERROR_KEY = "no.active.session.found";

    public NoActiveSessionFoundException() {
        super(DEFAULT_ERROR_KEY);
    }

    @Override
    public String getKey() {
        return super.getKey();
    }
}
