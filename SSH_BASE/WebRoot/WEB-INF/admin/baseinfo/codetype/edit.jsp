<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<title>后台菜单编辑</title>
<%@include file="/WEB-INF/admin/head.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/baseinfo/codetype.js"></script>
</head>
<body>
	<%@include file="/WEB-INF/admin/includeBox.jsp" %>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">数据类型编辑</a></li>
		</ul>
	</div>
	<div class="formbody">
	    <div class="formtitle"><span>基本信息</span></div>
	    <form action="codetypeAction!savexx.action" method="post" id="pform"  >
	    <input type="hidden"  name="vo.id" id="ids" value="${vo.id }"/>
	    <ul class="forminfo">
		    <li>
		    	<label>名称<b>*</b></label>
				<input type="text" name="vo.tname" class="dfinput requires" value="${vo.tname }"  />
		    </li>
		    <li>
		    	<label>编码<b>*</b></label>
				<input type="text" name="vo.code" class="dfinput requires" value="${vo.code }"    />
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
</html>
