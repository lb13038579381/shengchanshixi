package com.csq.entity;

import lombok.Data;

@Data
public class Member {
    Long id;
    String name;
    String phoneNumber;
    String password;
    String sex;
    String department;
}
