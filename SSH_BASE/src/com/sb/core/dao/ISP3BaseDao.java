package com.sb.core.dao;

import java.io.Serializable;

import org.springframework.stereotype.Service;


@Service
public interface ISP3BaseDao<T,PK extends Serializable> {
    
	
	/**
	 * 添加
	 * @param t
	 * @return
	 * @
	 */
	public  T save(T t) ;
	
	/**
	 * 修改
	 * @param t
	 * @return
	 * @
	 */
	public  T update(T t) ;
	
	/**
	 * 获取数据
	 * @param t
	 * @return
	 * @
	 */
	public  T getEntity(Class<?> t,Serializable id) ;
	
	
	public  T loadEntity(Class<?>  classzz,Serializable id) ;
	
	
	
}
 