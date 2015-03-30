package com.sb.common.util;

import java.io.InputStream;
import java.util.Properties;



public class UrlUtil {
	private static Properties p;
	static{
		try{
			InputStream stream = UrlUtil.class.getClassLoader().getResourceAsStream("url.properties");
			p = new Properties();
		    p.load(stream);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  static String getUrl(){
		String url=p.getProperty("url");
		 return url;
	}
	public  static String getParame(String parame){
		 return p.getProperty(parame);
	}
	public static void main(String[] args) {
		System.out.println(getUrl());
	}
}
