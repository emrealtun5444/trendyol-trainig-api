package com.trendyol.trainingapi.infrastracture.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Component
@Slf4j
public class TracingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        extractCorrelationId(request);
        return true;
    }

    private void extractCorrelationId(HttpServletRequest request) {
        String correlationId = request.getHeader(InterceptorConstants.X_CORRELATION_ID);
        if (StringUtils.isEmpty(StringUtils.trim(correlationId))) {
            MDC.put(InterceptorConstants.X_CORRELATION_ID, UUID.randomUUID().toString());
        } else {
            MDC.put(InterceptorConstants.X_CORRELATION_ID, correlationId);
        }
    }
}
