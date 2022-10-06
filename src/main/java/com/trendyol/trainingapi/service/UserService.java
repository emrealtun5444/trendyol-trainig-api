package com.trendyol.trainingapi.service;

import com.trendyol.trainingapi.controller.response.UserResponse;
import com.trendyol.trainingapi.model.SearchCriteria;
import com.trendyol.trainingapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<UserResponse> findUserByGivenCriteria(SearchCriteria searchCriteria) {
        final var spec = UserSpecification.builder().criteria(searchCriteria).build();
        final var users = userRepository.findAll(spec);
        return users.stream().map(user -> {
            return UserResponse.builder()
                    .userName(user.getUserName())
                    .email(user.getEmail())
                    .nameSurname(user.getNameSurname())
                    .build();
        }).collect(Collectors.toList());
    }

}
