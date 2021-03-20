package com.csq.mapper;

import com.csq.entity.Achievement;
import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AchievementMapper {
    List<Achievement> getAllAchievement(PageData pageData);

    Integer getCount();

    Achievement getAchievementById(int id);

    void editAchievement(Achievement achievement);

    void deleteAchievementById(int id);

    void addAchievement(Achievement achievement);
}
