package com.csq.service;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.entity.Supplier;
import com.csq.entity.SupplierLevel;

import java.util.List;

public interface SupplierService {
    List<Supplier> getAllSupplier(PageData pageData);

    Integer getCount();

    Supplier getSupplierById(int id);

    void editSupplier(Supplier supplier);

    void deleteSupplierById(int id);

    void addSupplier(Supplier supplier);
}
