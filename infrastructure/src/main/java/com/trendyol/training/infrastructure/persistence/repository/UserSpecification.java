package com.trendyol.training.infrastructure.persistence.repository;

import com.trendyol.training.infrastructure.common.enm.SearchOperation;
import com.trendyol.training.domain.model.request.SearchCriteria;
import com.trendyol.training.infrastructure.persistence.entity.UserEntity;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<UserEntity> withCriteria(SearchCriteria criteria) {
        return (root, query, builder) -> {
            switch (criteria.getOperation()) {
                case SearchOperation.GREATER_THAN -> {
                    return builder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                }
                case SearchOperation.LESS_THAN -> {
                    return builder.lessThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                }
                case SearchOperation.EQUALS -> {
                    if (root.get(criteria.getKey()).getJavaType() == String.class) {
                        return builder.like(
                                root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                    } else {
                        return builder.equal(root.get(criteria.getKey()), criteria.getValue());
                    }
                }
                default -> {
                    return null;
                }
            }
        };
    }
}