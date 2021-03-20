package com.csq.service.impl;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.mapper.MeterialMapper;
import com.csq.service.MeterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterialServiceImpl implements MeterialService {
    @Autowired
    MeterialMapper meterialMapper;
    @Override
    public List<Meterial> getAllMeterial(PageData pageData) {
        return meterialMapper.getAllMeterial(pageData);
    }

    @Override
    public Integer getCount() {
        return meterialMapper.getCount();
    }

    @Override
    public Meterial getMeterialById(int id) {
        return meterialMapper.getMeterialById(id);
    }

    @Override
    public void editMeterial(Meterial meterial) {
        meterialMapper.editMeterial(meterial);
    }

    @Override
    public void deleteMeterialById(int id) {
        meterialMapper.deleteMeterialById(id);
    }

    @Override
    public void addMeterial(Meterial meterial) {
        meterialMapper.addMeterial(meterial);
    }
}
