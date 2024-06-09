package com.trendyol.training.domain.exception;

import com.trendyol.training.domain.exception.BaseTrendyolException;

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
