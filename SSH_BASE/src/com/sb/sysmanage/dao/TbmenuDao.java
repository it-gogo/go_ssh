package com.sb.sysmanage.dao;

import java.awt.Menu;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sb.common.model.MenuPo;
import com.sb.common.model.PageBean;
import com.sb.common.model.SqlBean;
import com.sb.core.dao.SP3BaseDao;
import com.sb.po.Tbmenu;
import com.sb.po.Tbuser;

@Repository
public class TbmenuDao extends SP3BaseDao<Tbmenu, String> {

	public PageBean<Tbmenu> findList(Map<String,String[]> parame){
		String csql = "Select count(*) from Tbmenu  Where 1=1";
		String sql = "  From Tbmenu as a Where 1=1 ";
		SqlBean sqlBean = this.createSQL(sql, csql, parame, null);
		PageBean<Tbmenu>  pageBean = this.getH3DbManager().findList(sqlBean);
		return pageBean;
	}
	
	public List<Tbmenu>  findAll(){
		String sql = "From Tbmenu Where 1=1 and isactives=1 ";
		List<Tbmenu> list = this.getH3DbManager().findList(sql);
		return list;
	}
	
	/**
	 * 用户是否用actionName权限
	 * @param user
	 * @param actionName
	 * @return
	 */
	public boolean isAuthByUser(Tbuser user,String actionName){
		Object[] parame={"'%"+actionName+"%'",user.getId()};
		Long count=(Long) this.getH3DbManager().geOneObject1("select count(*) from Tbmenu where urls like ? and id in (select menuid from Tauthority where roleid in (select roleid from  Tbuserrole where buserid =?) )", parame);
		return count!=0;
	}
	
	/**
	 * 查找用户拥有的菜单
	 * @param userid
	 * @return
	 */
	public List<Tbmenu>  findUserMenu(String userid){
		String sql = "From Tbmenu Where 1=1 and isactives=1 and id in (select menuid from Tauthority where roleid in (select roleid from  Tbuserrole where buserid ='"+userid+"') ) ";
		List<Tbmenu> list = this.getH3DbManager().findList(sql);
		return list;
	}
	
	public String updatexx(Tbmenu vo){
		this.getH3DbManager().updateEntity(vo);
		return "success";
	}
	
	
	
	/**
	 * 获取树
	 * @return
	 */
	public JSONArray  findTree(){
		List<Tbmenu> list = this.findAll();
		JSONArray array = new JSONArray();
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("id", "0");
		jsonobj.put("pId", "-1");
		jsonobj.put("name", "系统菜单");
		jsonobj.put("open", true);
		array.add(jsonobj);
		if(list!=null){
			for(Tbmenu tbmenu:list){
			    jsonobj = new JSONObject();
				jsonobj.put("id", tbmenu.getMcode());
				jsonobj.put("pId", tbmenu.getPmcode());
				jsonobj.put("name", tbmenu.getMname());
				jsonobj.put("ids",tbmenu.getId());
				//jsonobj.put("pmcode", tbmenu.getPmcode());
				array.add(jsonobj);
			}
		}
		return array;
	}
	
	
	public String savexx(Tbmenu vo){
		String mcode = this.getMaxCode(vo);
		Integer seq = this.getMaxSeq();
		int series = this.getSeries(mcode);
		vo.setMcode(mcode);
		vo.setSeq(seq);
		vo.setSeries(series);
		this.getH3DbManager().saveEntity(vo);
		return "success";
	}
	
	public  String deletexx(String id){
		boolean isChildren = this.isChilren(id);
		if(isChildren){
			return "bError";
		}
		this.getH3DbManager().delete(id, "Tbmenu");
		return "success";
	}
	
	
	
	
	/**
	 * huoqu
	 * @param vo
	 * @return
	 */
	public JSONObject  getPmenu(Tbmenu vo){
		String sql = "From Tbmenu Where mcode=?";
		Object[] parame={vo.getPmcode()};
		Tbmenu  bmenu = this.getH3DbManager().getOneObject(sql, parame);
		JSONObject jsonobj = new JSONObject();;
		if(bmenu==null){
			jsonobj = new JSONObject();
			jsonobj.put("pmcode", "0");
			jsonobj.put("pmname", "系统菜单");
			jsonobj.put("id", "root");
		}else{
		    jsonobj.put("pmname", bmenu.getMname());
		    jsonobj.put("pmcode", bmenu.getMcode());
		    jsonobj.put("id", bmenu.getId());
		}
		return jsonobj;
	}
	
