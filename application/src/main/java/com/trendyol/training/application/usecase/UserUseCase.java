package com.trendyol.training.application.usecase;

import com.trendyol.training.application.searchcriteria.SearchCriteria;
import com.trendyol.training.application.dto.UserResponse;

import java.util.List;

public interface UserUseCase {

    List<UserResponse> findUserByGivenCriteria(List<SearchCriteria> criteriaList);

}
