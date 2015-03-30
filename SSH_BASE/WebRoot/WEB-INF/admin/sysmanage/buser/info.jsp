<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>用户信息</title>
	<%@include file="/WEB-INF/admin/includefile.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/sysmanage/buser.js"></script>
  </head>
  
  <body>
  <div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">用户信息</a></li>
		</ul>
	</div>
	<div class="formbody">
	    <div class="formtitle"><span>基本信息</span></div>
	    <form action="bmenuAction!savexx.action" method="post" id="pform" >
		    <ul class="forminfo">
			    <li>
			    	<label>登录名<b>*</b></label>
			    	${hloginInfo.lname }
			    </li>
			    <li>
			    	<label>用户姓名<b>*</b></label>
					${hloginInfo.uname }
			    </li>
			    <li>
			    	<label>邮箱</label>
					${hloginInfo.email }
			    </li>
			    <li>
			    	<label>电话</label>
					${hloginInfo.telephone }
			    </li>
			    <li>
			    	<label>手机</label>
					${hloginInfo.mobile }
			    </li>
			    <li>
			    	<label>QQ</label>
					${hloginInfo.qq }
			    </li>
			    <li>
			    	<label>备注</label>
			    	${hloginInfo.remark }
			    </li>
			    <li>
			    	<label>&nbsp;</label><input name="" type="button" class="btn" value="返回" onclick="history.go(-1)"/>
			    </li>
		    </ul>
	    </form>
    </div>
  </body>
</html>
