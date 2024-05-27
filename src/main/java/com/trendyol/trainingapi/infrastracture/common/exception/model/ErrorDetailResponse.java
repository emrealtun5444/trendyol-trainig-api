package com.trendyol.trainingapi.infrastracture.common.exception.model;

import com.trendyol.trainingapi.infrastracture.common.utils.ToStringBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetailResponse {

    private String key;
    private String message;

    @Override
    public String toString() {
        ToStringBuilder stringBuilder = new ToStringBuilder();
        return stringBuilder.init("ErrorDetailResponse")
                .append("key", key)
                .append("message", message)
                .toString();
    }
}
