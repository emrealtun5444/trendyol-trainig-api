package com.trendyol.training.application.port.in;

import com.trendyol.training.infrastructure.rest.request.SearchCriteria;
import com.trendyol.training.infrastructure.rest.response.UserResponse;

import java.util.List;

public interface UserUseCase {

    List<UserResponse> findUserByGivenCriteria(List<SearchCriteria> criteriaList);

}
