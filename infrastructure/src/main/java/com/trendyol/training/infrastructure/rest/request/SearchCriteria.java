package com.trendyol.training.infrastructure.rest.request;

import com.trendyol.training.infrastructure.common.enm.SearchOperation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SearchCriteria {

    @NotEmpty(message = "key can not be empty")
    private String key;

    @NotEmpty(message = "operation can not be empty")
    private SearchOperation operation;

    @NotNull(message = "value can not be empty")
    private Object value;

}
