package com.trendyol.trainingapi.domain.port.out;


import com.trendyol.trainingapi.domain.entity.User;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;

import java.util.List;

public interface UserPersistencePort {

    List<User> findAll(SearchCriteria searchCriteria);

}
