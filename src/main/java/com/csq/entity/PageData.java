package com.csq.entity;

/**
 * 分页参数
 * @author 123
 *'count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip'
 */
public class PageData {
	private int count;//总页数
	private int currentPage;//当前页
	private int prev;//上一页
	private int pages;//显示页数
	private int next;//下一页
	private int limit;//分页数
	private int refresh;//刷新
	private int skip;//确定
	private int startPage ;
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrev() {
		return prev;
	}
	public void setPrev(int prev) {
		this.prev = prev;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getNext() {
		return next;
	}
	public void setNext(int next) {
		this.next = next;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public int getRefresh() {
		return refresh;
	}
	public void setRefresh(int refresh) {
		this.refresh = refresh;
	}
	public int getSkip() {
		return skip;
	}
	public void setSkip(int skip) {
		this.skip = skip;
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		
		this.currentPage = currentPage;
	}
	@Override
	public String toString() {
		return "PageData [count=" + count + ", currentPage=" + currentPage + ", prev=" + prev + ", pages=" + pages
				+ ", next=" + next + ", limit=" + limit + ", refresh=" + refresh + ", skip=" + skip + ", startPage="
				+ startPage + "]";
	}
	
	
	

}
