package com.trendyol.trainingapi.infrastracture.configuration;


import com.trendyol.trainingapi.infrastracture.interceptor.RestLoggingInterceptor;
import com.trendyol.trainingapi.infrastracture.interceptor.TracingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfiguration implements WebMvcConfigurer {

    private final RestLoggingInterceptor restLoggingInterceptor;
    private final TracingInterceptor tracingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tracingInterceptor).addPathPatterns("/**").order(1);
        registry.addInterceptor(restLoggingInterceptor).addPathPatterns("/**").order(2);
    }

}
