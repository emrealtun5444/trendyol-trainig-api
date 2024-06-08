package com.trendyol.training.infrastructure.common.configuration;

import com.trendyol.training.infrastructure.common.interceptor.InterceptorConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        filter.setHeaderPredicate(header -> header.equals(InterceptorConstants.X_CORRELATION_ID));
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }
}
