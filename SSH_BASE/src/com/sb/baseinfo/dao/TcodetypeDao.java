package com.sb.baseinfo.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;
import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tcodetype;

@Repository
public class TcodetypeDao extends SP3BaseDao<Tcodetype, String> {
    
	/**
	 * 查询
	 * @param parame
	 * @return
	 */
	public PageBean<Tcodetype> findList(Map<String,String[]> parame){
		String sql = "From Tcodetype Where 1=1 ";
		String csql = "Select count(*) From Tcodetype Where 1=1 ";
		SqlBean sqlBean = this.createSQL(sql, csql, parame, null);
		PageBean<Tcodetype> res = this.getH3DbManager().findList(sqlBean);
		return res;
	}
	
	
}
