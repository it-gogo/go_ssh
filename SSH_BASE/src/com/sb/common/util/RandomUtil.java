package com.sb.common.util;

import java.util.Random;

public class RandomUtil {

	/**
	 * 产生多少位的随机数
	 * @param len
	 * @return
	 */
	public static  String  genRandom(int len){
		Random random1 = new Random(System.currentTimeMillis());
		char[]  c = new char[len];
		String  s = "0123456789";
		char[] src = s.toCharArray();
		for(int i=0;i<len;i++){
		    int rmd = Math.abs(random1.nextInt())%10;
		    c[i] = src[rmd];
		}
		String  vailcode = new String(c);
		return vailcode;
	}
}
