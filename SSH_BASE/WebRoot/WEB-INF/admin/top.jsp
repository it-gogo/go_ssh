<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/admin/head.jsp" %>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>


</head>

<body style="background:url(<%=request.getContextPath() %>/css/admin/images/topbg.gif) repeat-x;">

    <div class="topleft">
    <a href="main.html" target="_parent"><img src="<%=request.getContextPath() %>/css/admin/images/logo.png" title="系统首页" /></a>
    </div>
        
    <%--<ul class="nav">
	    <li><a href="default.html" target="rightFrame" class="selected"><img src="<%=request.getContextPath() %>/css/admin/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
	    <li><a href="imgtable.html" target="rightFrame"><img src="<%=request.getContextPath() %>/css/admin/images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
	    <li><a href="imglist.html"  target="rightFrame"><img src="<%=request.getContextPath() %>/css/admin/images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
	    <li><a href="tools.html"  target="rightFrame"><img src="<%=request.getContextPath() %>/css/admin/images/icon04.png" title="常用工具" /><h2>常用工具</h2></a></li>
	    <li><a href="computer.html" target="rightFrame"><img src="<%=request.getContextPath() %>/css/admin/images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>
	    <li><a href="tab.html"  target="rightFrame"><img src="<%=request.getContextPath() %>/css/admin/images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
    </ul>
    --%>
    <div class="topright">    
    <ul>
    <li><span><img src="<%=request.getContextPath() %>/css/admin/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    <li><a href="../loginAction!toLogin.action" target="_parent">退出</a></li>
    </ul>
    <div class="user">
    <span>[账号:${hloginInfo.lname }&nbsp;&nbsp;&nbsp;姓名:${hloginInfo.uname }]</span>
    <%--<i>消息</i>
    <b>5</b>
    --%>
    </div>    
    </div>
</body>
</html>

