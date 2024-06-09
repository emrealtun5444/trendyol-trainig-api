package com.trendyol.trainingapi.application.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateRequest {

    @NotEmpty(message = "status can not be empty")
    private String status;

}
