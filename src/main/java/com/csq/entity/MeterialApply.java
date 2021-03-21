package com.csq.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MeterialApply {
    Long id;
    String name;
    Integer count;
    Long departmentId;
    Long time;
    BigDecimal price;
    String remarks;
}
