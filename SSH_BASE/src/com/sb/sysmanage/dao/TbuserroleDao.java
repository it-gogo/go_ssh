package com.sb.sysmanage.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tauthority;
import com.sb.po.Tbuserrole;

@Repository
public class TbuserroleDao extends SP3BaseDao<Tbuserrole, String> {
    
	/**
	 * 保存权限
	 * @param roleid
	 * @param menuids
	 */
	public void bindUser(String roleid,String buserids){
		String hql="delete Tbuserrole where roleid=?";
		Object[] parame={roleid};
		this.getH3DbManager().deleteEntityByParame(hql, parame);
		if(buserids==null || "".equals(buserids)){
			return;
		}
		String[] arr=buserids.split(",");
		for(int i=0;i<arr.length;i++){
			Tbuserrole po=new Tbuserrole(); 
			po.setBuserid(arr[i].trim());
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
		String hql="select buserid From Tbuserrole where roleid=?";
		return this.getH3DbManager().findList(hql,parame);
	}
	
	
}
