package com.trendyol.training.infrastructure.persistence.repository;

import com.trendyol.training.infrastructure.persistence.entity.FulfilmentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FulfilmentAddressRepository extends JpaRepository<FulfilmentAddressEntity, Long> {
}