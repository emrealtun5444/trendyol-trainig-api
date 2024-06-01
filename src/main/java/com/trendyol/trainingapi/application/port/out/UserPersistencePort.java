package com.trendyol.trainingapi.application.port.out;


import com.trendyol.trainingapi.domain.aggregate.User;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;

import java.util.List;

public interface UserPersistencePort {

    List<User> findAll(SearchCriteria searchCriteria);

}
