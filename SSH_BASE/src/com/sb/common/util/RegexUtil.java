package com.sb.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexUtil {
    
	/**
	 * 匹配正则表达式,数字
	 * @param str
	 */
	public  static boolean  allNumber(String  str)
	{
		String  regStr = "\\d*";
		Pattern  pt = Pattern.compile(regStr);
		Matcher  m = pt.matcher(str);
		boolean flag = m.matches();
		return  flag;
	}
	
	public  static boolean  machString(String str,String reg)
	{
		Matcher  m = machStr(reg,str);
		if(m.matches())
		{
			return true;
		}
		return false;
	}
	
	public  static  boolean  machSn(String sn)
	{
		boolean  flag = machString(sn,"^'.*'$");
		return flag;
	}
	
	/**
	 * 校验日期格式
	 * @param str
	 * @return
	 */
	public static  boolean machDate(String date){
		String reg = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		boolean  b = machString(date,reg);
		return b;
	}
	
	public static  boolean machStrAndNum(String str){
		String reg = "[(A-Za-z0-9)]*";
		boolean b = machString(str,reg);
		return b;
	}
	
	
	
	/**
	 * 把原Orderby信息替换
	 * @param sql
	 * @return
	 */
	public static String  getOrderBy(String sql)
	{
		
//		String  regStr = "order\\s*by\\s*([a-z]|\\.|\\,)*[^\\)]([a-z]|\\.|\\,)*($)";
		String  regStr = "order\\s*by\\s*([a-z]|\\.|\\,)*[^\\)]([a-z]|\\.|\\,)*($)";
		Matcher flag_o = machStr(regStr,sql.toLowerCase());
		String res = ""; 
		if(flag_o.find())
		{ 
			res = flag_o.group(0);
		}
		return  res;
	}
	
	
	
	/**
	 * 替换ORDER By信息
	 * @param sql
	 * @param OrderBy
	 * @return
	 */
	public static  String  machOrderby(String  sql,String OrderBy)
	{
		Matcher flag_o = machStr1(OrderBy,sql);	
		if(flag_o.find())
		{
			sql = flag_o.replaceFirst("");
		}
		return  sql;
	}
	
	/**
	 * 匹配
	 * @param reg
	 * @param str
	 * @return
	 */
	public  static  Matcher  machStr(String reg,String  str)
	{
		Pattern  pt = Pattern.compile(reg,Pattern.CASE_INSENSITIVE|Pattern.COMMENTS);
		Matcher  m = pt.matcher(str.trim());
		return  m;
	}
	
	
	public  static  Matcher  machStr1(String reg,String  str)
	{
		Pattern  pt = Pattern.compile(reg,Pattern.CASE_INSENSITIVE|Pattern.LITERAL);
		Matcher  m = pt.matcher(str.trim());
		return  m;
	}
	
	
	public static void main(String[] args) {
//		String str="../1123123adf";
//		String reg= "[\\.\\./].*";
//		System.out.println(machString(str,reg));
		
		System.out.println("641484723@qq.com".replaceAll("[^com]", "*"));
	}
	
	
	
}
