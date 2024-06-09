package com.trendyol.trainingapi.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String userName;

    private String nameSurname;

    private String email;

}
