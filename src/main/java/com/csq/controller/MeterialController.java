package com.csq.controller;

import com.csq.entity.Meterial;
import com.csq.entity.PageData;
import com.csq.service.MeterialService;
import com.csq.utils.DefaultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("meterialController")
public class MeterialController {

    @Autowired
    MeterialService meterialService;

    @RequestMapping("meterialList")
    public String getAll(PageData pageData, Map<String, Object> map) {
        try {

            pageData = DefaultUtils.getPageData(pageData);
            List<Meterial> meterialList = meterialService.getAllMeterial(pageData);
            //得到总页数
            int pages = getPages(pageData.getLimit());
            pageData.setPages(pages);
            //得到当前页的总条数
            pageData.setCount(meterialList.size());
            //设置当前页
//			pageData.setCurrentPage(pageData.getCurrentPage());
            map.put("pageData", pageData);
            map.put("meterialList", meterialList);
//			System.err.println("schoolbusList:" + schoolbusList);
            map.put("location", "meterialList");
            return "meterial";
        } catch (Exception e) {
            e.printStackTrace();
            return "meterial";
        }
    }

    @RequestMapping("getMeterialById/{id}")
    public String getMeterialById(@PathVariable("id") int id, Map<String, Object> map) {
        Meterial meterial = null;
        try {
            meterial = meterialService.getMeterialById(id);
            map.put("meterial", meterial);
            return "meterial_edit";
        } catch (Exception e) {
            map.put("error", "暂无信息");
            map.put("result", "查询失败");
            map.put("href", "../selectSchoolBusList");
            return "result";
        }
    }

    @RequestMapping("addMeterialPre")
    public String addMeterialPre() {
        return "add_meterial";
    }

    @RequestMapping("editMeterial")
    public String editMeterial(Meterial meterial, Map<String, Object> map) {
        try {
            meterialService.editMeterial(meterial);
            map.put("result", "编辑成功");
            map.put("href", "meterialList");
        } catch (Exception e) {
            map.put("result", "编辑失败");
            map.put("href", "meterialList");
            e.printStackTrace();
        }
        return "result";
    }

    @RequestMapping("deleteMeterialById/{id}")
    public String deleteMeterialById(@PathVariable("id") int id, Map<String, Object> map) {
        try {
            meterialService.deleteMeterialById(id);
            map.put("result", "删除成功");
            return "redirect:../meterialList";
        } catch (Exception e) {
            map.put("result", "删除失败");
            map.put("href", "../meterialList");
            e.printStackTrace();
            return "result";
        }
    }

    @RequestMapping("applyMeterial")
    public String applyMeterial() {
        return "meterialApply";
    }

    @RequestMapping("addMeterial")
    public String addMeterial(Meterial meterial, Map<String, Object> map) {
        try {
            meterialService.addMeterial(meterial);
            map.put("result", "增加成功");
            map.put("href", "meterialList");
            return "redirect:meterialList";
        } catch (Exception e) {
            map.put("result", "新增失败");
            map.put("href", "meterialList");
            e.printStackTrace();
        }
        return "result";
    }

    private int getPages(int limit) {
        if (limit == 0) {
            limit = 10;
        }
        int count = meterialService.getCount();
        int pages = count / limit;
        if (count % limit != 0) {
            pages++;
        }
        return pages;
    }
}
