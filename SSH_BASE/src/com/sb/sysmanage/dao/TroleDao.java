package com.sb.sysmanage.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;
import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tbuser;
import com.sb.po.Trole;

@Repository
public class TroleDao extends SP3BaseDao<Trole, String> {
    
	/**
	 * 查询
	 * @param parame
	 * @return
	 */
	public PageBean findList(Map<String,String[]> parame){
		String sql = "Select new map (id as id,rname as rname,isactives as isactives,(select lname from Tbuser where id=creator) as lname) From Trole Where 1=1 ";
		String csql = "Select count(*) From Trole Where 1=1 ";
		SqlBean sqlBean = this.createSQL(sql, csql, parame, null);
		PageBean res = this.getH3DbManager().findList(sqlBean);
		return res;
	}
	
	
}
