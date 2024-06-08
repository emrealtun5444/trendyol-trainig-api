package com.trendyol.training.infrastructure.redis.repository;

import com.trendyol.training.infrastructure.redis.entity.SessionInfoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface SessionInfoRepository extends CrudRepository<SessionInfoEntity, String> {
    Optional<SessionInfoEntity> findByUserName(String userName);
}


