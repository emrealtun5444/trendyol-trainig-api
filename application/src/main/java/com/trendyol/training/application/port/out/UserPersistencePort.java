package com.trendyol.training.application.port.out;


import com.trendyol.training.domain.aggregate.User;
import com.trendyol.training.infrastructure.rest.request.SearchCriteria;

import java.util.List;

public interface UserPersistencePort {

    List<User> findAll(List<SearchCriteria> criteriaList);

}
