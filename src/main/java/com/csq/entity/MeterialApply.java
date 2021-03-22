package com.csq.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MeterialApply {
    Long id;
    String name;
    Integer count;
    String department;
    String time;
    BigDecimal price;
    String remarks;
    String category;
}
