package com.sb.core.action;

import java.io.Serializable;

public interface IBaseAction<T,PK extends Serializable> {

	/**
	 * 初始进入页面
	 * @return
	 */
	public String  redirect();
	
	
	
	
}
