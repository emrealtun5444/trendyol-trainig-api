package com.trendyol.trainingapi.infrastracture.persistence.repository;

import com.trendyol.trainingapi.infrastracture.persistence.entity.UserEntity;
import com.trendyol.trainingapi.infrastracture.rest.request.SearchCriteria;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

public class UserSpecification {
    public static Specification<UserEntity> withCriteria(SearchCriteria criteria) {
        return (root, query, builder) -> {
            switch (criteria.getOperation()) {
                case GREATER_THAN -> {
                    return builder.greaterThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                }
                case LESS_THAN -> {
                    return builder.lessThanOrEqualTo(
                            root.get(criteria.getKey()), criteria.getValue().toString());
                }
                case EQUALS -> {
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