package com.sb.baseinfo.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;
import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tcodedata;

@Repository
public class TcodedataDao extends SP3BaseDao<Tcodedata, String> {
    
	/**
	 * 查询
	 * @param parame
	 * @return
	 */
	public PageBean findList(Map<String,String[]> parame){
		String sql = "select new map (id as id,cname as cname,isactives as isactives,a.type.tname as tname ) From Tcodedata as a  Where 1=1 ";
		String csql = "Select count(*) From Tcodedata Where 1=1 ";
		SqlBean sqlBean = this.createSQL(sql, csql, parame, null);
		PageBean res = this.getH3DbManager().findList(sqlBean);
		return res;
	}
	
	
}
