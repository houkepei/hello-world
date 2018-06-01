package com.houkp.recommended.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_order")
public class User {
    private String username;
    private int age;
}
