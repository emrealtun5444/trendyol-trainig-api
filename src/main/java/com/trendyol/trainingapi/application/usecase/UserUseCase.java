package com.trendyol.trainingapi.application.usecase;

import com.trendyol.trainingapi.application.searchcriteria.SearchCriteria;
import com.trendyol.trainingapi.application.dto.response.UserResponse;

import java.util.List;

public interface UserUseCase {

    List<UserResponse> findUserByGivenCriteria(List<SearchCriteria> criteriaList);

}
