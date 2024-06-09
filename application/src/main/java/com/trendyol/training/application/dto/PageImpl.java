package com.trendyol.training.application.dto;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PageImpl<T> {

    private final long total;

    private final List<T> content;

}
