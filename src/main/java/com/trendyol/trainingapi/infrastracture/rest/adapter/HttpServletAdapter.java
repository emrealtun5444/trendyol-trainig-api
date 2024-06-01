package com.trendyol.trainingapi.infrastracture.rest.adapter;

import com.trendyol.trainingapi.application.port.out.HttpServletPort;
import com.trendyol.trainingapi.application.annotation.Adapter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class HttpServletAdapter implements HttpServletPort {

    private final HttpServletRequest request;

    @Override
    public String getHeader(String header) {
        return request.getHeader(header);
    }
}
