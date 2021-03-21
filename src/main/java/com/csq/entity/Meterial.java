package com.csq.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Meterial {
    Long id;
    String name;
    Integer count;
    String category;
    BigDecimal price;
    String remarks;
}
