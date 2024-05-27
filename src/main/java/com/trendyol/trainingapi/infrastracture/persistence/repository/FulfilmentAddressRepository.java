package com.trendyol.trainingapi.infrastracture.persistence.repository;

import com.trendyol.trainingapi.infrastracture.persistence.entity.FulfilmentAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FulfilmentAddressRepository extends JpaRepository<FulfilmentAddressEntity, Long> {
}