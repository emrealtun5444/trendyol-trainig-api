package com.trendyol.trainingapi.domain.aggregate;

import com.trendyol.trainingapi.application.annotation.Aggregate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Builder
@Getter
@Aggregate
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long userId;
    private String userName;
    private String email;
    private String nameSurname;

}
