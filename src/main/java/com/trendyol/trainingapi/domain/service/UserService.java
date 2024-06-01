package com.trendyol.trainingapi.domain.service;

import com.trendyol.trainingapi.application.port.in.UserUseCase;
import com.trendyol.trainingapi.application.port.out.UserPersistencePort;
import com.trendyol.trainingapi.application.annotation.UseCase;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import com.trendyol.trainingapi.infrastracture.rest.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@UseCase
@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserPersistencePort userPersistencePort;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserResponse> findUserByGivenCriteria(SearchCriteria searchCriteria) {
        final var users = userPersistencePort.findAll(searchCriteria);
        return users.stream().map(user -> UserResponse.builder()
                .userName(user.getUserName())
                .email(user.getEmail())
                .nameSurname(user.getNameSurname())
                .build()).collect(Collectors.toList());
    }

}
