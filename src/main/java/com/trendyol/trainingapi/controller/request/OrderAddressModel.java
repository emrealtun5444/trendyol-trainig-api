package com.trendyol.trainingapi.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderAddressModel {

    @NotEmpty(message = "address can not be empty")
    private String address;

}
