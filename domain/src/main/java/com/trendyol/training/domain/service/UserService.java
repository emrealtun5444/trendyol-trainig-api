package com.trendyol.training.domain.service;

import com.trendyol.training.application.annotation.UseCase;
import com.trendyol.training.application.port.in.UserUseCase;
import com.trendyol.training.application.port.out.UserPersistencePort;
import com.trendyol.training.infrastructure.rest.request.SearchCriteria;
import com.trendyol.training.infrastructure.rest.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserPersistencePort userPersistencePort;

    public List<UserResponse> findUserByGivenCriteria(List<SearchCriteria> criteriaList) {
        final var users = userPersistencePort.findAll(criteriaList);
        return users.stream().map(user -> UserResponse.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .nameSurname(user.getNameSurname())
                .build()).collect(Collectors.toList());
    }

}
