package com.trendyol.training.infrastructure.persistence;


import com.trendyol.training.application.annotation.Adapter;
import com.trendyol.training.application.port.out.UserPersistencePort;
import com.trendyol.training.domain.aggregate.User;
import com.trendyol.training.infrastructure.persistence.entity.UserEntity;
import com.trendyol.training.infrastructure.persistence.repository.UserRepository;
import com.trendyol.training.infrastructure.persistence.repository.UserSpecification;
import com.trendyol.training.domain.model.request.SearchCriteria;
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
