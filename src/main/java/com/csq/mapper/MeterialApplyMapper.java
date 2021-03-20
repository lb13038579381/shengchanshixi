package com.csq.mapper;

import com.csq.entity.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterialApplyMapper {
    List<MeterialApply> getAllMeterialApply(PageData pageData);

    Integer getCount();

    MeterialApply getMeterialApplyById(int id);

    void editMeterialApply(MeterialApply meterialApply);

    void deleteMeterialApplyById(int id);

    void addMeterialApply(MeterialApply meterialApply);
}