	/**
	 * 获取最大的排序
	 * @return
	 */
	public Integer getMaxSeq(){
		String sql = "Select max(seq) From Tbmenu ";
		Integer seq = (Integer)this.getH3DbManager().geOneObject1(sql, null);
		if(seq==null||seq==0){
			seq = 1;
		}else{
			sql +=1;
		}
		return seq;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isChilren(String id){
		String[] arr = id.split(",");
		String ids = "";
		for(int i=0;i<arr.length;i++){
			ids += "'"+arr[i]+"',";
		}
		if(ids.length()>0){
			ids = ids.substring(0,ids.length()-1);
		}
		String sql = " Select count(*) From Tbmenu Where pid in("+ids+")";
		Object obj = this.getH3DbManager().geOneObject1(sql, null);
		if(obj!=null){
			Long count = (Long)obj;
			if(count>0){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取最大的菜单编码
	 * @param vo
	 * @return
	 */
	public String getMaxCode(Tbmenu vo){
		String sql = " Select max(mcode) From Tbmenu" +
				     " Where pmcode=?";
		Object[]  parame = {vo.getPmcode()};
		Object   mcode = this.getH3DbManager().geOneObject1(sql, parame);
		String res = "";
		if(mcode==null||mcode.equals("")){
			if(vo.getPmcode()==null||vo.getPmcode().equals("0")){
			  res = "100";
			}else{
			  res = vo.getPmcode()+"100";
			}
		}else{
			Long t_code = Long.parseLong(mcode.toString())+1;
			res = String.valueOf(t_code);
		}
		return res;
	}
	
	private Integer getSeries(String mcode){
		int len = mcode.length();
		int mod_len = len/3;
		return mod_len;
	}
	
	/**
	 * 取得菜单
	 * @param vo
	 * @return
	 */
	public  String  getMenulistForSysUser(Tbuser vo){
		String  userId = vo.getId();
		String sql = " From Tbmenu Where isactives=1  " +
				     " and id in (Select  menuid From  Tauthority Where roleid in(" +
				     " Select roleid From Tbuserrole Where buserid=?))"+
				     " Order by seq asc,id desc";
		Object[] parame={userId};
//		sql = " From Tbmenu  Order by seq asc";
//		List<Tbmenu> obj = this.getH3DbManager().findList(sql);
		List<Tbmenu> obj = this.getH3DbManager().findList(sql, parame);
		List<MenuPo> list = new ArrayList();
		MenuPo  po = new MenuPo();
		po.setName("");
		po.setId("0");
		po.setPid("-1");
		po.setScriptEvent("#");
		po.setUrl("#");
		po.setStep(0);
		list.add(po);
		if((obj==null||obj.size()<2)){
			 po = new MenuPo();
			 po.setName("系统管理");
			 po.setId("1");
			 po.setPid("0");
			 po.setScriptEvent("addPanel");
			 po.setUrl("#");
			 po.setStep(1);
			 list.add(po);
			 po = new MenuPo();
			 po.setName("角色管理");
			 po.setId("2");
			 po.setPid("1");
			 po.setScriptEvent("addPanel");
			 po.setUrl("sysmanager/troleAction.action");
			 po.setStep(2);
			 list.add(po);
		}else{
			for(int i=0;i<obj.size();i++){
			    po = new MenuPo();
			    Tbmenu  mvo = obj.get(i);
				po.setName(mvo.getMname());
				po.setUrl(mvo.getUrls());
				po.setStep(mvo.getSeries());
				po.setId(mvo.getMcode());
				po.setPid(mvo.getPmcode());
				list.add(po);
			}
		}
		return tranArrayToJson(list);
	}
	
	private  String  tranArrayToJson(List<MenuPo> array){
    	//存储临时对象
    	Map  tmpMap = new LinkedHashMap();
    	//结果返回值
    	JSONArray  res = new JSONArray();
    	MenuPo root = null;
    	for(int i=0;i<array.size();i++){
    		MenuPo  jsonobj = array.get(i);
    		String  bh = jsonobj.getId();
    		tmpMap.put(bh,jsonobj);
    	}
    	for(int i=0;i<array.size();i++){
    		MenuPo  jsonobj = array.get(i);
    		String bh = jsonobj.getId();
    		String fbh = jsonobj.getPid();
    		if("-1".equals(fbh)){
    			//根
    			root = (MenuPo)tmpMap.get(bh);
    		}else{
    	        ((MenuPo)tmpMap.get(fbh)).getChildren().addChildren((MenuPo)tmpMap.get(bh));
    	    }
    	}
    	return root.toString();
    }
}
