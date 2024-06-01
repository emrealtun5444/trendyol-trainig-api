package com.trendyol.trainingapi.infrastracture.common.enm;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchOperation {
    GREATER_THAN(">"),
    LESS_THAN("<"),
    EQUALS(":");

    private final String operation;

}