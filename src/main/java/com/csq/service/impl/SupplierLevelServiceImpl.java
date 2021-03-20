package com.csq.service.impl;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.entity.SupplierLevel;
import com.csq.mapper.SupplierLevelMapper;
import com.csq.service.SupplierLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierLevelServiceImpl implements SupplierLevelService {
    @Autowired
    SupplierLevelMapper supplierLevelMapper;
    @Override
    public List<SupplierLevel> getAllSupplierLevel(PageData pageData) {
        return supplierLevelMapper.getAllSupplierLevel(pageData);
    }

    @Override
    public Integer getCount() {
        return supplierLevelMapper.getCount();
    }

    @Override
    public SupplierLevel getSupplierLevelById(int id) {
        return supplierLevelMapper.getSupplierLevelById(id);
    }

    @Override
    public void editSupplierLevel(SupplierLevel supplierLevel) {
        supplierLevelMapper.editSupplierLevel(supplierLevel);
    }

    @Override
    public void deleteSupplierLevelById(int id) {
        supplierLevelMapper.deleteSupplierLevelById(id);
    }

    @Override
    public void addSupplierLevel(SupplierLevel supplierLevel) {
        supplierLevelMapper.addSupplierLevel(supplierLevel);
    }
}
