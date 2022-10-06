package com.trendyol.trainingapi.domain;

import com.trendyol.trainingapi.common.model.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends AbstractEntity {

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