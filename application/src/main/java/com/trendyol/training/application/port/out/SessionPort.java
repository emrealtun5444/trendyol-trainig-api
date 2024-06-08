package com.trendyol.training.application.port.out;


import com.trendyol.training.domain.valueobject.SessionInfo;

import java.util.Optional;

public interface SessionPort {

    SessionInfo save(SessionInfo sessionInfo);

    Optional<SessionInfo> findById(String id);

    Optional<SessionInfo> findByUserName(String userName);

    void deleteById(String id);

}
