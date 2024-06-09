package com.trendyol.training.domain.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddressModel {

    @NotEmpty(message = "address can not be empty")
    private String address;

}
