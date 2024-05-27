package com.trendyol.trainingapi.infrastracture.rest;


import com.trendyol.trainingapi.domain.port.in.UserUseCase;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import com.trendyol.trainingapi.infrastracture.rest.response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/user")
@Slf4j
public class UserController {

    private final UserUseCase userUseCase;

    @PostMapping("search")
    public ResponseEntity<List<UserResponse>> save(@RequestBody @Valid SearchCriteria searchCriteria) {
        return ResponseEntity.ok(userUseCase.findUserByGivenCriteria(searchCriteria));
    }

}
