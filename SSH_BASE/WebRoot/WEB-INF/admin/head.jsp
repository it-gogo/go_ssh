<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD  HTML   4.01  Transitional//EN">


<title>无标题文档</title>
<link href="<%=request.getContextPath() %>/css/admin/style.css" rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath() %>/css/admin/select.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath() %>/js/jquery.js"></script>
<script language="JavaScript" src="<%=request.getContextPath() %>/js/admin/select-ui.min.js"></script>
<script language="JavaScript" src="<%=request.getContextPath() %>/js/admin/common.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
      $.ajaxSetup ({
    	  global: false,
         cache: false //关闭AJAX相应的缓存
      });
  });
</script>