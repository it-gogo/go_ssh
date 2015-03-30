package com.sb.sysmanage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tauthority;

@Repository
public class TauthorityDao extends SP3BaseDao<Tauthority, String> {
    
	/**
	 * 保存权限
	 * @param roleid
	 * @param menuids
	 */
	public void saveAuth(String roleid,String menuids){
		String hql="delete Tauthority where roleid=?";
		Object[] parame={roleid};
		this.getH3DbManager().deleteEntityByParame(hql, parame);
		String[] arr=menuids.split(",");
		for(int i=0;i<arr.length;i++){
			Tauthority po=new Tauthority(); 
			po.setMenuid(arr[i].trim());
			po.setRoleid(roleid);
			this.getH3DbManager().saveEntity(po);
		}
	}
	/**
	 * 查询所以权限
	 * @return
	 */
	public List findAll(String roleid){
		Object[] parame={roleid};
		String hql="select menuid From Tauthority where roleid=?";
		return this.getH3DbManager().findList(hql,parame);
	}
	
	
}
