package com.trendyol.training.domain.exception;

import com.trendyol.training.domain.exception.BaseTrendyolException;
import lombok.Getter;

@Getter
public class SessionIdNotFoundException extends BaseTrendyolException {

    private final static String DEFAULT_ERROR_KEY = "editor.session.id.not.found";

    public SessionIdNotFoundException() {
        super(DEFAULT_ERROR_KEY);
    }

    @Override
    public String getKey() {
        return super.getKey();
    }

}
