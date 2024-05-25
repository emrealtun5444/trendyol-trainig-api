package com.trendyol.trainingapi.domain;

import com.trendyol.trainingapi.common.model.AbstractEntity;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_gen")
    @SequenceGenerator(name = "users_id_gen", sequenceName = "users_id_seq", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;

    public User(Long id) {
        this.setId(id);
    }

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name_surname")
    private String nameSurname;

    @Column(name = "email")
    private String email;



}