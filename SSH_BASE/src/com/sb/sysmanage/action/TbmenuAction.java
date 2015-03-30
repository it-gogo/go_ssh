package com.sb.sysmanage.action;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sb.common.Syscontants;
import com.sb.common.model.PageBean;
import com.sb.common.util.ContextUtil;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tbmenu;
import com.sb.sysmanage.dao.TbmenuDao;

@Controller("bmenuAction")
@ParentPackage("sysmanage")
@Scope("prototype")
public class TbmenuAction extends ST2BaseAction<Tbmenu, String> {
    
	private Tbmenu vo = new Tbmenu();
	
	@Autowired
	private TbmenuDao bmenuDao;
	
	private JSONObject pobj;
	
	
	
	public JSONObject getPobj() {
		return pobj;
	}



	public void setPobj(JSONObject pobj) {
		this.pobj = pobj;
	}



	public Tbmenu getVo() {
		return vo;
	}



	public void setVo(Tbmenu vo) {
		this.vo = vo;
	}



	public TbmenuDao getBmenuDao() {
		return bmenuDao;
	}



	public void setBmenuDao(TbmenuDao bmenuDao) {
		this.bmenuDao = bmenuDao;
	}


	public String redirect(){
		
		return this.INPUT;
	}
	
	public String addxx(){
		pobj = this.getBmenuDao().getPmenu(vo);
		return "edit";
	}
	
	/**
	 * 保存信息
	 * @return
	 */
	public String savexx(){
		String res = "";
		String message = "";
	    if(vo.getId()!=null&&!"".equals(vo.getId())){
	    	res = this.getBmenuDao().updatexx(vo);
	    	if(res.equals("success")){
	    		this.setReturnMessage(Syscontants.SUCCESS_FLAG,"更新成功");
			}else{
				this.setReturnMessage(Syscontants.ERROR_FLAG,"更新失败");
			}
	    }else{
		    res = this.getBmenuDao().savexx(vo);
			if(res.equals("success")){
			    this.setReturnMessage(Syscontants.SUCCESS_FLAG,"保存成功");
			}else{
				this.setReturnMessage(Syscontants.ERROR_FLAG,"保存失败");
			}
	    }
	    return "ajax";
	}
	
	public String findList(){
		parame = ContextUtil.getHttpParame();
		PageBean<Tbmenu> pageBean = this.getBmenuDao().findList(parame);
		this.setPageBean(pageBean);
		this.setPageUrl("bmenuAction!findList.action");
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
			map=(Map<String, String[]>) ContextUtil.getHttpSessionVal("parame");
			map.put("curPage", parame.get("curPage"));
		}else{
			ContextUtil.setHttpSessionVal("parame", map);
		}
		this.setPageBean(bmenuDao.findList(map));
		this.setPageUrl("bmenuAction!searchList.action");
		return "list";
	}
	
	/**
	 * 修改信息
	 * @return
	 */
	public String updatexx(){
		vo = this.getBmenuDao().getEntity(Tbmenu.class,this.getId());
		pobj = this.getBmenuDao().getPmenu(vo);
		return "edit";
	}
	
	/**
	 * 获取菜单树
	 * @return
	 */
	public String findTree(){
		JSONArray  array = this.getBmenuDao().findTree();
		return this.ajaxJson(array.toJSONString());
	}
	
	/**
	 * 删除信息
	 * @return
	 */
	public  String deletexx(){
		String res = this.getBmenuDao().deletexx(this.getId());
		String message = "";
		if(res.equals("success")){
		    this.setReturnMessage(Syscontants.SUCCESS_FLAG,"删除成功");
		}else if(res.equals("bError")){
			this.setReturnMessage(Syscontants.ERROR_FLAG,"存在子节点，不能删除");
		}else{
			this.setReturnMessage(Syscontants.ERROR_FLAG,"删除失败");
		}
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
		bmenuDao.getH3DbManager().updateForHql("update "+vo.getClass().getName()+" set isactives=? where id=?", parame);
		this.ajaxJson(obj.toJSONString());
		return "ajax";
	}
	
}
