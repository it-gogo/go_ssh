package com.sb.webmanage.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;
import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tcarousel;

@Repository
public class TcarouselDao extends SP3BaseDao<Tcarousel, String> {
    
	/**
	 * 查询
	 * @param parame
	 * @return
	 */
	public PageBean<Tcarousel> findList(Map<String,String[]> parame){
		String sql = "From Tcarousel Where 1=1 ";
		String csql = "Select count(*) From Tcarousel Where 1=1 ";
		SqlBean sqlBean = this.createSQL(sql, csql, parame, null);
		PageBean<Tcarousel> res = this.getH3DbManager().findList(sqlBean);
		return res;
	}
	
	public List<Tcarousel> findAll(){
		String hql="From Tcarousel where isactives=1 ";
		return this.getH3DbManager().findList(hql);
	}
}
