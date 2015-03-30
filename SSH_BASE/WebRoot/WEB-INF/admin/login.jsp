<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申博后台管理系统</title>
<%@include file="/WEB-INF/admin/head.jsp" %>
<script language="JavaScript" src="<%=request.getContextPath() %>/js/admin/cloud.js"></script>
<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 
</head>

<body style="background-color:#1c77ac; background-image:url('<%=request.getContextPath() %>/css/admin/images/light.png'); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
<%--<div class="logintop">    
    <span>欢迎登录后台管理界面平台</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    --%>
    <form id="loginform" name="loginform" method="post" action="loginAction!login.action">
    <div class="loginbody">
    <span class="systemlogo"></span> 
    <div class="loginbox">
    <ul>
    <li><input name="vo.lname" type="text" class="loginuser" value="${vo.lname }" /></li>
    <li><input name="vo.password" type="password" class="loginpwd" value="${vo.password}"  /></li>
    <li>
    	<input name="" type="submit" class="loginbtn" value="登 录"    />
    	<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label>
    	<label style="color:red;">${msg }</label>
    </li>
    </ul>
    </div>
    </div>
    </form>
    <div class="loginbm">版权所有  2015   IT三人行</div>
</body>
</html>
