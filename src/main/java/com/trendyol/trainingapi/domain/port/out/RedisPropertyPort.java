package com.trendyol.trainingapi.domain.port.out;


import com.trendyol.trainingapi.domain.entity.SessionInfo;

import java.util.Optional;

public interface RedisPropertyPort {

    Integer getSessionInfoTTL();

}
