package com.csq.service.impl;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.entity.Supplier;
import com.csq.mapper.SupplierMapper;
import com.csq.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierMapper supplierMapper;
    @Override
    public List<Supplier> getAllSupplier(PageData pageData) {
        return supplierMapper.getAllSupplier(pageData);
    }

    @Override
    public Integer getCount() {
        return supplierMapper.getCount();
    }

    @Override
    public Supplier getSupplierById(int id) {
        return supplierMapper.getSupplierById(id);
    }

    @Override
    public void editSupplier(Supplier supplier) {
        supplierMapper.editSupplier(supplier);
    }

    @Override
    public void deleteSupplierById(int id) {
        supplierMapper.deleteSupplierById(id);
    }

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }
}
