package com.sb.common.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class ContextUtil {

	public  static  HttpServletRequest  getHttpRequest(){
		 HttpServletRequest request = ServletActionContext.getRequest();
		 return request;
	}
	
	public  static  HttpSession  getHttpSession(){
    	HttpSession  session = ServletActionContext.getRequest().getSession();
    	return  session;
    }
	
	/**
     * 获取RESPONSE
     * @return
     */
    public static  HttpServletResponse   getHttpResponse(){
    	HttpServletResponse  response = ServletActionContext.getResponse();
    	return response;
    }
    
    /**
     * 设置REQUEST
     * @param name
     * @param obj
     */
    public  static  void  setHttpRequestVal(String name,Object  obj)
    {
    	getHttpRequest().setAttribute(name, obj);
    	
    }
    
    public  static  Object  getHttpRequestVal(String name)
    {
    	return  getHttpRequest().getAttribute(name);
    }
    
    /**
     * 获取应用程序对象
     * @param name
     * @return
     */
    public  static  Object  getHttpApplicationVal(String name)
    {
    	return  getHttpRequest().getServletContext().getAttribute(name);
    }
    
    /**
     * 设置应用程序对象
     * @param name
     * @param obj
     */
    public static void  setHttpApplicationVal(String name,Object obj){
    	getHttpRequest().getServletContext().setAttribute(name, obj);
    }
    
    public static void removeApplicationVal(String name){
    	getHttpRequest().getServletContext().removeAttribute(name);
    }
    
    public  static  void setHttpSessionVal(String name,Object obj)
    {
    	getHttpSession().setAttribute(name, obj);
    }
    
    public   static  Object  getHttpSessionVal(String name)
    {
    	Object  val = getHttpSession().getAttribute(name);
    	return  val;
    }
    
    public  static  void  removeRequestVal(String name)
    {
    	getHttpRequest().removeAttribute(name);
    }
    
    public  static  void  removeSessionVal(String  name)
    {
    	getHttpSession().removeAttribute(name);
    }
    
      
    /**
     * 清楚SESSION
     */
    public static void clearSession() {
		if( getHttpRequest() != null )
			getHttpSession().invalidate();
	}
    
    
   /**
    * 取得WEB引用程序的环境
    * @return
    */
    public static WebApplicationContext  getWebApplicationContext(){
		return WebApplicationContextUtils.getWebApplicationContext(getHttpSession().getServletContext());
	}
	
    /**
     * 取得SPRING配置里的BEAN对象
     * @param beanName
     * @return
     */
	public static Object  getBean(String beanName){
		return getWebApplicationContext().getBean(beanName);
	}
	
	/**
	 * 获取请求参数 
	 * @return
	 */
	public static Map<String,String[]>  getHttpParame(){
		Map<String,String[]>  map = getHttpRequest().getParameterMap();
		return map;
	}
	
	
}
