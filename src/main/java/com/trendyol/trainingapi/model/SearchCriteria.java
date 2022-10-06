package com.trendyol.trainingapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class SearchCriteria {

    @NotEmpty(message = "key can not be empty")
    private String key;

    @NotEmpty(message = "operation can not be empty")
    private String operation;

    @NotNull(message = "value can not be empty")
    private Object value;
}
