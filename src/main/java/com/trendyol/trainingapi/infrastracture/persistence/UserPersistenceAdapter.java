package com.trendyol.trainingapi.infrastracture.persistence;

import com.trendyol.trainingapi.domain.entity.User;
import com.trendyol.trainingapi.domain.port.out.UserPersistencePort;
import com.trendyol.trainingapi.infrastracture.common.Adapter;
import com.trendyol.trainingapi.infrastracture.persistence.entity.UserEntity;
import com.trendyol.trainingapi.infrastracture.persistence.repository.UserRepository;
import com.trendyol.trainingapi.infrastracture.persistence.repository.UserSpecification;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Adapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPersistencePort {

    private final UserRepository orderRepository;

    @Override
    public List<User> findAll(SearchCriteria searchCriteria) {
        final var spec = UserSpecification.builder().criteria(searchCriteria).build();
        return orderRepository.findAll(spec).stream().map(UserEntity::toUser).collect(Collectors.toList());
    }
}
