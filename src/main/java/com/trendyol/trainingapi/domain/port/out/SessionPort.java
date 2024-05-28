package com.trendyol.trainingapi.domain.port.out;


import com.trendyol.trainingapi.domain.entity.SessionInfo;
import com.trendyol.trainingapi.infrastracture.redis.entity.SessionInfoEntity;

import java.util.Optional;

public interface SessionPort {

    SessionInfo save(SessionInfo sessionInfo);

    Optional<SessionInfo> findById(String id);

    Optional<SessionInfo> findByUserName(String userName);

    void deleteById(String id);

}
