package com.sb.common.action;

import javax.annotation.Resource;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.Util;
import com.sb.core.action.ST2BaseAction;
import com.sb.po.Tbuser;
import com.sb.sysmanage.dao.TbuserDao;

@Controller("loginAction")
@ParentPackage("common")
@Scope("prototype")
public class LoginAction extends ST2BaseAction<Tbuser, String> {
	/**
	 * @author zhangjf 
	 * @create_date 2015-3-31 下午7:00:42
	 */
	private static final long serialVersionUID = 1L;
	private Tbuser vo;
	@Resource
	private TbuserDao buserDao;
	
	public String toLogin(){
		ContextUtil.removeSessionVal("hloginInfo");
		return "login";
	}
	
	public String logout(){
		ContextUtil.removeSessionVal("hloginInfo");
		return "ajax";
	}
	
	
	public String login() throws Exception{
		Tbuser po=buserDao.findOneByLP(vo.getLname(), Util.Encryption(vo.getPassword()));
		if(po==null){//登陆失败
			ContextUtil.setHttpRequestVal("msg", "账号或密码错误");
			return "login";
		}else if(!"1".equals(po.getIsactives())){//登陆失败
			ContextUtil.setHttpRequestVal("msg", "账号被禁用");
			return "login";
		}else{//登陆成功
			ContextUtil.setHttpSessionVal("hloginInfo", po);
			return "main";
		}
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
}
