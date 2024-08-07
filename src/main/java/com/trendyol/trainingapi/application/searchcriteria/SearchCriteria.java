package com.trendyol.trainingapi.application.searchcriteria;

import com.trendyol.trainingapi.infrastracture.common.enm.SearchOperation;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SearchCriteria {

    @NotEmpty(message = "key can not be empty")
    private String key;

    private SearchOperation operation;

    @NotNull(message = "value can not be empty")
    private Object value;

}
