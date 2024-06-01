package com.trendyol.trainingapi.infrastracture.persistence.entity;

import com.trendyol.trainingapi.domain.aggregate.User;
import com.trendyol.trainingapi.infrastracture.persistence.entity.common.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    public UserEntity(Long id) {
        this.setId(id);
    }

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "email")
    private String email;

    public User toUser() {
        return User.builder()
                .userId(id)
                .userName(userName)
                .nameSurname(nameSurname)
                .email(email)
                .build();
    }

}