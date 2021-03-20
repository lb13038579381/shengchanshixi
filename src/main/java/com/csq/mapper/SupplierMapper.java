package com.csq.mapper;

import com.csq.entity.PageData;
import com.csq.entity.Supplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SupplierMapper {
    List<Supplier> getAllSupplier(PageData pageData);

    Integer getCount();

    Supplier getSupplierById(int id);

    void editSupplier(Supplier supplier);

    void deleteSupplierById(int id);

    void addSupplier(Supplier supplier);
}
