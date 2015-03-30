package com.sb.po;

/**
 * Tauthority entity. @author MyEclipse Persistence Tools
 */

public class Tauthority implements java.io.Serializable {

	// Fields

	private String id;
	private String roleid;
	private String menuid;

	// Constructors

	/** default constructor */
	public Tauthority() {
	}

	/** full constructor */
	public Tauthority(String roleid, String menuid) {
		this.roleid = roleid;
		this.menuid = menuid;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getMenuid() {
		return this.menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}

}