package com.test.entity;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "user", schema = "user_service")
public class User {
    @Id
    private Integer id;
    private String username;
    private String password;
    private String salt;
}
