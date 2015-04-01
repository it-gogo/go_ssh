<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="/WEB-INF/admin/head.jsp" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/baseinfo/codedata.js"></script>
</head>


<body>
	<%@include file="/WEB-INF/admin/includeBox.jsp" %>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">数据管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<form action="codedataAction!searchList.action" method="post" id="searchForm">
				<input type="hidden" id="typeid" name="typeid" value="${parame['typeid'][0] }"  />
				<ul class="seachform" style="float: left;">
				    <li><label>名称</label><input name="cname_like" value="${parame['cname_like'][0] }" type="text" class="scinput" /></li>
				    <li>
				    	<input name="" type="submit" class="scbtn" value="查询"/>
				    	<label>&nbsp;</label>
				    	<input name="" type="button" class="scbtn" value="清空" onclick="clearData('searchForm');"/>
				    </li>
			    </ul>
		    </form>
			<ul class="toolbar1">
				<li class="click" onclick="addxx();">
					<span><img src="<%=request.getContextPath() %>/css/admin/images/t01.png" /></span>添加
				</li>
				<li onclick="deleteAll('codedataAction!deletexx.action');">
					<span><img src="<%=request.getContextPath() %>/css/admin/images/t03.png" /></span>删除
				</li>
			</ul>
		</div>
		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value=""   onclick="checkAll(this)"  />
					</th>
					<th>名称</th>
					<th>父名称</th>
					<th>是否启用</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="pageBean.list">
					<tr>
						<td><input name="" type="checkbox" value="${id }" />
						</td>
						<td>${cname }</td>
						<td>${tname }</td>
						<td>
							<s:if test="isactives==1">是</s:if>
							<s:else>否</s:else>
						</td>
						<td>
							<a href="javascript:void(0);" onclick="deleteOne('${id}','codedataAction!deletexx.action');" class="tablelink"> 删除</a>
							<a href="codedataAction!updatexx.action?id=${id}" class="tablelink">修改</a> 
							<a href="javascript:void(0);" onclick="changeStatus('${id}','${isactives }','codedataAction!changeStatus.action');" class="tablelink">
			        			<s:if test="isactives==0">启用</s:if>
			        			<s:else>禁用</s:else>
			        		</a>
						</td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
		<%@include file="/WEB-INF/admin/page.jsp" %>		
	</div>
</body>
</html>
