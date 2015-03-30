package com.sb.po;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * Tbuser entity. @author MyEclipse Persistence Tools
 */

public class Tbuser implements java.io.Serializable ,HttpSessionBindingListener{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String lname;
	private String password;
	private String uname;
	private String sex;
	private String email;
	private String telephone;
	private String mobile;
	private String qq;
	private String remark;
	private String isactives;
	private String issuperadmin;//是否超级管理员

	// Constructors

	/** default constructor */
	public Tbuser() {
	}

	/** full constructor */
	public Tbuser(String lname, String password, String uname, String sex,
			String email, String telephone, String mobile, String qq,
			String remark, String isactives) {
		this.lname = lname;
		this.password = password;
		this.uname = uname;
		this.sex = sex;
		this.email = email;
		this.telephone = telephone;
		this.mobile = mobile;
		this.qq = qq;
		this.remark = remark;
		this.isactives = isactives;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getIssuperadmin() {
		return issuperadmin;
	}

	public void setIssuperadmin(String issuperadmin) {
		this.issuperadmin = issuperadmin;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLname() {
		return this.lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getIsactives() {
		return this.isactives;
	}

	public void setIsactives(String isactives) {
		this.isactives = isactives;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		if("1".equals(this.issuperadmin)){//是超级管理员
			HttpSession session=event.getSession();
			ServletContext application=session.getServletContext();
			application.setAttribute("supperAdmin", "1");
		}
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		if("1".equals(this.issuperadmin)){//是超级管理员
			HttpSession session=event.getSession();
			ServletContext application=session.getServletContext();
			application.removeAttribute("supperAdmin");
		}
	}

}