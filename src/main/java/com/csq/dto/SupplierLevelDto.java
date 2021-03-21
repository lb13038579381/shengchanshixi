package com.csq.dto;

import lombok.Data;

@Data
public class SupplierLevelDto {
    int id;
    String name;
    Long time;
    Character level;
    String remarks;
}
