package com.csq.mapper;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MeterialMapper {
    List<Meterial> getAllMeterial(PageData pageData);

    Integer getCount();

    Meterial getMeterialById(int id);

    void editMeterial(Meterial meterial);

    void deleteMeterialById(int id);

    void addMeterial(Meterial meterial);
}
