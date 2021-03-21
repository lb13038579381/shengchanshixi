package com.csq.controller;

import com.csq.entity.Member;
import com.csq.entity.MeterialApply;
import com.csq.entity.PageData;
import com.csq.service.MeterialApplyService;
import com.csq.utils.DefaultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("meterialApplyController")
public class MeterialApplyController {
    @Autowired
    MeterialApplyService meterialApplyService;

    @RequestMapping("meterialApplyList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {
            pageData = DefaultUtils.getPageData(pageData);
            List<MeterialApply> meterialApplyList = meterialApplyService.getAllMeterialApply(pageData);
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(meterialApplyList.size());
            //设置当前页
            map.put("pageData", pageData);
            map.put("meterialApplyList", meterialApplyList);
            map.put("location", "meterialApplyList");
            return "meterialApply";
        } catch (Exception e) {
            e.printStackTrace();
            return "meterialApply";
        }
    }

    @RequestMapping("editMeterialApply")
    public String editMember(MeterialApply meterialApply, Map<String, Object> map) {
        try {
            meterialApplyService.editMeterialApply(meterialApply);
            map.put("result", "编辑成功");
            map.put("href","meterialApplyList");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            map.put("href","meterialApplyList");
            e.printStackTrace();
        }
        return "result";
    }

    @RequestMapping("deleteMeterialApplyById/{id}")
    public String deleteMeterialApplyById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            meterialApplyService.deleteMeterialApplyById(id);
            return "redirect:../meterialApplyList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../meterialApplyList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("addMeterialApply")
    public String addMeterialApply(MeterialApply meterialApply, Map<String, Object> map) {
        try {
            meterialApplyService.addMeterialApply(meterialApply);
            map.put("result","申请成功");
            map.put("href","index");
            return "result";
        } catch (Exception e) {
            map.put("result", "申请失败");
            map.put("href", "index");
            e.printStackTrace();
            return "result";
        }
    }


    @RequestMapping("getMeterialApplyById/{id}")
    public String getMeterialApplyById(@PathVariable("id") int id, Map<String, Object> map) {
        MeterialApply meterialApply = null;
        try {
            meterialApply = meterialApplyService.getMeterialApplyById(id);
            map.put("meterial_apply", meterialApply);
            return "memberApply_edit";
        } catch (Exception e) {
            map.put("error", "暂无信息");
            map.put("result", "查询失败");
            map.put("href", "../meterialApplyList");
            return "result";
        }
    }
    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = meterialApplyService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }
}
