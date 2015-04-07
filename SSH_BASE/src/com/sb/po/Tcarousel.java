package com.sb.po;

import com.alibaba.fastjson.JSONArray;
import com.sb.common.util.JSONUtil;

/**
 * Taffiliate entity. @author MyEclipse Persistence Tools
 */

public class Tcarousel   implements
		java.io.Serializable {

	// Fields

	private String id;
	private String code;
	private String name;
	private String content;
	private Integer width;
	private Integer height;
	private String isactives;

	// Constructors

	public JSONArray getJSONArr(){
		if(content!=null || !"".equals(content)){
			return JSONUtil.strToArray(content);
		}
		return null;
	}
	

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	/** default constructor */
	public Tcarousel() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWidth() {
		return width;
	}

	public void setWidth(Integer width) {
		this.width = width;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public String getIsactives() {
		return isactives;
	}

	public void setIsactives(String isactives) {
		this.isactives = isactives;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


}