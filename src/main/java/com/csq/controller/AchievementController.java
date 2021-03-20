package com.csq.controller;

import com.csq.entity.Achievement;
import com.csq.entity.Member;
import com.csq.entity.PageData;
import com.csq.service.AchievementService;
import com.csq.utils.DefaultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("achievementController")
public class AchievementController {
    @Autowired
    AchievementService achievementService;
    @RequestMapping("achievementList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {
            pageData = DefaultUtils.getPageData(pageData);
            List<Achievement> achievementList = achievementService.getAllAchievement(pageData);
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(achievementList.size());
            //设置当前页
            map.put("pageData", pageData);
            map.put("meterialList", achievementList);
            map.put("location", "achievementList");
            return "achievement";
        } catch (Exception e) {
            e.printStackTrace();
            return "achievement";
        }
    }

    @RequestMapping("editAchievement")
    public String editAchievement(Achievement achievement, Map<String, Object> map) {
        try {
            achievementService.editAchievement(achievement);
            map.put("result", "编辑成功");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            e.printStackTrace();
        }
        return "result";
    }

    @RequestMapping("deleteAchievementById/{id}")
    public String deleteMemberById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            achievementService.deleteAchievementById(id);
            return "redirect:../achievementList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../achievementList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("addAchievement")
    public String addMember(Achievement achievement, Map<String, Object> map) {
        try {
            achievementService.addAchievement(achievement);
            return "redirect:../achievementList";
        } catch (Exception e) {
            map.put("result", "增加失败");
            map.put("href", "../achievementList");
            e.printStackTrace();
            return "result";
        }
    }
    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = achievementService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }
}
