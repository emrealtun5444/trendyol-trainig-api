package com.trendyol.training.infrastructure.property;

import com.trendyol.training.application.port.out.RedisPropertyPort;
import com.trendyol.training.application.annotation.Adapter;
import com.trendyol.training.infrastructure.common.property.RedisConfigProperties;
import lombok.RequiredArgsConstructor;

@Adapter
@RequiredArgsConstructor
public class RedisPropertyAdapter implements RedisPropertyPort {

    private final RedisConfigProperties redisConfigProperties;


    @Override
    public Integer getSessionInfoTTL() {
        return redisConfigProperties.getSessionInfoTTL();
    }
}
