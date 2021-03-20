package com.csq.service;

import com.csq.entity.*;

import java.util.List;

public interface MeterialApplyService {
    List<MeterialApply> getAllMeterialApply(PageData pageData);

    Integer getCount();

    MeterialApply getMeterialApplyById(int id);

    void editMeterialApply(MeterialApply meterialApply);

    void deleteMeterialApplyById(int id);

    void addMeterialApply(MeterialApply meterialApply);
}
