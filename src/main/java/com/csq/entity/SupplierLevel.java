package com.csq.entity;

import lombok.Data;

@Data
public class SupplierLevel {
    int id;
    int supplierId;
    Long time;
    Character level;
    String remarks;
}
