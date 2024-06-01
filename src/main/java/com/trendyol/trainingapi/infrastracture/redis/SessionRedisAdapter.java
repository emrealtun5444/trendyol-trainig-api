package com.trendyol.trainingapi.infrastracture.redis;

import com.trendyol.trainingapi.domain.valueobject.SessionInfo;
import com.trendyol.trainingapi.application.port.out.SessionPort;
import com.trendyol.trainingapi.application.annotation.Adapter;
import com.trendyol.trainingapi.infrastracture.redis.entity.SessionInfoEntity;
import com.trendyol.trainingapi.infrastracture.redis.repository.SessionInfoRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Adapter
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
