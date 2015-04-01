<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>修改密码</title>
	<%@include file="/WEB-INF/admin/head.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/sysmanage/password.js"></script>
  </head>
  
  <body>
  	<%@include file="/WEB-INF/admin/includeBox.jsp" %>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">修改密码</a></li>
		</ul>
	</div>
	<div class="formbody">
	    <div class="formtitle"><span>修改密码</span></div>
	    <form action="buserAction!modifyPW.action" method="post" id="pform" >
		    <ul class="forminfo">
			    <li>
			    	<label>旧密码<b>*</b></label>
			    	<input type="password" name="password" class="dfinput requires"  onblur="checkNotEmtry(this,20)"   />
			    </li>
			    <li>
			    	<label>新密码<b>*</b></label>
					<input type="password" name="vo.password" class="dfinput requires"  id="checkPW"   />
			    </li>
			    <li>
			    	<label>确认密码<b>*</b></label>
					<input type="password"  class="dfinput requires" id="rcheckPW"  />
			    </li>
			    <li>
			    	<label>&nbsp;</label><input name="" type="button" class="btn" value="确认修改" onclick="save('pform')"/>
			    	<label>&nbsp;</label><a href="javascript:void(0);"  onclick="history.go(-1);" class="tablelink">返回</a>
			    </li>
		    </ul>
	    </form>
    </div>
  </body>
</html>
