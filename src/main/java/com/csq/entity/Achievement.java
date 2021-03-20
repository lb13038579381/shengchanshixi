package com.csq.entity;

import lombok.Data;

@Data
public class Achievement {
    Long id;
    Long memberId;
    Long departmentId;
    Character level;
}
