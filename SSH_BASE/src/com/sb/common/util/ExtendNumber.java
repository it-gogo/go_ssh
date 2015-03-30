package com.sb.common.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * 陈永楠
 * 2014-03-06
 * 该类为扩展
 * DOUBLE数值加减乘除
 * @author Administrator
 *
 */
public class ExtendNumber {

	static final DecimalFormat formatter6 = new DecimalFormat("#.00");

	public static double getDoubleOfResult(double d) {
		return Double.valueOf(formatter6.format(d));
	}

	public static String getDoubleOfResultWithStr(double d) {
		return formatter6.format(d);
	}

	/**
	 * 提供精确的小数位四舍五入处理。
	 * 
	 * @param v
	 *            需要四舍五入的数字
	 * @param scale
	 *            小数点后保留几位
	 * @return 四舍五入后的结果
	 */

	public static double round(double v, int scale, int roundingMode) {
		if (scale < 0) {
			throw new IllegalArgumentException("The   scale   must   be   a   positive   integer   or   zero");
		}
		BigDecimal b = new BigDecimal(Double.toString(v));

		return b.setScale(scale, roundingMode).doubleValue();
	}

	/**
	 * double 相加
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double sum(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return bd1.add(bd2).doubleValue();
	}

	/**
	 * double 相减
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double sub(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return bd1.subtract(bd2).doubleValue();
	}

	/**
	 * double 乘法
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static double mul(double d1, double d2) {
		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		
		return bd1.multiply(bd2).doubleValue();
	}

	/**
	 * double 除法
	 * 
	 * @param d1
	 * @param d2
	 * @param scale
	 *            四舍五入 小数点位数
	 * @return
	 */
	public static double div(double d1, double d2, int scale, int roundingMode) {
		// 当然在此之前，你要判断分母是否为0，
		// 为0你可以根据实际需求做相应的处理

		BigDecimal bd1 = new BigDecimal(Double.toString(d1));
		BigDecimal bd2 = new BigDecimal(Double.toString(d2));
		return bd1.divide(bd2, scale, roundingMode).doubleValue();
	}
	
	/**
	 * 将数字转换为大写金额
	 * @param value
	 * @return
	 */
	public static String changeToBig(double value){  
		if (value == 0){
			return "零圆整";
		}
        char[]   hunit={'拾','佰','仟'};                                                                                               //段内位置表示   
        char[]   vunit={'万','亿'};                                                                                                           //段名表示   
        char[]   digit={'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};     //数字表示   
        long   midVal   =   (long)(value*100);                                                                             //转化成整形   
        String   valStr=String.valueOf(midVal);                                                                 //转化成字符串   
        String   head=valStr.substring(0,valStr.length()-2);                               //取整数部分   
        String   rail=valStr.substring(valStr.length()-2);                                           //取小数部分   
  
        String   prefix="";                                                                                                                                   //整数部分转化的结果   
        String   suffix="";                                                                                                                                     //小数部分转化的结果   
        //处理小数点后面的数   
        if(rail.equals("00")){                                                                                                                         //如果小数部分为0   
            suffix="整";   
        }   else{   
            suffix=digit[rail.charAt(0)-'0']+"角"+digit[rail.charAt(1)-'0']+"分";                 //否则把角分转化出来   
        }   
        //处理小数点前面的数   
        char[]   chDig=head.toCharArray();                                                                                                                   //把整数部分转化成字符数组   
        char   zero='0';                                                                                                                                                                                     //标志'0'表示出现过0   
        byte   zeroSerNum   =   0;                                                                                                                                                         //连续出现0的次数   
        for(int   i=0;i<chDig.length;i++){                                                                                                                               //循环处理每个数字   
            int   idx=(chDig.length-i-1)%4;                                                                                                                                 //取段内位置   
            int   vidx=(chDig.length-i-1)/4;                                                                                                                                 //取段位置   
            if(chDig[i]=='0'){                                                                                                                                                                     //如果当前字符是0   
                zeroSerNum++;                                                                                                                                                                   //连续0次数递增   
                if(zero   ==   '0'){                                                                                                                                                                         //标志   
                    zero=digit[0];   
                }   else   if(idx==0   &&   vidx   >0   &&zeroSerNum   <   4){   
                    prefix   +=   vunit[vidx-1];   
                    zero='0';   
                }   
                continue;   
            }   
            zeroSerNum   =   0;                                                                                                                                                                         //连续0次数清零   
            if(zero   !=   '0')   {                                                                                                                                                                                 //如果标志不为0,则加上,例如万,亿什么的   
                prefix+=zero;   
                zero='0';   
            }   
            prefix+=digit[chDig[i]-'0'];                                                                                                                                                 //转化该数字表示   
            if(idx   >   0)   prefix   +=   hunit[idx-1];                                       
            if(idx==0   &&   vidx>0){   
                prefix+=vunit[vidx-1];                                                                                                                                                           //段结束位置应该加上段名如万,亿   
            }   
        }   
  
        if(prefix.length()   >   0)   prefix   +=   '圆';                                                                                                                           //如果整数部分存在,则有圆的字样   
        return   prefix+suffix;                                                                                                                                                                           //返回正确表示   
    }
}
