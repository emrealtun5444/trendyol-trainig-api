package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.domain.aggregate.User;
import com.trendyol.trainingapi.application.searchcriteria.SearchCriteria;

import java.util.List;

public interface UserPersistencePort {

    List<User> findAll(List<SearchCriteria> criteriaList);

}
