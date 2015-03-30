<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>申博</title>
</head>

<body>
<div class="expired" >
	<h2>
        <span>
        <img align="absmiddle" src="<%=request.getContextPath() %>/errors/images/expired.png">
        </span>
        SESSION已经过期，请重新登录！<a href="javascript:void(0)"  onclick="tologin()" > 请登录</a>
	</h2>
</div>
</body>
</html>
<script>
 
 function tologin(){
     top.location.href='<%=request.getContextPath()%>/admin';
 }
</script>