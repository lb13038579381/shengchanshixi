package com.csq.entity;

import lombok.Data;

@Data
public class SupplierLevel {
    Long id;
    Long supplierId;
    Long time;
    Character level;
    String remarks;
}
