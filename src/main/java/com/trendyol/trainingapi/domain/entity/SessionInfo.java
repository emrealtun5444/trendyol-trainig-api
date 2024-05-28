package com.trendyol.trainingapi.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

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
