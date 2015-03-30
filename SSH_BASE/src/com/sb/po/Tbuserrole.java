package com.sb.po;

/**
 * Tauthority entity. @author MyEclipse Persistence Tools
 */

public class Tbuserrole implements java.io.Serializable {

	// Fields

	private String id;
	private String roleid;
	private String buserid;

	// Constructors

	/** default constructor */
	public Tbuserrole() {
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


	public String getBuserid() {
		return buserid;
	}


	public void setBuserid(String buserid) {
		this.buserid = buserid;
	}


}