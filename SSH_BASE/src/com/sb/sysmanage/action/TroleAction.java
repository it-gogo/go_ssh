package com.sb.sysmanage.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.Util;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tbmenu;
import com.sb.po.Tbuser;
import com.sb.po.Trole;
import com.sb.sysmanage.dao.TauthorityDao;
import com.sb.sysmanage.dao.TbmenuDao;
import com.sb.sysmanage.dao.TbuserDao;
import com.sb.sysmanage.dao.TbuserroleDao;
import com.sb.sysmanage.dao.TroleDao;
/**
 * 后台角色管理
 * @author Administrator
 *
 */
@Controller("roleAction")
@ParentPackage("sysmanage")
@Scope("prototype")
public class TroleAction extends ST2BaseAction<Trole, String> {

	private Trole  vo = new Trole();
	
	
	@Resource
	private TroleDao  roleDao;
	@Resource
	private TbmenuDao bmenuDao;
	@Resource
	private TauthorityDao authorityDao;
	@Resource
	private TbuserDao buserDao;
	@Resource
	private TbuserroleDao buserroleDao;


	/**
     * 查询集合
     * @return
     */
	public String findList(){
		Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("hloginInfo");
		ContextUtil.removeSessionVal("searchparame");
		Map<String,String[]>  parame = ContextUtil.getHttpParame();
		Map<String,String[]> map=new HashMap<String,String[]>(parame);
		String[] arr=new String[]{po.getId()};
		map.put("(creator in  (select buserid from Tbuserrole where roleid in (select id from Trole where creator=?) ) or creator='"+po.getId()+"')_hql", arr);
		this.setPageBean(roleDao.findList(map));
		this.setPageUrl("roleAction!findList.action");
		return "list";
	}
	/**
     * 查询集合
     * @return
     */
	public String searchList(){
		Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("hloginInfo");
		parame = ContextUtil.getHttpParame();
		Map<String,String[]>  map=new HashMap<String,String[]>(parame);
		if(parame.containsKey("curPage")){
			map=(Map<String, String[]>) ContextUtil.getHttpSessionVal("searchparame");
			map.put("curPage", parame.get("curPage"));
		}else{
			ContextUtil.setHttpSessionVal("searchparame", map);
		}
		String[] arr=new String[]{po.getId()};
		map.put("(creator in (select id from Trole where creator=?) or creator='"+po.getId()+"')_hql", arr);
		this.setPageBean(roleDao.findList(map));
		this.setPageUrl("roleAction!searchList.action");
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
		vo=roleDao.getEntity(vo.getClass(), this.getId());
		return "edit";
	}
	/**
	 * 保存
	 * @return
	 */
	public String savexx(){
		String id=vo.getId();
		if(id==null || "".equals(id)){
			Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("hloginInfo");
			vo.setCreator(po.getId());
			roleDao.save(this.getVo());
		}else{
			roleDao.update(this.getVo());
		}
		JSONObject obj=new JSONObject();
		obj.put("status", 1);
		obj.put("msg", "保存成功。");
		this.ajaxJson(obj.toJSONString());
//		pageBean = qmenuDao.findList(null);
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
		
		
		authorityDao.getH3DbManager().deleteEntityByParame("delete Tauthority where roleid "+map.get("hql"), parame);
		
		buserroleDao.getH3DbManager().deleteEntityByParame("delete Tbuserrole where roleid "+map.get("hql"), parame);
		
		roleDao.getH3DbManager().deleteEntityByParame("delete "+vo.getClass().getName()+" where id "+map.get("hql"), parame);
		
		obj.put("status", 1);
		obj.put("msg", "删除成功。");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 检测名称是否重复
	 * @return
	 */
	public String checkRname(){
		Object[] parame={vo.getRname()};
		Trole po=roleDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where rname=?", parame);
		JSONObject obj=new JSONObject();
		if(po==null || po.getId().equals(vo.getId())){//没有重复用户名
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
		roleDao.getH3DbManager().updateForHql("update "+vo.getClass().getName()+" set isactives=? where id=?", parame);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 打开权限
	 * @return
	 */
	public String openAuth(){
		Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("hloginInfo");
		List<Tbmenu> list=new ArrayList<Tbmenu>();
		if("1".equals(po.getIssuperadmin())){//是超级管理员
			 list=bmenuDao.findAll();
		}else{
			 list=bmenuDao.findUserMenu(po.getId());
		}
		List menuidlist=authorityDao.findAll(vo.getId());
		JSONArray arr=new JSONArray();
		Map<String,Object> tree=new HashMap<String,Object>();
		if(list!=null){
			for(Tbmenu tbmenu:list){
				tree = new JSONObject();
				tree.put("id", tbmenu.getMcode());
				tree.put("pId", tbmenu.getPmcode());
				tree.put("name", tbmenu.getMname());
				tree.put("ids",tbmenu.getId());
				if(menuidlist.contains(tbmenu.getId())){
					tree.put("checked",true);
				}
				arr.add(tree);
			}
		}
		//ContextUtil.setHttpRequestVal("tree", arr.toJSONString());
		this.ajaxJson(arr.toJSONString());
		return "ajax";
	}
	/**
	 * 保存权限
	 * @return
	 */
	public String saveAuth(){
		authorityDao.saveAuth(vo.getId(), super.getId());
		JSONObject obj=new JSONObject();
		obj.put("status", 1);
		obj.put("msg", "保存成功");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 打开后台用户
	 * @return
	 */
	public String openBuser(){
		List list=buserroleDao.findAll(vo.getId());
		List<Tbuser> userlist=buserDao.findAll();
		List<Map<String,Object>> l=new ArrayList<Map<String,Object>>();
		for(Tbuser buser:userlist){
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("id", buser.getId());
			m.put("lname", buser.getLname());
			m.put("uname", buser.getUname());
			if(list.toString().indexOf(buser.getId())>-1){
				m.put("checked", true);
			}else{
				m.put("checked", false);
			}
			l.add(m);
		}
		ContextUtil.setHttpRequestVal("list", l);
		return "buser";
	}
	/**
	 * 保存绑定用户
	 * @return
	 */
	public String bindUser(){
		buserroleDao.bindUser(vo.getId(), super.getId());
		JSONObject obj=new JSONObject();
		obj.put("status", 1);
		obj.put("msg", "保存成功");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	public Trole getVo() {
		return vo;
	}
	public void setVo(Trole vo) {
		this.vo = vo;
	}
	public TroleDao getRoleDao() {
		return roleDao;
	}
	public void setRoleDao(TroleDao roleDao) {
		this.roleDao = roleDao;
	}
}
