package com.sb.sysmanage.dao;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.sb.common.model.MenuPo;
import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;
import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tbmenu;
import com.sb.po.Tbuser;

@Repository
public class TbuserDao extends SP3BaseDao<Tbuser, String> {
    
	/**
	 * 查询
	 * @param parame
	 * @return
	 */
	public PageBean<Tbuser> findList(Map<String,String[]> parame){
		String sql = "From Tbuser Where 1=1 ";
		String csql = "Select count(*) From Tbuser Where 1=1 ";
		SqlBean sqlBean = this.createSQL(sql, csql, parame, null);
		PageBean<Tbuser> res = this.getH3DbManager().findList(sqlBean);
		return res;
	}
	/**
	 * 查询所以后台用户
	 * @return
	 */
	public List findAll(){
		String hql="From Tbuser where isactives=1";
		return this.getH3DbManager().findList(hql); 
	}
	
	public Tbuser findOneByLP(String lname,String password){
		Object[] parame={lname,password};
		String hql="From Tbuser where lname=? and password=?";
		return this.getH3DbManager().getOneObject(hql, parame);
	}
}
