package com.sb.po;

/**
 * Tcodetype entity. @author MyEclipse Persistence Tools
 */

public class Tcodetype implements java.io.Serializable {

	// Fields

	private String id;
	private String code;
	private String tname;
	private String isactives;

	// Constructors

	/** default constructor */
	public Tcodetype() {
	}

	/** full constructor */
	public Tcodetype(String code, String tname, String isactives) {
		this.code = code;
		this.tname = tname;
		this.isactives = isactives;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public String getIsactives() {
		return this.isactives;
	}

	public void setIsactives(String isactives) {
		this.isactives = isactives;
	}

}