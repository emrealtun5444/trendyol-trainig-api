package com.trendyol.trainingapi.infrastracture.property;

import com.trendyol.trainingapi.application.port.out.RedisPropertyPort;
import com.trendyol.trainingapi.application.annotation.Adapter;
import com.trendyol.trainingapi.infrastracture.common.property.RedisConfigProperties;
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
