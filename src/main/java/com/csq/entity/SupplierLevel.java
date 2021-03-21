package com.csq.entity;

import lombok.Data;

@Data
public class SupplierLevel {
    int id;
    int supplierId;
    String time;
    Character level;
    String remarks;
}
