package com.sb.core.db;

import java.io.Serializable;
import java.util.List;

import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;


/**
 * 
 * 日期：2014-03-11
 * 功能：数据库操作接口
 * @author Administrator
 *
 * @param <T>
 */
public interface IHDbManager<T,PK extends Serializable>  {

	/**
	 * 保存对象
	 * @param entities
	 * @return
	 */
	public  T saveEntity(T entities) ;
	
	/**
	 * 传入的参数，
	 * 在数据库中没有会新增，
	 * 存在就修改该数据
	 * @param t
	 * @return
	 */
	public  T mergeEntity(T t) ;
	
	/**
	 * 更新接口
	 * @param entities
	 * @return
	 */
	public  T updateEntity(T entities)  ;
	
	/**
	 * 通过HQL更新数据
	 * @param sql
	 * @param parame
	 * @return
	 */
	public  int updateForHql(String sql,Object...parame) ;
	
	
	/**
	 * 删除对象
	 * @param classzz
	 * @param id  对象ID
	 */
	public  void  deleteEntity(Class<?> classzz,Serializable id) ;
	

	
	/**
	 * 通过参数删除对象
	 * @param sql
	 * @param parame
	 */
	public  int  deleteEntityByParame(String sql,Object[]  parame) ;
	/**
	 * 取得实体对象,通过get方法
	 * @param classzz
	 * @param id
	 * @return
	 */
	public  T  getEntityById(Class<?> classzz,Serializable id) ;
	
	/**
	 * 取得实体对象，通过LOAD方法
	 * @param classzz
	 * @param id
	 * @return
	 */
	public  T  loadEntityById(Class<?> classzz,Serializable id) ;
	
	
	/**
	 * 取得单个对象，带参数
	 * @param sql
	 * @param parame 要查询的参数
	 * @return
	 */
	public  T  getOneObject(String sql,Object[] parame) ;
	
	
	/**
	 * 获取单个对象的值
	 * @param sql
	 * @param parame
	 * @return
	 */
	public Object geOneObject1(String sql,Object[] parame);
	
	/**
	 * 查找对象，不带查询参数
	 * @param hql 要查询的SQL
	 * @return
	 */
	public  List<T> findList(String  hql) ;
	
	/**
	 * 查找对象，不带查询参数
	 * @param hql 要查询的SQL
	 * @return
	 */
	public  List<T> findList(String  hql,Object[] parame1)  ;
	
	/**
	 * 查找列表，带查询参数
	 * @param hql  查询的SQL语句
	 * @param sortCol 排序列
	 * @param parame1 查询参数
	 * @return
	 */
	public  List<T> findList(String  hql,String[] sortCol,Object ...parame1) ;
	
	
	/**
	 * 分页查询
	 * @param hql 
	 * @param firstResult  开始条数
	 * @param maxcount  最大条数
	 * @param sortCol  排序列
	 * @param parame   查询参数
	 * @return
	 * @
	 */
	public  List<T> findList(String hql,int firstResult,int maxcount,String[] sortCol,Object...parame) ;
	
	
	/**
	 * 判断是否为空
	 * @param entityClass
	 * @param id
	 * @return
	 * @
	 */
	public Boolean isEmpty(Class<T> entityClass,Serializable id) ;
	
	
	/**
	 * 分页
	 * @param chql 查询记录数的SQL
	 * @param sql  查询数据的SQL
	 * @param sortCol 排序的SQL
	 * @param curentPage 当前页号
	 * @param pageSize  当前页记录数
	 * @param parame
	 * @return
	 */
	public PageBean<T>  findList(String chql,String sql,int curentPage,int pageSize,String[] sortCol,Object...parame);
	
	public  List<T> findList(String  hql,List parame);
	
	public T getOneObject(String hql, List parame) ;
	
	public List<?> findList(String hql,final int firstResult,final int maxcount,
			final Object... parame);
	
	public PageBean<T> findList(SqlBean sqlBean);
	
	/**
	 * 删除
	 * @param sns
	 * @param EmptyName
	 */
	public void delete(String sns,String EmptyName);
	
	
}
