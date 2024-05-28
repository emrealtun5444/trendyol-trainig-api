package com.trendyol.trainingapi.infrastracture.redis;

import com.trendyol.trainingapi.domain.entity.SessionInfo;
import com.trendyol.trainingapi.domain.entity.User;
import com.trendyol.trainingapi.domain.port.out.SessionPort;
import com.trendyol.trainingapi.domain.port.out.UserPersistencePort;
import com.trendyol.trainingapi.infrastracture.common.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.entity.UserEntity;
import com.trendyol.trainingapi.infrastracture.persistence.repository.UserRepository;
import com.trendyol.trainingapi.infrastracture.persistence.repository.UserSpecification;
import com.trendyol.trainingapi.infrastracture.redis.entity.SessionInfoEntity;
import com.trendyol.trainingapi.infrastracture.redis.repository.SessionInfoRepository;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
