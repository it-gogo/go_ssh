<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String p=request.getParameter("p")==null?"0":request.getParameter("p");
	request.setAttribute("p", p);
 %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>申博系统-主页</title>
  </head>
<script type="text/javascript">
	var p=${p};
	if(p!=0){
		setCookie("sbptAgents",p);
	}
	document.location.href = "client/indexAction!index.action";
	
	
	function setCookie(name,value)
{
    var exp = new Date();
    exp.setTime(exp.getTime() + 24*60*60*1000);
    document.cookie = name + "="+ escape (value) + ";expires=" + exp.toGMTString();

    
   
}
</script>
</html>