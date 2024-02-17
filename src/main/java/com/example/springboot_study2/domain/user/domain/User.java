package com.example.springboot_study2.domain.user.domain;

import global.entity.BaseIdEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User extends BaseIdEntity {

    @Column(name = "accountId", length = 20, nullable = false)
    private String accountId;

    @Column(name = "password", length = 20, nullable = false)
    private String password;

    @Column(name = "name", length = 5, nullable = false)
    private String name;
}