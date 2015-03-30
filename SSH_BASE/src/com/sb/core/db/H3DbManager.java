package com.sb.core.db;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sb.common.SqlConstant;
import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;


/**
 * 陈永楠
 * 日期：2014-03-11
 * 功能：通过HIBERNATE3实现数据操作接口
 * @author Administrator
 * @param <T>
 */
public class H3DbManager<T,PK extends Serializable>  implements IHDbManager<T,PK> {

	
	private Class<?> entityClass;
	
	@Resource
	protected SessionFactory  sessionFactory;
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getSession(){
		Session s;
		try {
			s=this.getSessionFactory().getCurrentSession();
			//设置不自动更新
//			s.setFlushMode(FlushMode.COMMIT);
		} catch (HibernateException e) {
			//e.printStackTrace();
			s=this.getSessionFactory().openSession();
		}
		return s;
//		return this.getSessionFactory().getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public H3DbManager(){
		this.entityClass = null;
        Class<?> c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class<T>) parameterizedType[0];
        }
	}


	@Override
	public T saveEntity(T entities) {
		this.getSession().save(entities);
		return entities;
	}
	
	@Override
	public T mergeEntity(T t)   {
		this.getSession().merge(t);
		return t;
	}

	@Override
	public T updateEntity(T entities)  {
		this.getSession().update(entities);
		return entities;
	}

	@Override
	public int updateForHql(String hql, Object... parame)  {
		Session session=getSession().getSessionFactory().getCurrentSession();
		Query q=session.createQuery(hql);
		if(parame!=null&&parame.length!=0){
			for(int i=0;i<parame.length;i++){
				q.setParameter(i,parame[i]);
			}
		}
		int result = q.executeUpdate();
		return result;
	}

	/**
	 * 删除对象
	 */
	@Override
	public void deleteEntity(Class<?> classzz, Serializable id) {
		T  t  = this.getEntityById(classzz, id);
		this.getSession().delete(t);
	}

	

	/**
	 * 通过HQL删除
	 */
	@Override
	public int deleteEntityByParame(String hql, Object[] parame){
		return this.updateForHql(hql, parame);
		
	}

	@Override
	public  T getEntityById(Class<?> classzz, Serializable id){
		@SuppressWarnings("unchecked")
		T t = (T)this.getSession().get(classzz, id);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T loadEntityById(Class<?> classzz, Serializable id)  {
		// TODO Auto-generated method stub
		T t = (T)this.getSession().load(classzz, id);
		return t;
	}

	
    /**
     * 取得单独对象
     */
	@Override
	public T getOneObject(String hql, Object[] parame)  {
		// TODO Auto-generated method stub
		List<T> list = this.findList(hql, parame);
		T t = null;
		if(list!=null&&list.size()>0){
			t = list.get(0);
		}
		return t;
	}
	
	/**
     * 取得单独对象
     */
	@Override
	public T getOneObject(String hql, List parame)  {
		// TODO Auto-generated method stub
		List<T> list = this.findList(hql, parame);
		T t = null;
		if(list!=null&&list.size()>0){
			t = list.get(0);
		}
		return t;
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public  List<T> findList(String  hql,Object[] parame) {
		return this.find(hql,parame);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public  List<T> findList(String  hql,List parame) {
		return this.find(hql,parame);
	}

	/**
	 * 查询列表
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(String hql)  {
		return this.find(hql);
	}
	
	/**
	 * 创建ORDERBY信息
	 * @param sortCol
	 * @return
	 */
	private  StringBuffer  createOrder(String[] sortCol) {
		if(sortCol==null || sortCol.length==0){
			return null;
		}
		StringBuffer  orderBuff = new StringBuffer("");
		if(sortCol!=null&&sortCol.length>0){
			orderBuff.append(SqlConstant.ORDERBY_CHAR);
			for(int i=0;i<sortCol.length;i++){
				orderBuff.append(sortCol[i]);
				if(i==sortCol.length-1){
				}else{
					orderBuff.append(",");
				}
			}

		}
		return orderBuff;
	}
	
	/**
	 * 封装find函数
	 * @param hql
	 * @param parame1
	 * @return
	 */
	private List<T> find(String hql,Object...parame1){
		Session  s = this.getSession();
		Query  q = s.createQuery(hql);
		if(parame1!=null){
			for(int i=0;i<parame1.length;i++){
				q.setParameter(i,parame1[i]);
			}
		}
		List<T> list = q.list();
		return list;
	}

	/**
	 * 通过参数查询
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findList(String hql, String[] sortCol, Object... parame){
		    StringBuffer  hqlbuff = new StringBuffer(hql);
		    StringBuffer  orderBuff = this.createOrder(sortCol);
		    if(orderBuff!=null&&orderBuff.length()>0){
		      hqlbuff.append(orderBuff);
		    }
			return  this.find(hqlbuff.toString(),parame);
	}


	@Override
	public Boolean isEmpty(Class<T> entityClass, Serializable id){
		T t = this.getEntityById(entityClass, id);
		if(t==null) return true;
		return false;
	}


	/**
	 * 分页查询
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findList(String hql,final int firstResult,final int maxcount,
			String[] sortCol,final Object... parame)  {
		final StringBuffer orderBuff = this.createOrder(sortCol);
		final StringBuffer hqlbuff = new StringBuffer(hql);
		Session session = this.getSession();
//		@SuppressWarnings("unchecked")
//		List<T> list = super.getHibernateTemplate().execute(new HibernateCallback(){
//			 public Object doInHibernate(Session session) throws HibernateException,SQLException{
		 if(orderBuff!=null&&orderBuff.length()>0){
			 hqlbuff.append(orderBuff);
		 }
		 Query query = session.createQuery(hqlbuff.toString());
		 query.setFirstResult(firstResult);
		 query.setMaxResults(maxcount);
		 for(int i=0;parame!=null && i<parame.length;i++){
			 query.setParameter(i, parame[i]);
		 }
		 List<T>  list = query.list();
		 return list;
//			 }
//		});
	}
	
	/**
	 * 分页查询
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public List<T> findList(String hql,final int firstResult,final int maxcount,
		final Object... parame)  {
		//final StringBuffer orderBuff = this.createOrder(sortCol);
		final StringBuffer hqlbuff = new StringBuffer(hql);
		Session session = this.getSession();
		 Query query = session.createQuery(hqlbuff.toString());
		 query.setFirstResult(firstResult);
		 query.setMaxResults(maxcount);
		 for(int i=0;parame!=null && i<parame.length;i++){
			 query.setParameter(i, parame[i]);
		 }
		 List<T>  list = query.list();
		 return list;
//			 }
//		});
	}
	
	

	/**
	 * 分页，返回分页对象
	 */
	@Override
	public PageBean<T> findList(String chql, String hql, int curentPage,
			int pageSize, String[] sortCol, Object... parame) {
		PageBean<T>  pvo = new PageBean<T>();
		//总记录数
		Long  rowTotal = (Long)this.getOneObject(chql, parame);
		if(rowTotal==null){
			rowTotal=0L;
		}
		//设置当前页
		pvo.setCurentPage(curentPage);
		//设置页面大小
		pvo.setPageSize(pageSize);
		//设置总记录数
		pvo.setAllRow(rowTotal.intValue());
		//计算总页数
		pvo.countTotalPage();
		//初始化信息，是否有上一页，下一页
		pvo.initPage();
		//获取开始记录数
		int firstResult = pvo.getFirstResult();
		List<T> list = this.findList(hql, firstResult, pageSize, sortCol, parame);
		pvo.setList(list);
		return pvo;
	}
	
	/**
	 * 分页，返回分页对象
	 */
	@Override
	public PageBean<T> findList(SqlBean sqlBean) {
		String hql = sqlBean.getListsql();
		String chql = sqlBean.getCountsql();
		Object[] parame = sqlBean.getParameVAL();
		PageBean<T>  pvo = new PageBean<T>();
		//总记录数
		Long  rowTotal = (Long)this.getOneObject(chql, parame);
		if(rowTotal==null){
			rowTotal=0L;
		}
		//当前记录数
		int curPage = sqlBean.getCurPage();
		//页面记录数
		int pageSize = sqlBean.getRows();
		//设置当前页
		pvo.setCurentPage(curPage);
		//设置页面大小
		pvo.setPageSize(pageSize);
		//设置总记录数
		pvo.setAllRow(rowTotal.intValue());
		//计算总页数
		pvo.countTotalPage();
		//初始化信息，是否有上一页，下一页
		pvo.initPage();
		//获取开始记录数
		int firstResult = pvo.getFirstResult();
		List<?> list = this.findList(hql, firstResult, pageSize,parame);
		pvo.setList(list);
		return pvo;
	}

	/**
	 * 删除
	 * @param sns
	 */
	@Override
	public void delete(String sns, String EmptyName) {
		// TODO Auto-generated method stub
		if(sns==null){
			return;
		}
		String[] arr=sns.split(",");
		StringBuffer hql=new StringBuffer("delete "+EmptyName+" where id in ( ");
		Object[] parame=new Object[arr.length];
		for(int j=0;j<arr.length;j++){
			String id=arr[j];
			id=id.trim();
//			Integer i=Integer.valueOf(id);
			parame[j]=id;
			if(j!=arr.length-1){
				hql.append(" ?, ");
			}else{
				hql.append("? )");
			}
		}
		//Object[] parame={sns};
		this.deleteEntityByParame(hql.toString(), parame);
	}

	@Override
	public Object geOneObject1(String hql, Object[] parame) {
		List<T> list = this.findList(hql, parame);
		Object t = null;
		if(list!=null&&list.size()>0){
			t = (Object)list.get(0);
		}
		return t;
	}

	
	
	
	

}
