package com.sb.common.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sb.common.model.PageBean;
import com.sb.common.util.ContextUtil;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tbuser;
import com.sb.sysmanage.dao.TbmenuDao;

@Controller("mainAction")
@ParentPackage("common")
@Scope("prototype")
public class MainAction extends ST2BaseAction<PageBean, String> {

	@Resource
	private TbmenuDao bmenuDao;
	public String  findTop(){
		return "top";
	}
	
	public String findCenter(){
		return "center";
	}
	
	public String findDown(){
		return "down";
	}
	
	public String findLeft(){
		Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("hloginInfo");
		if(po==null){
			return "unvalid";
		}
		String menuStr=bmenuDao.getMenulistForSysUser(po);
		ContextUtil.setHttpRequestVal("menuStr", menuStr);
		return "left";
	}
	
	public String findRight(){
		return "right";
	}
	public String findMain(){
//		Tbuser po=(Tbuser) ContextUtil.getHttpSessionVal("sx");
//		if(po!=null){
//			System.out.println("123123");
//			ContextUtil.removeSessionVal("sx");
//			ContextUtil.setHttpSessionVal("hloginInfo", po);
//			ContextUtil.getHttpSession().setMaxInactiveInterval(30);//一分钟过期用于是否刷新
//		}
		return "main";
	}
	
}
