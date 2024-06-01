package com.trendyol.trainingapi.application.port.in;

import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import com.trendyol.trainingapi.infrastracture.rest.response.UserResponse;

import java.util.List;

public interface UserUseCase {

    List<UserResponse> findUserByGivenCriteria(List<SearchCriteria> criteriaList);

}
