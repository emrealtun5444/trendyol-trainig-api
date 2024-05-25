package com.trendyol.trainingapi.controller;


import com.trendyol.trainingapi.controller.response.UserResponse;
import com.trendyol.trainingapi.model.SearchCriteria;
import com.trendyol.trainingapi.service.UserService;
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

    private final UserService userService;

    @PostMapping("search")
    public ResponseEntity<List<UserResponse>> save(@RequestBody @Valid SearchCriteria searchCriteria) {
        return ResponseEntity.ok(userService.findUserByGivenCriteria(searchCriteria));
    }

}
