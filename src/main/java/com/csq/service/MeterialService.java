package com.csq.service;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;

import java.util.List;

public interface MeterialService {
    List<Meterial> getAllMeterial(PageData pageData);

    Integer getCount();

    Meterial getMeterialById(int id);

    void editMeterial(Meterial meterial);

    void deleteMeterialById(int id);

    void addMeterial(Meterial meterial);
}
