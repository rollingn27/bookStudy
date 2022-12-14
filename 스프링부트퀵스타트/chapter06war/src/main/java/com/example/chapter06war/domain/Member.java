package com.example.chapter06war.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Member
{
    @Id
    private String id;
    private String password;
    private String name;
    private String role;
}
