package com.sb.sysmanage.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.Util;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tbuser;
import com.sb.sysmanage.dao.TbuserDao;
import com.sb.sysmanage.dao.TbuserroleDao;
/**
 * 后台账号管理
 * @author Administrator
 *
 */
@Controller("buserAction")
@ParentPackage("sysmanage")
@Scope("prototype")
public class TbuserAction extends ST2BaseAction<Tbuser, String> {

	private Tbuser  vo = new Tbuser();
	private String password;
	
	
	@Resource
	private TbuserDao  buserDao;
	@Resource
	private TbuserroleDao buserroleDao;


	/**
     * 查询集合
     * @return
     */
	public String findList(){
		ContextUtil.removeSessionVal("searchparame");
		Map<String,String[]>  parame = ContextUtil.getHttpParame();
		this.setPageBean(buserDao.findList(parame));
		this.setPageUrl("buserAction!findList.action");
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
		this.setPageBean(buserDao.findList(parame));
		this.setPageUrl("buserAction!searchList.action");
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
		vo=buserDao.getEntity(vo.getClass(), this.getId());
		return "edit";
	}
	/**
	 * 保存
	 * @return
	 * @throws Exception 
	 */
	public String savexx() throws Exception{
		if(password==null || "".equals(password)){
			if(vo.getPassword()==null || "".equals(vo.getPassword())){
				vo.setPassword(Util.Encryption("123456"));
			}
		}else{
			vo.setPassword(Util.Encryption(password));
		}
		String id=vo.getId();
		if(id==null || "".equals(id)){
			buserDao.save(this.getVo());
		}else{
			buserDao.update(this.getVo());
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
		
		Long count=(Long) buserDao.getH3DbManager().geOneObject1("select count(*) from "+vo.getClass().getName()+" where issuperadmin=1 and id "+map.get("hql"), parame);
		if(count>0){
			obj.put("status", 1);
			obj.put("msg", "删除失败，超级管理员不可删除。");
			this.ajaxJson(obj.toJSONString());
			return "ajax";
		}
		
		buserroleDao.getH3DbManager().deleteEntityByParame("delete Tbuserrole where buserid "+map.get("hql"), parame);
		
		buserDao.getH3DbManager().deleteEntityByParame("delete "+vo.getClass().getName()+" where id "+map.get("hql"), parame);
		
		obj.put("status", 1);
		obj.put("msg", "删除成功。");
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	/**
	 * 检测名称是否重复
	 * @return
	 */
	public String checkLname(){
		Object[] parame={vo.getLname()};
		Tbuser po=buserDao.getH3DbManager().getOneObject("From "+vo.getClass().getName()+" where lname=?", parame);
		JSONObject obj=new JSONObject();
		if(po==null || po.getId().equals(vo.getId())){//没有重复用户名
			obj.put("status", 1);//校验正确
			obj.put("msg", "");
		}else{//存在重复名称
			obj.put("status", 0);//校验失败
			obj.put("msg", "用户名已存在。");
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
		buserDao.getH3DbManager().updateForHql("update "+vo.getClass().getName()+" set isactives=? where id=?", parame);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	
	/**
	 * 去修改密码
	 * @return
	 */
	public String toModifyPW(){
		
		return "pw";
	}
	/**
	 * 修改密码
	 * @return
	 * @throws Exception 
	 */
	public String modifyPW() throws Exception{
		Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("hloginInfo");
		JSONObject obj=new JSONObject();
		if(po.getPassword().equals(Util.Encryption(password))){//旧密码正确
			String str=Util.Encryption(vo.getPassword());
			Object[] parame={str,po.getId()};
			buserDao.getH3DbManager().updateForHql("update Tbuser set password=? where id=?", parame);
			po.setPassword(str);
			ContextUtil.setHttpSessionVal("hloginInfo", po);
			obj.put("status", 1);
			obj.put("msg", "密码修改成功");
		}else{
			obj.put("status", 0);
			obj.put("msg", "旧密码错误");
		}
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	
	public String lookInfo(){
		
		return "info";
	}
	
	public Tbuser getVo() {
		return vo;
	}
	public void setVo(Tbuser vo) {
		this.vo = vo;
	}
	public TbuserDao getBuserDao() {
		return buserDao;
	}
	public void setBuserDao(TbuserDao buserDao) {
		this.buserDao = buserDao;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
