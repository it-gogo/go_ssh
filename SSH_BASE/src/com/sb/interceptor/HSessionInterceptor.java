package com.sb.interceptor;



import java.util.Date;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sb.common.util.ExtendDate;
import com.sb.po.Tbuser;

/**
 * 后台SESSION是否过期
 * @author Administrator
 *
 */
public class HSessionInterceptor  extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Tbuser  buser = (Tbuser)invocation.getInvocationContext().getSession().get("hloginInfo");
		if(buser==null){
//			return "unvalid";
		}/*else{
			int d = ExtendDate.getNumBetween2Date(ExtendDate.getYMD(new Date()), "2015-02-01");
			if(d<0){
				return "unvalid";
			}
		}*/
		return invocation.invoke();
	}
	
}

