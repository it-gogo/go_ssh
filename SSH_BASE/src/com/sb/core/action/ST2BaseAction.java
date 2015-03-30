package com.sb.core.action;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.ActionSupport;
import com.sb.common.Syscontants;
import com.sb.common.model.PageBean;
import com.sb.common.util.ContextUtil;
import com.sb.common.util.JSONUtil;

/**
 * 实现
 * @author Administrator
 *
 * @param <T>
 */
@Controller
public abstract class ST2BaseAction<T,PK> extends ActionSupport implements IBaseAction<T,String>,Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private  int  page=1;//当前页
	
	private  int   rows=10;//当前页记录数
	
	private PageBean<T> pageBean;//分页列表数据
	
	private String pageUrl;//分页按钮的地址
	
	private String id;//主键ID字符串
	
    private    String STATUS = "status";//返回的提示信息的状态
	
	private    String MESSAGE = "message";//返回提示信息的内容
	
	protected Map<String,String[]>  parame;
	
	private String zdy;
	
	public ST2BaseAction(){
		zdy=(String) ContextUtil.getHttpApplicationVal("zdy");
	}
	
	
	

	public String getZdy() {
		return zdy;
	}

	public void setZdy(String zdy) {
		this.zdy = zdy;
	}


	public Map<String, String[]> getParame() {
		return parame;
	}

	public void setParame(Map<String, String[]> parame) {
		this.parame = parame;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public PageBean<T> getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean<T> pageBean) {
		this.pageBean = pageBean;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	
    	
	// AJAX输出，返回null
	public String ajax(String content, String type) {
		try {
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType(type + ";charset=UTF-8");
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(content);
			response.getWriter().flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// AJAX输出文本，返回null
	public String ajaxText(String text) {
		return ajax(text, "text/plain");
	}

	// AJAX输出HTML，返回null
	public String ajaxHtml(String html) {
		return ajax(html, "text/html");
	}

	// AJAX输出XML，返回null
	public String ajaxXml(String xml) {
		return ajax(xml, "text/xml");
	}

	// 根据字符串输出JSON，返回null
	public String ajaxJson(String jsonString) {
		return ajax(jsonString, "text/html");
	}
		
	// 根据Map输出JSON，返回null
	public String ajaxJson(Map<String, String> jsonMap) {
		String jsonStr = JSONUtil.objToJSonStr(jsonMap);
		return ajax(jsonStr, "text/html");
	}
	
	/**
	 * 设置返回值
	 * @param status
	 * @param msg
	 */
	public void setReturnMessage(String status,String msg){
		JSONObject obj=new JSONObject();
		obj.put("status", status);
		obj.put("msg", msg);
		ajaxJson(obj.toJSONString());
	}
	
	/**
	 * 进入初始页面
	 * 
	 */
	public String redirect(){
		return this.INPUT;
	}
	
	/**
	 * 进入添加页面
	 * @return
	 */
	public String addxx(){
		return "edit";
	}
	
	
	/**
	 * 添加系统日志
	 */
    public  void  addSysLog(String  handleType){
    	
        
    }
	
	
	

}
