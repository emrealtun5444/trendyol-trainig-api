package com.trendyol.training.domain.valueobject;

import lombok.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SessionInfo {

    private String id;
    private String userName;
    private String name;
    private String surname;
    private String email;
    private Long expiration;

    public void updateTTL(Long ttl) {
        this.expiration = ttl;
    }

}
