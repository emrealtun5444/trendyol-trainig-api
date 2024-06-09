package com.trendyol.training.infrastructure.redis;

import com.trendyol.training.infrastructure.redis.entity.SessionInfoEntity;
import com.trendyol.training.infrastructure.redis.repository.SessionInfoRepository;
import com.trendyol.training.domain.valueobject.SessionInfo;
import com.trendyol.training.application.port.out.SessionPort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class SessionRedisAdapter implements SessionPort {

    private final SessionInfoRepository repository;


    @Override
    public SessionInfo save(SessionInfo sessionInfo) {
        return repository.save(SessionInfoEntity.create(sessionInfo)).toSessionInfo();
    }

    @Override
    public Optional<SessionInfo> findById(String id) {
        return repository.findById(id).map(SessionInfoEntity::toSessionInfo);
    }

    @Override
    public Optional<SessionInfo> findByUserName(String userName) {
        return repository.findByUserName(userName).map(SessionInfoEntity::toSessionInfo);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }
}
