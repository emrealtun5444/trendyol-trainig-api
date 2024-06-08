package com.trendyol.training.infrastructure.redis.entity;

import com.trendyol.training.domain.valueobject.SessionInfo;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RedisHash("SessionInfo")
public class SessionInfoEntity {

    @Id
    private String id;

    @Indexed
    private String userName;
    private String name;
    private String surname;
    private String email;

    @TimeToLive
    private Long expiration;

    public static SessionInfoEntity create(SessionInfo sessionInfo) {
        return SessionInfoEntity.builder()
                .id(sessionInfo.getId())
                .userName(sessionInfo.getUserName())
                .email(sessionInfo.getEmail())
                .name(sessionInfo.getName())
                .surname(sessionInfo.getSurname())
                .expiration(sessionInfo.getExpiration())
                .build();
    }

    public SessionInfo toSessionInfo() {
        return SessionInfo.builder()
                .id(id)
                .userName(userName)
                .name(name)
                .surname(surname)
                .email(email)
                .expiration(expiration)
                .build();
    }
}
