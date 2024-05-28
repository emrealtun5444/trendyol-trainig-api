package com.trendyol.trainingapi.infrastracture.redis.repository;

import com.trendyol.trainingapi.infrastracture.redis.entity.SessionInfoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SessionInfoRepository extends CrudRepository<SessionInfoEntity, String> {
    Optional<SessionInfoEntity> findByUserName(String userName);
}


