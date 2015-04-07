<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>轮播管理编辑</title>
	<%@include file="/WEB-INF/admin/head.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/webmanage/carousel.js"></script>
	
  </head>
  
  <body>
  
  <%@include file="/WEB-INF/admin/includeBox.jsp" %>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">轮播编辑</a></li>
		</ul>
	</div>
	<div class="formbody">
	    <div class="formtitle"><span>基本信息</span></div>
	    <form action="buserAction!savexx.action" method="post" id="pform" >
	    	<input type="hidden"  name="vo.id" id="ids" value="${vo.id }"/>
    		<input type="hidden"  name="vo.content" id="content" value="${vo.content }"/>
		    <ul class="forminfo">
			    <li>
			    	<label>标题<b>*</b></label>
			    	<input type="text" name="vo.name" class="dfinput requires" value="${vo.name }" onblur="checkNotEmtry(this,50)"  />
			    </li>
			    <li>
			    	<label>编码<b>*</b></label>
					<input type="text" name="vo.code" class="dfinput requires" value="${vo.code }" onblur="checkCode(this,50)"   />
			    </li>
			    <li>
			    	<label>图片轮播：</label>
			    	<s:if test="#request.arr==null">
             		<div class="file-box" >
						图片地址：<input type="text" class="dfinput imgurl" readonly="readonly"    value=""      />
						<input type='button' class='btn button' value='预览' onclick="openFileSpace($(this).prev());"  /> 
						<input type='button' class='btn button' value='查看' onclick="lookFileSpace($(this).prev().prev());"  /> 
						<input type='button' class='button' value='清空' onclick="$(this).prev().prev().prev().val('');"  /> 
						</br>
						连接地址：<input type="text" class="dfinput aurl"    value=""  style="width: 60%" /> 
	                    <input type='button' class='btn button' value='删除' onclick="deleteFile(this);"  /> 
	    			</div>
             	</s:if>
             	<s:else>
	    			<s:iterator value="#request.arr">
		             	<div class="file-box" >
							图片地址：<input type="text" class="dfinput imgurl"  readonly="readonly"    value="${imgurl }"   style="width: 60%"    />
							<input type='button' class='btn button' value='预览' onclick="openFileSpace($(this).prev());"  /> 
							<input type='button' class='btn button' value='查看' onclick="lookFileSpace($(this).prev().prev());"  /> 
							<input type='button' class='button' value='清空' onclick="$(this).prev().prev().prev().val('');"  /> 
							</br>
							连接地址：<input type="text" class="dfinput aurl"    value="${aurl }"   style="width: 60%"    /> 
		                    <input type='button' class='btn button' value='删除' onclick="deleteFile(this);"  /> 
		    			</div>
	    			</s:iterator>
             	</s:else>
			    </li>
			    <li>
			    	<label>宽度</label>
					<input type="text" name="vo.width" class="dfinput " value="${vo.width }" onblur="checkIsNumber(this,10)"   />
			    </li>
			    <li>
			    	<label>高度</label>
					<input type="text" name="vo.height" class="dfinput " value="${vo.height }" onblur="checkIsNumber(this,10)"   />
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
  </body>
</html>
