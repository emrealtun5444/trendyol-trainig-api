package com.trendyol.trainingapi.infrastracture.rest.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderUserModel {

    private String nameSurname;

    private String email;

}
