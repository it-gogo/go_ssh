package com.sb.interceptor;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 后台SESSION是否过期
 * @author Administrator
 *
 */
public class QSessionInterceptor  extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
//		Tquser  buser = (Tquser)invocation.getInvocationContext().getSession().get("cloginInfo");
//		if(buser==null){
//			String status="0",msg="您未登录或登录过期，请重新登陆",href="../client/indexAction!index.action";
//			return Util.operationTips(status, msg, href);
//		}
		return invocation.invoke();
	}
	
}

