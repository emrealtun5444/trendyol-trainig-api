package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.domain.valueobject.SessionInfo;

import java.util.Optional;

public interface SessionPort {

    SessionInfo save(SessionInfo sessionInfo);

    Optional<SessionInfo> findById(String id);

    Optional<SessionInfo> findByUserName(String userName);

    void deleteById(String id);

}
