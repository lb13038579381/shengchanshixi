package com.csq.service;

import com.csq.entity.Meterial;
import com.csq.entity.MeterialApply;
import com.csq.entity.PageData;
import com.csq.entity.SupplierLevel;

import java.util.List;

public interface SupplierLevelService {
    List<SupplierLevel> getAllSupplierLevel(PageData pageData);

    Integer getCount();

    SupplierLevel getSupplierLevelById(int id);

    void editSupplierLevel(SupplierLevel supplierLevel);

    void deleteSupplierLevelById(int id);

    void addSupplierLevel(SupplierLevel supplierLevel);
}
