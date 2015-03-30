package com.sb.po;

/**
 * Trole entity. @author MyEclipse Persistence Tools
 */

public class Trole implements java.io.Serializable {

	// Fields

	private String id;
	private String rname;
	private String creator;
	private String remark;
	private String isactives;

	// Constructors

	/** default constructor */
	public Trole() {
	}

	/** full constructor */
	public Trole(String rname, String isactives) {
		this.rname = rname;
		this.isactives = isactives;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getIsactives() {
		return this.isactives;
	}

	public void setIsactives(String isactives) {
		this.isactives = isactives;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}