package com.csq.service.impl;

import com.csq.entity.Achievement;
import com.csq.entity.PageData;
import com.csq.mapper.AchievementMapper;
import com.csq.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements AchievementService {
    @Autowired
    AchievementMapper achievementMapper;

    List<Achievement> achievementList(PageData pageData) {
        return achievementMapper.getAllAchievement(pageData);
    }

    @Override
    public List<Achievement> getAllAchievement(PageData pageData) {
        return achievementMapper.getAllAchievement(pageData);
    }

    @Override
    public Integer getCount() {
        return achievementMapper.getCount();
    }

    @Override
    public Achievement getAchievementById(int id) {
        return achievementMapper.getAchievementById(id);
    }

    @Override
    public void editAchievement(Achievement achievement) {
        achievementMapper.editAchievement(achievement);
    }

    @Override
    public void deleteAchievementById(int id) {
        achievementMapper.deleteAchievementById(id);
    }

    @Override
    public void addAchievement(Achievement achievement) {
        achievementMapper.addAchievement(achievement);
    }
}
