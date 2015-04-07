package com.sb.webmanage.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.JSONUtil;
import com.sb.common.util.Util;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tcarousel;
import com.sb.webmanage.dao.TcarouselDao;
/**
 * 轮播管理
 * @author Administrator
 *
 */
@Controller("carouselAction")
@ParentPackage("webmanage")
@Scope("prototype")
public class TcarouselAction extends ST2BaseAction<Tcarousel, String> {

	private Tcarousel  vo = new Tcarousel();
	
	@Resource
	private TcarouselDao  carouselDao;


	/**
     * 查询集合
     * @return
     */
	public String findList(){
		ContextUtil.removeSessionVal("searchparame");
		Map<String,String[]>  parame = ContextUtil.getHttpParame();
		this.setPageBean(carouselDao.findList(parame));
		this.setPageUrl("carouselAction!findList.action");
		return "list";
	}
	/**
     * 查询集合
     * @return
     */
	public String searchList(){
		Map<String,String[]>  parame = ContextUtil.getHttpParame();
		Map<String,String[]>  map=new HashMap<String,String[]>(parame);
		if(parame.containsKey("curPage")){
			parame=(Map<String, String[]>) ContextUtil.getHttpSessionVal("searchparame");
		}else{
			ContextUtil.setHttpSessionVal("searchparame", map);
		}
		this.setPageBean(carouselDao.findList(parame));
		this.setPageUrl("carouselAction!searchList.action");
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
		vo=carouselDao.getEntity(vo.getClass(), this.getId());
		String str=vo.getContent();
		JSONArray arr=JSONUtil.strToArray(str);
		ContextUtil.setHttpRequestVal("arr", arr);
		return "edit";
	}
	/**
	 * 保存
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String savexx() throws Exception{
		JSONObject obj=new JSONObject();
		String id=vo.getId();
		if(id==null || "".equals(id)){
			vo=carouselDao.save(this.getVo());
			obj.put("msg", "保存成功。");
		}else{
			vo=carouselDao.update(this.getVo());
			obj.put("msg", "修改成功。");
		}
		obj.put("status", 1);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 删除
	 * @return
	 */
	public String deletexx(){
		JSONObject obj=new JSONObject();
		Map<String,Object> map=Util.operateStr(this.getId());
		Object[] parame=(Object[]) map.get("parame");
		
		
		carouselDao.getH3DbManager().deleteEntityByParame("delete "+vo.getClass().getName()+" where id "+map.get("hql"), parame);
		
		obj.put("status", 1);
		obj.put("msg", "删除成功。");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	
	/**
	 * 检测菜单编码是否重复
	 * @return
	 */
	public String checkCode(){
		Object[] parame={vo.getCode()};
		Tcarousel po=carouselDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where code=?", parame);
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
		carouselDao.getH3DbManager().updateForHql("update "+vo.getClass().getName()+" set isactives=? where id=?", parame);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	public Tcarousel getVo() {
		return vo;
	}
	public void setVo(Tcarousel vo) {
		this.vo = vo;
	}
	public TcarouselDao getCarouselDao() {
		return carouselDao;
	}
	public void setCarouselDao(TcarouselDao carouselDao) {
		this.carouselDao = carouselDao;
	}
}
