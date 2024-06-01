package com.trendyol.trainingapi.domain.service;

import com.trendyol.trainingapi.application.annotation.UseCase;
import com.trendyol.trainingapi.application.port.in.UserUseCase;
import com.trendyol.trainingapi.application.port.out.UserPersistencePort;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import com.trendyol.trainingapi.infrastracture.rest.response.UserResponse;
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
