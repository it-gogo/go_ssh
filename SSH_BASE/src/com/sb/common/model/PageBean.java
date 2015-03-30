package com.sb.common.model;

import java.util.List;

/**
 * 
 * 2014-03-12
 * 分页实体类
 * @author Administrator
 *
 * @param <T>
 */
public class PageBean<T> {
    
	//存储记录数
	private  List<?> list = null;
	
	//总记录数
	private int  allRow;
	
	//总页数
	private int  totalPage;
	
	//当前页号
	private int  curentPage=1;
	
	//每页记录数
	private int  pageSize = 20;
	
	//是否第一页
	private boolean  isFirstPage;
	
	//是否最后一页
	private boolean  isLastPage;

	//是否还有前一页
	private boolean  hasPreviousPage;
	
	//是否还有后一页
	private boolean  hasNextPage;

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		if(totalPage==0){
			totalPage=1;
		}
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurentPage() {
		return curentPage;
	}

	public void setCurentPage(int curentPage) {
		this.curentPage = curentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 是否是第一页
	 * @return
	 */
	public boolean isFirstPage() {
		return (this.curentPage==1);
	}

	public void setFirstPage(boolean isFirstPage) {
		this.isFirstPage = isFirstPage;
	}

	/**
	 * 判断是否是最后一页
	 * @return
	 */
	public boolean isLastPage() {
		return (curentPage == totalPage);
	}

	public void setLastPage(boolean isLastPage) {
		this.isLastPage = isLastPage;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isHasPreviousPage() {
		return (this.curentPage!=1);
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return (this.curentPage<totalPage);
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
	/**
	 * 初始化
	 */
	public void initPage(){
		this.isFirstPage = this.isFirstPage();
		this.isLastPage = this.isLastPage();
		this.hasNextPage = this.isHasNextPage();
		this.hasPreviousPage = this.isHasPreviousPage();
		
	}
	
	
	
	/**
	 * 计算总页数
	 * @return
	 */
	public int countTotalPage(){
	    totalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize+1; 
		return totalPage; 
	}
	
	/**
	 * 取得开始记录
	 * @return
	 */
	public int getFirstResult(){
		return  (curentPage-1)*pageSize;
	}
	
	
	
}
