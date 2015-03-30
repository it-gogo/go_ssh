<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>数据类型编辑</title>
	<%@include file="/WEB-INF/admin/includefile.jsp" %>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/admin/sysmanage/qmenu.js"></script>
	<style>
	/*file上传文件样式*/
	.file-box{ position:relative;/* width:720px; */display: block;margin: 5px;} 
	.txt{position:relative; top:-2.5px; height:22px; border:1px solid #cdcdcd; width:180px;} 
	.btn{} 
	.file{ position:absolute; top:0; left:/* 44 */189px; height:24px; filter:alpha(opacity:0);opacity: 0;width:91px;border:1px solid red;} 
	</style>
  </head>
  
  <body>
  <%@include file="/WEB-INF/admin/includeBox.jsp" %>
  <table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="24" bgcolor="#353c44">
        	<table width="100%" border="0" cellspacing="0" cellpadding="0">
	          <tr>
	            <td>
	            	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		              <tr>
		                <td width="6%" height="19" valign="bottom"><div align="center"><img src="<%=request.getContextPath() %>/images/tb.gif" width="14" height="14" /></div></td>
		                <td width="94%" valign="bottom"><span class="STYLE1"> 编辑数据类型----图片轮播（单张图片宽高：982X217，多张宽高：980X420）</span></td>
		              </tr>
		            </table>
	            </td>
	            <%--<td>
	            	<div align="right">
	            		<span class="STYLE1">
		            		<img src="<%=request.getContextPath() %>/images/add.gif" width="10" height="10" />
		            		<a href="javascript:addFile();"  style="color: yellow;"> 添加上传图片</a>   &nbsp; 
	            		</span>
              	</div>
	            </td>--%>
	          </tr>
	        </table>
        </td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td>
    <div class="declaration_index">
    <form action="qmenuAction!savexx.action" method="post" id="pform" enctype="multipart/form-data">
    <input type="hidden"  name="vo.id" id="ids" value="${vo.id }"/>
    <%--<input type="hidden"  name="vo.remark"   id="content"/>
    --%><table width="100%" border="0" cellspacing="0" cellpadding="0" class="tableT_add" align="center">
        <tr>
            <th align="right"><em>*</em>名称：</th>
            <td align="left"><input type="text" name="vo.mname" class="input requires" value="${vo.mname }" onblur="checkMname(this,50)"  /></td>
         </tr>
         <tr>
             <th align="right"><em>*</em>菜单编码：</th>
             <td align="left"><input type="text" name="vo.menucode" class="input requires" value="${vo.menucode }" onblur="checkMenucode(this,50)"   /></td>
         </tr>
         <tr>
             <th align="right">轮播：</th>
             <td align="left">
            	<select name="vo.urls" style="width: 180px;" >
            		<c:forEach items="${list }" var="carousel" >
	            		<option value="${carousel.id }" <c:if test="${vo.urls==carousel.id }">selected="selected"</c:if> >${carousel.name }</option>
            		</c:forEach>
            	</select>
            </td>
         </tr>
         <%-- <tr>
             <th align="right"><em>*</em>连接地址：</th>
             <td align="left"><input type="text" name="vo.urls" class="input requires" value="${vo.urls }" onblur="checkNotEmtry(this,100)"   /></td>
         </tr>
          <tr>
             <th align="right">排序：</th>
             <td align="left"><input type="text" name="vo.seq" class="input " value="${vo.seq }" onblur="checkIsNumber(this,20)"   /></td>
         </tr> --%>
         <%--<tr>
             <th align="right">图片轮播：</th>
             <td align="left" id="moreFile">
             	<c:if test="${iconarr==null }">
             		<div class="file-box" >
							<input type='text' class='txt' name="iconarr"  value="" /> 
							<input type='button' class='btn button' value='浏览...' /> 
		                    <input name="icon" type="file" class="file" value="上传头像" onchange="selectFile(this);" /> 
		                     <input type="hidden" name="vo.icon" value="${vo.icon}" > 
		                    <input type='button' class='btn button' value='删除' onclick="deleteFile(this);"  /> 
		    			</div>
             	</c:if>
             	<c:if test="${iconarr!=null }">
	    			<c:forEach items="${iconarr }" var="arr" >
		             	<div class="file-box" >
							<input type='text' class='txt' name="iconarr"  value="${arr}" /> 
							<input type='button' class='btn button' value='浏览...' /> 
		                    <input name="icon" type="file" class="file" value="上传头像" onchange="selectFile(this);" /> 
		                     <input type="hidden" name="vo.icon" value="${vo.icon}" > 
		                    <input type='button' class='btn button' value='历史图片' onclick="findPicturerecord(this,'TQMENU',1);"  /> 
		                    <input type='button' class='btn button' value='删除' onclick="deleteFile(this);"  /> 
		                    <input type='button' class='btn button' value='查看' onclick="lookImg('${arr}');"  /> 
		    			</div>
	    			</c:forEach>
             	</c:if>
             </td>
         </tr>  --%>
        <%-- <tr>
             <th align="right">选中图标：</th>
             <td align="left">
             	<input type="file" name="selecticon" class="input"  value="${vo.selecticon }"   />
             	<input type="hidden" name="vo.selecticon" class="input" value="${vo.selecticon}"   />
             	<div class="file-box" >
					<input type='text' class='txt'  value="${vo.selecticon}" /> 
					<input type='button' class='btn button' value='浏览...' /> 
                    <input name="selecticon" type="file" class="file" value="上传头像" onchange="selectFile(this);" /> 
                    <input type="hidden" name="vo.selecticon" value="${vo.selecticon}" >
                   <!-- <input name="" type="button" class="button" value="上传" onclick="load(this,'formid');"/> -->
    			</div>
             </td>
         </tr> --%>
         <tr>
             <th align="right">备注：</th>
             <td align="left"  style="white-space:normal;">
	              <textarea   name="vo.remark"style="width:500px;height: 50px;" >${vo.remark }</textarea>
              </td>
         </tr>
          <tr>
             <th align="right"><em>*</em>启用禁用：</th>
             <td align="left">
	              <input type="radio" name="vo.isactives"    checked="checked" value="1"/>启用
	              <input type="radio" name="vo.isactives"  <c:if test="${vo.isactives==0 }">checked="checked"</c:if>    value="0" />禁用
              </td>
         </tr>
      </table>
      </form>
      </div>
        <div class="button_div">
           <span><input  type="button" class="button" value="保 存" onclick="save('pform')"/></span>
           <!-- <span><input  type="button" class="button" value="保 存" onclick="javascript:$('#pform').submit();"/></span> -->
           <span><input  type="button" class="button" value="返 回" onclick="back()"/></span>
        </div>
               
      </td>
      </tr>
      </table>
  </body>
</html>
