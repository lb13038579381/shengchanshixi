package com.csq.service;

import com.csq.entity.Achievement;
import com.csq.entity.PageData;

import java.util.List;

public interface AchievementService {
    List<Achievement> getAllAchievement(PageData pageData);

    Integer getCount();

    Achievement getAchievementById(int id);

    void editAchievement(Achievement achievement);

    void deleteAchievementById(int id);

    void addAchievement(Achievement achievement);
}
