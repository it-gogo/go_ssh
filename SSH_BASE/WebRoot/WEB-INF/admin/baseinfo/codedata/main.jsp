<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>后台菜单管理</title>
    <%@include file="/WEB-INF/admin/head.jsp" %>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/baseinfo/codedata.js"></script>
  </head>
  
  <body>
   <table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="147" valign="top" style="border-right:#d3dbde solid 1px;"  >
    	<%@include file="/WEB-INF/admin/tree.jsp" %>
    </td>
    <td valign="top">
    	<iframe height="100%" width="100%" border="0" frameborder="0" src="codedataAction!findList.action" name="dataFrame" id="dataFrame" title="rightFrame"></iframe>
    </td>
  </tr>
</table>
  </body>
</html>