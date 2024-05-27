package com.trendyol.trainingapi.infrastracture.common.exception.model;


import com.trendyol.trainingapi.infrastracture.common.interceptor.InterceptorConstants;
import com.trendyol.trainingapi.infrastracture.common.utils.ToStringBuilder;
import lombok.*;
import org.slf4j.MDC;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
    private String exception;
    private Long timestamp = System.currentTimeMillis();
    private List<ErrorDetailResponse> errors = new ArrayList<>();
    private String correlationId = MDC.get(InterceptorConstants.X_CORRELATION_ID);

    public ErrorResponse(String exception) {
        this.exception = exception;
    }

    public void addError(ErrorDetailResponse errorDetailDTO) {
        errors.add(errorDetailDTO);
    }

    @Override
    public String toString() {
        ToStringBuilder stringBuilder = new ToStringBuilder();
        return stringBuilder.init("ErrorResponse")
                .append("correlationId", correlationId)
                .append("timestamp", timestamp)
                .append("exception", exception)
                .append("errors", errors)
                .toString();
    }
}
