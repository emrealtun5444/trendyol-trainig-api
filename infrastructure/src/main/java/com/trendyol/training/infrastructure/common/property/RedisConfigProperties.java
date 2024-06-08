package com.trendyol.training.infrastructure.common.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "redis")
public class RedisConfigProperties {

    private Integer expirationTimeMinute;
    private Integer sessionInfoTTL;

}
