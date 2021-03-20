package com.csq.service.impl;

import com.csq.entity.Meterial;
import com.csq.entity.MeterialApply;
import com.csq.entity.PageData;
import com.csq.mapper.MeterialApplyMapper;
import com.csq.service.MeterialApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeterialApplyServiceImpl implements MeterialApplyService {
    @Autowired
    MeterialApplyMapper meterialApplyMapper;

    @Override
    public List<MeterialApply> getAllMeterialApply(PageData pageData) {
        return meterialApplyMapper.getAllMeterialApply(pageData);
    }

    @Override
    public Integer getCount() {
        return meterialApplyMapper.getCount();
    }

    @Override
    public MeterialApply getMeterialApplyById(int id) {
        return meterialApplyMapper.getMeterialApplyById(id);
    }

    @Override
    public void editMeterialApply(MeterialApply meterialApply) {
        meterialApplyMapper.editMeterialApply(meterialApply);
    }

    @Override
    public void deleteMeterialApplyById(int id) {
        meterialApplyMapper.deleteMeterialApplyById(id);
    }

    @Override
    public void addMeterialApply(MeterialApply meterialApply) {
        meterialApplyMapper.addMeterialApply(meterialApply);
    }
}
