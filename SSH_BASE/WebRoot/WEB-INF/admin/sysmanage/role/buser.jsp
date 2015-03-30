<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>用户绑定</title>
	<%@include file="/WEB-INF/admin/head.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/sysmanage/role.js"></script>
</head>

<body >
	<%@include file="/WEB-INF/admin/includeBox.jsp" %>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">角色编辑</a></li>
		</ul>
	</div>
	<div class="formbody">
	    <div class="formtitle"><span>用户绑定</span></div>
	    <form action="roleAction!bindUser.action" method="post" id="pform" >
	    	<input type="hidden"  name="vo.id" id="ids" value="${vo.id }"/>
		    <table class="tablelist">
				<thead>
					<tr>
						<th><input name="" type="checkbox" value=""   onclick="checkAll(this)"  />
						</th>
						<th>登录名</th>
						<th>姓名</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="#request.list">
						<tr>
							<td><input name="" type="checkbox" value="${id }" <s:if test="checked">checked</s:if> /></td>
							<td>${lname }</td>
							<td>${uname }</td>
						</tr>
					</s:iterator>
				</tbody>
			</table></br>
			<ul class="forminfo">
				<li>
			    	<label>&nbsp;</label><input name="" type="button" class="btn" value="绑定" onclick="bindUser('bindForm')"/>
			    	<label>&nbsp;</label><a href="javascript:void(0);"  onclick="back()" class="tablelink">返回</a>
			    </li>
			</ul>
	    </form>
    </div>
</body>
</html>
