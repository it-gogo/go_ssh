package com.sb.po;

/**
 * Tcodedata entity. @author MyEclipse Persistence Tools
 */

public class Tcodedata implements java.io.Serializable {

	// Fields

	private String id;
	private String typeid;
	private String cname;
	private String isactives;
	private String code;//编码
	private Tcodetype type;

	// Constructors

	/** default constructor */
	public Tcodedata() {
	}

	/** full constructor */
	public Tcodedata(String typeid, String cname,
			String isactives) {
		this.typeid = typeid;
		this.cname = cname;
		this.isactives = isactives;
	}

	// Property accessors

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}


	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getIsactives() {
		return this.isactives;
	}

	public void setIsactives(String isactives) {
		this.isactives = isactives;
	}

	public Tcodetype getType() {
		return type;
	}

	public void setType(Tcodetype type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}