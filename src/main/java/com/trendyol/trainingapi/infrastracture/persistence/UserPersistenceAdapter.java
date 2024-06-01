package com.trendyol.trainingapi.infrastracture.persistence;

import com.trendyol.trainingapi.domain.aggregate.User;
import com.trendyol.trainingapi.application.port.out.UserPersistencePort;
import com.trendyol.trainingapi.application.annotation.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.entity.UserEntity;
import com.trendyol.trainingapi.infrastracture.persistence.repository.UserRepository;
import com.trendyol.trainingapi.infrastracture.persistence.repository.UserSpecification;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Adapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll(List<SearchCriteria> criteriaList) {
        Specification<UserEntity> spec = Specification.where(null);
        for (SearchCriteria criteria : criteriaList) {
            spec = spec.and(UserSpecification.withCriteria(criteria));
        }
        return userRepository.findAll(spec).stream().map(UserEntity::toUser).collect(Collectors.toList());
    }
}
