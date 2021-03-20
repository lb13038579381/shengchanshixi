package com.csq.mapper;

import com.csq.entity.PageData;
import com.csq.entity.SupplierLevel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierLevelMapper {
    List<SupplierLevel> getAllSupplierLevel(PageData pageData);

    Integer getCount();

    SupplierLevel getSupplierLevelById(int id);

    void editSupplierLevel(SupplierLevel supplierLevel);

    void deleteSupplierLevelById(int id);

    void addSupplierLevel(SupplierLevel supplierLevel);
}
