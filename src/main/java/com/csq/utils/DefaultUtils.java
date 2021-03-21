package com.csq.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.csq.entity.PageData;

public class DefaultUtils {
	
	//校车列表的分页数默认为10页
	public static int schoolBuslimit = 10;

	public static PageData defaultPageData() {
		PageData pageData = new PageData();
		pageData.setCount(0);
		pageData.setPages(0);
		pageData.setCurrentPage(0);
		pageData.setLimit(0);
		pageData.setStartPage(0);
		pageData.setNext(0);
		pageData.setPrev(0);
		pageData.setRefresh(0);
		pageData.setSkip(0);
		return pageData;
	}

	public static PageData getPageData(PageData pageData) {
		if(pageData.getLimit() == 0) {//
			pageData.setCurrentPage(1);
			pageData.setLimit(schoolBuslimit);
		}
		//设置分页的开始查询数
		int startPage = (pageData.getCurrentPage() - 1) * pageData.getLimit();
		pageData.setStartPage(startPage);
		return pageData;
	}
	
	
	@SuppressWarnings("rawtypes")
	public static Map<Object, Object> getSelectSuccessMap(Map<Object, Object> map, List list, PageData pageData, String location){
		//Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("objList", list);
		map.put("pageData", pageData);
		map.put("location", location);
		return map;
	}
	
	
	public static Map<Object, Object> getSelectErrorMap(Map<Object, Object> map, String location){
//		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("result", "查询错误");
		map.put("href", location);
		return map;
	}


}
