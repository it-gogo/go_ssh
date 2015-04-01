<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>后台用户编辑</title>
	<%@include file="/WEB-INF/admin/head.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/sysmanage/buser.js"></script>
  </head>
  
  <body>
  	<%@include file="/WEB-INF/admin/includeBox.jsp" %>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">用户编辑</a></li>
		</ul>
	</div>
	<div class="formbody">
	    <div class="formtitle"><span>基本信息</span></div>
	    <form action="buserAction!savexx.action" method="post" id="pform" >
	    	<input type="hidden"  name="vo.id" id="ids" value="${vo.id }"/>
    		<input type="hidden" name="vo.password" value="${vo.password }"    />
		    <ul class="forminfo">
			    <li>
			    	<label>登录名<b>*</b></label>
			    	<input type="text" name="vo.lname" class="dfinput requires" value="${vo.lname }" onblur="checkLname(this,50)"  />
			    </li>
			    <li>
			    	<label>用户姓名<b>*</b></label>
					<input type="text" name="vo.uname" class="dfinput requires" value="${vo.uname }" onblur="checkNotEmtry(this,50)"   />
			    </li>
			    <li>
			    	<label>密码：(默认值:123456)</label>
					<input type="password" name="password" class="dfinput" value="" onblur="checkIsEmtry(this,20)"   />
			    </li>
			    <li>
			    	<label>邮箱</label>
					<input type="text" name="vo.email" class="dfinput " value="${vo.email }" onblur="checkIsNumber(this,50)"   />
			    </li>
			    <li>
			    	<label>电话</label>
					<input type="text" name="vo.telephone" class="dfinput " value="${vo.telephone }" onblur="checkIsNumber(this,10)"   />
			    </li>
			    <li>
			    	<label>手机</label>
					<input type="text" name="vo.mobile" class="dfinput " value="${vo.mobile }" onblur="checkIsNumber(this,20)"   />
			    </li>
			    <li>
			    	<label>QQ</label>
					<input type="text" name="vo.qq" class="dfinput " value="${vo.qq }" onblur="checkIsNumber(this,20)"   />
			    </li>
			    <li>
			    	<label>备注</label>
			    	<textarea name="vo.remark" cols="" rows="" class="textinput">${vo.remark }</textarea>
			    </li>
			    <li>
			    	<label>是否启用</label>
			    	<cite>
			    		<input name="vo.isactives" type="radio" value="1" checked="checked" />是&nbsp;&nbsp;&nbsp;&nbsp;
			    		<input name="vo.isactives" type="radio" value="0" <s:if test="vo.isactives==0">checked="checked"</s:if>  />否
			    	</cite>
			    </li>
			    <li>
			    	<label>&nbsp;</label><input name="" type="button" class="btn" value="确认保存" onclick="save('pform')"/>
			    	<label>&nbsp;</label><a href="javascript:void(0);"  onclick="back()" class="tablelink">返回</a>
			    </li>
		    </ul>
	    </form>
    </div>
  </body>
</html>
