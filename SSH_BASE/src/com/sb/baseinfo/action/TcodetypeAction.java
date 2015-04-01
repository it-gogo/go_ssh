package com.sb.baseinfo.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.sb.baseinfo.dao.TcodetypeDao;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.Util;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tcodetype;
/**
 * 数据类型
 * @author Administrator
 *
 */
@Controller("codetypeAction")
@ParentPackage("baseinfo")
@Scope("prototype")
public class TcodetypeAction extends ST2BaseAction<Tcodetype, String> {

	private Tcodetype  vo = new Tcodetype();
	
	@Resource
	private TcodetypeDao  codetypeDao;
	


	public Tcodetype getVo() {
		return vo;
	}



	public void setVo(Tcodetype vo) {
		this.vo = vo;
	}


	public TcodetypeDao getCodetypeDao() {
		return codetypeDao;
	}



	public void setCodetypeDao(TcodetypeDao codetypeDao) {
		this.codetypeDao = codetypeDao;
	}



	/**
     * 查询集合
     * @return
     */
	public String findList(){
		ContextUtil.removeSessionVal("searchparame");
		Map<String,String[]>  parame = ContextUtil.getHttpParame();
		this.setPageBean(codetypeDao.findList(parame));
		this.setPageUrl("codetypeAction!findList.action");
		return "list";
	}
	/**
     * 查询集合
     * @return
     */
	public String searchList(){
		parame = ContextUtil.getHttpParame();
		Map<String,String[]>  map=new HashMap<String,String[]>(parame);
		if(parame.containsKey("curPage")){
			parame=(Map<String, String[]>) ContextUtil.getHttpSessionVal("searchparame");
		}else{
			ContextUtil.setHttpSessionVal("searchparame", map);
		}
		this.setPageBean(codetypeDao.findList(parame));
		this.setPageUrl("codetypeAction!searchList.action");
		return "list";
	}
	/**
	 * 去添加页面
	 * @return
	 */
	public String  addxx(){
		return "edit";
	}
	/**
	 * 去修改页面
	 * @return
	 */
	public String updatexx(){
		vo=codetypeDao.getEntity(vo.getClass(), this.getId());
		return "edit";
	}
	/**
	 * 保存
	 * @return
	 */
	public String savexx(){
		String id=vo.getId();
		if(id==null || "".equals(id)){
			codetypeDao.save(this.getVo());
		}else{
			codetypeDao.update(this.getVo());
		}
		JSONObject obj=new JSONObject();
		obj.put("status", 1);
		obj.put("msg", "保存成功。");
		this.ajaxJson(obj.toJSONString());
//		pageBean = codetypeDao.findList(null);
		return "ajax";
	}
	/**
	 * 删除
	 * @return
	 */
	public String deletexx(){
		Map<String,Object> map=Util.operateStr(this.getId());
		Object[] parame=(Object[]) map.get("parame");
		codetypeDao.getH3DbManager().deleteEntityByParame("delete "+vo.getClass().getName()+" where id "+map.get("hql"), parame);
		JSONObject obj=new JSONObject();
		obj.put("status", 1);
		obj.put("msg", "删除成功。");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 检测名称是否重复
	 * @return
	 */
	public String checkTname(){
		Object[] parame={vo.getTname()};
		Tcodetype po=codetypeDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where tname=?", parame);
		JSONObject obj=new JSONObject();
		if(po==null || po.getId().equals(vo.getId())){//没有重复名称
			obj.put("status", 1);//校验正确
			obj.put("msg", "");
		}else{//存在重复名称
			obj.put("status", 0);//校验失败
			obj.put("msg", "名称已存在。");
		}
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 检测编码是否重复
	 * @return
	 */
	public String checkCode(){
		Object[] parame={vo.getCode()};
		Tcodetype po=codetypeDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where code=?", parame);
		JSONObject obj=new JSONObject();
		if(po==null || po.getId().equals(vo.getId())){//没有重复名称
			obj.put("status", 1);//校验正确
			obj.put("msg", "");
		}else{//存在重复名称
			obj.put("status", 0);//校验失败
			obj.put("msg", "编码已存在。");
		}
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 修改状态
	 * @return
	 */
	public String changeStatus(){
		JSONObject obj=new JSONObject();
		String isactives="";
		String msg="";
		if("1".equals(vo.getIsactives())){//当前为启动状态
			isactives="0";
			msg="禁用成功";
		}else{//当前为禁用状态
			isactives="1";
			msg="启用成功";
		}
		obj.put("status", 1);//操作正确
		obj.put("msg", msg);
		Object[] parame={isactives,vo.getId()};
		codetypeDao.getH3DbManager().updateForHql("update "+vo.getClass().getName()+" set isactives=? where id=?", parame);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	
}
