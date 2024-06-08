package com.trendyol.training.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SessionInfoCreateModel {

    private String userName;
    private String name;
    private String surname;
    private String email;

}
