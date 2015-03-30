package com.sb.common.model;

import com.alibaba.fastjson.JSONObject;
import com.sb.common.util.JSONUtil;


public class TreePo {

	private  String id;
	
	private  String name;
	
	private  String  pId;
	
	private String file;
	
	//是否打开
	private  boolean  open = false;
	
	public  String toString(){
		return  JSONUtil.objToJSonStr(this);
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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
}
