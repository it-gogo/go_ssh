<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<title>数据类型列表</title>
	<%@include file="/WEB-INF/admin/includefile.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/sysmanage/qmenu.js"></script>
</head>

<body>
<%@include file="/WEB-INF/admin/includeBox.jsp" %>
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=request.getContextPath() %>/images/tb.gif" width="14" height="14" /></div></td>
                <td width="94%" valign="bottom"><span class="STYLE1"> 数据类型列表</span></td>
              </tr>
            </table></td>
            <td>
            	<div align="right"><span class="STYLE1">
	              &nbsp;&nbsp;<img src="<%=request.getContextPath() %>/images/add.gif" width="10" height="10" />
	              <a href="qmenuAction!addxx.action" style="color: yellow;"> 添加</a>   
	              &nbsp; <img src="<%=request.getContextPath() %>/images/del.gif" width="10" height="10" /> 
	              <a href="javascript:void(0);" onclick="deleteAll('qmenuAction!deletexx.action')" style="color: yellow;">删除</a>
	              &nbsp;&nbsp;<span class="STYLE1"> &nbsp;</span>
				</div>
              </td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
  
   <tr>
     <td height="30">
     	<form action="qmenuAction!searchList.action" method="post" id="searchForm">
	       <table width="100%" border="0" cellspacing="1" cellpadding="0" bgcolor="#a8c7ce">
	          <tr>
	            <td width="7%" align="center" bgcolor="d3eaef" class="STYLE10"><span > 名称</span></td>
	            <td width="15%" align="center"><input type="text" name="mname_like" value="${session.searchparame['mname_like'][0] }"  /></td>
	           
	            <td>
	            	<input type="submit" value="查询" />
	            	<input type="button" value="清空" onclick="clearData('searchForm');" />
	            </td>
	          </tr>
	         
	       </table>
       </form>
     </td>
  </tr>
  
  <tr>
    <td>
      <table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="#a8c7ce">
      <tr>
        <td width="4%" height="20" bgcolor="d3eaef" class="STYLE10"><div align="center">
          <input type="checkbox"   onclick="checkAll(this)" />
        </div></td>
        <td width="10%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">名称</span></div></td>
        <td width="15%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">菜单编码</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">是否启用</span></div></td>
        <td width="14%" height="20" bgcolor="d3eaef" class="STYLE6"><div align="center"><span class="STYLE10">基本操作</span></div></td>
      </tr>
      <c:forEach items="${pageBean.list}" var="vo">
      <tr>
        <td height="20" bgcolor="#FFFFFF">
         <div align="center">
          <input type="checkbox"  value="${vo.id }"   />
         </div>
        </td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE6"><div align="center"><span class="STYLE19">${vo.mname}</span></div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19"><div align="center">${vo.menucode}</div></td>
        <td height="20" bgcolor="#FFFFFF" class="STYLE19">
        	<div align="center">
        		<c:if test="${vo.isactives==1 }">是</c:if>
        		<c:if test="${vo.isactives==0 }">否</c:if>
        	</div>
        </td>
        <td height="20" bgcolor="#FFFFFF">
        	<div align="center" class="STYLE21">
        		<a href="javascript:void(0);" onclick="deleteOne('${vo.id}','qmenuAction!deletexx.action');">删除</a> | 
        		<a href="qmenuAction!updatexx.action?id=${vo.id}">修改</a> | 
        		<a href="javascript:void(0);" onclick="changeStatus('${vo.id}','${vo.isactives }','qmenuAction!changeStatus.action');">
        			<c:if test="${vo.isactives==0 }">启用</c:if>
        			<c:if test="${vo.isactives==1 }">禁用</c:if>
        		</a>
        	</div></td>
      </tr>
    </c:forEach>
    </table>
    </td>
  </tr>
  <tr>
    <td height="30">
      <%@include file="/WEB-INF/admin/page.jsp" %>
    </td>
  </tr>
</table>
</body>
</html>
