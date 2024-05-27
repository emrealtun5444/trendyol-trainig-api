package com.trendyol.trainingapi.infrastracture.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.util.Enumeration;

@Component
@RequiredArgsConstructor
@Slf4j
public class RestLoggingInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);
        String queryString = extractStringIfNotNull(requestWrapper.getQueryString());

        log.info("Completed request type: {}, Url: {}, Caller: {}, QueryString: {}, Response status: {}",
                requestWrapper.getMethod(),
                requestWrapper.getRequestURI(),
                requestWrapper.getRemoteHost(),
                queryString,
                responseWrapper.getStatus());
    }

    private String prepareHeaders(HttpServletRequest request) {
        StringBuilder headers = new StringBuilder("Request Headers: ");
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            headers.append(headerName).append(": ").append(headerValue).append(", ");
        }
        return headers.toString();
    }

    private String extractStringIfNotNull(String input) {
        return StringUtils.isEmpty(input) ? "" : input;
    }
}
