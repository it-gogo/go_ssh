package com.sb.baseinfo.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sb.baseinfo.dao.TcodedataDao;
import com.sb.baseinfo.dao.TcodetypeDao;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.Util;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tcodedata;
import com.sb.po.Tcodetype;
/**
 * 数据字典
 * @author Administrator
 *
 */
@Controller("codedataAction")
@ParentPackage("baseinfo")
@Scope("prototype")
public class TcodedataAction extends ST2BaseAction<Tcodedata, String> {

	private Tcodedata  vo = new Tcodedata();
	
	@Resource
	private TcodedataDao  codedataDao;
	@Resource
	private TcodetypeDao  codetypeDao;
	
	private String typeid;
	/**
	 * 数据类型树
	 * @return
	 */
	public String getCodetypeTree(){
		List<Tcodetype> listtype=codetypeDao.getH3DbManager().findList("From Tcodetype where isactives=1 ");
		JSONArray arr=new JSONArray();
		Map<String,Object> tree=new HashMap<String,Object>();
		tree.put("id", "0");
		tree.put("pId", "-1");
		tree.put("name", "数据类型");
		tree.put("open", true);
		arr.add(tree);
		for(Tcodetype type:listtype){
			tree=new HashMap<String,Object>();
			tree.put("id", type.getId());
			tree.put("pId", "0");
			tree.put("name", type.getTname());
			arr.add(tree);
		}
//		ContextUtil.setHttpRequestVal("tree", arr.toJSONString());
		return this.ajaxJson(arr.toJSONString());
	}
	/**
	 * 数组字典主页
	 * @return
	 */
	public String main(){
//		getCodetypeTree();
		return "main";
	}

	/**
     * 查询集合
     * @return
     */
	public String findList(){
		ContextUtil.removeSessionVal("searchparame");
		parame = ContextUtil.getHttpParame();
		this.setPageBean(codedataDao.findList(parame));
		this.setPageUrl("codedataAction!findList.action");
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
//			ContextUtil.setHttpSessionVal("searchparame", map);
		}
		this.setPageBean(codedataDao.findList(parame));
		this.setPageUrl("codedataAction!searchList.action");
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
		vo=codedataDao.getEntity(vo.getClass(), this.getId());
		typeid=vo.getTypeid();
		return "edit";
	}
	/**
	 * 保存
	 * @return
	 */
	public String savexx(){
		String id=vo.getId();
		if(id==null || "".equals(id)){
			codedataDao.save(this.getVo());
		}else{
			codedataDao.update(this.getVo());
		}
		JSONObject obj=new JSONObject();
		obj.put("status", 1);
		obj.put("msg", "保存成功。");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 删除
	 * @return
	 */
	public String deletexx(){
		Map<String,Object> map=Util.operateStr(this.getId());
		Object[] parame=(Object[]) map.get("parame");
		codedataDao.getH3DbManager().deleteEntityByParame("delete "+vo.getClass().getName()+" where id "+map.get("hql"), parame);
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
	public String checkCname(){
		Object[] parame={vo.getCname(),vo.getTypeid()};
		Tcodedata po=codedataDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where cname=? and typeid=?", parame);
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
		Object[] parame={vo.getCode(),vo.getTypeid()};
		Tcodedata po=codedataDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where code=? and typeid=?", parame);
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
		codedataDao.getH3DbManager().updateForHql("update "+vo.getClass().getName()+" set isactives=? where id=?", parame);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	public Tcodedata getVo() {
		return vo;
	}
	public void setVo(Tcodedata vo) {
		this.vo = vo;
	}
	public TcodedataDao getCodedataDao() {
		return codedataDao;
	}
	public void setCodedataDao(TcodedataDao codedataDao) {
		this.codedataDao = codedataDao;
	}
	public TcodetypeDao getCodetypeDao() {
		return codetypeDao;
	}
	public void setCodetypeDao(TcodetypeDao codetypeDao) {
		this.codetypeDao = codetypeDao;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
}
