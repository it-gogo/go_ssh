package com.sb.common.model;


public class SqlBean {

	private String  listsql;
	
	private String  countsql;
	
	//当前页
	private int curPage=1;
	
	//每页数量
	private int rows=15;
	
	private Object[]  parameVAL;


	public String getListsql() {
		return listsql;
	}

	public void setListsql(String listsql) {
		this.listsql = listsql;
	}

	public String getCountsql() {
		return countsql;
	}

	public void setCountsql(String countsql) {
		this.countsql = countsql;
	}

	

	public Object[] getParameVAL() {
		return parameVAL;
	}

	public void setParameVAL(Object[] parameVAL) {
		this.parameVAL = parameVAL;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	
	
	
	
}
