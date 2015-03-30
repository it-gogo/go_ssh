<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="pagin">
	<div class="message">
		共<i class="blue">${pageBean.allRow}</i>条记录，当前显示第&nbsp;<i class="blue">${pageBean.curentPage}&nbsp;</i>页，共 <strong>${pageBean.totalPage}</strong> 页
	</div>
	<ul class="paginList">
		<s:if test="pageBean.hasPreviousPage">
			<li class="paginItem">
				<a href="javascript:void(0);" onclick="findPage('${pageUrl}','${pageBean.curentPage-1 }');">
					<span class="pagepre"></span>
				</a>
			</li>
		</s:if>
		<s:iterator begin="1" end="pageBean.totalPage" status="i">
			<s:if test="(#i.index+1)==pageBean.curentPage">
				<li class="paginItem current"><a href="javascript:void(0);">${pageBean.curentPage }</a></li>
			</s:if>
			<s:else>
				<li class="paginItem"><a href="javascript:void(0);" onclick="findPage('${pageUrl}','${i.index+1 }');">${i.index+1 }</a></li>
			</s:else>
		</s:iterator>
		<%--<li class="paginItem"><a href="javascript:;">1</a></li>
		<li class="paginItem current"><a href="javascript:;">2</a></li>
		<li class="paginItem"><a href="javascript:;">3</a></li>
		<li class="paginItem"><a href="javascript:;">4</a></li>
		<li class="paginItem"><a href="javascript:;">5</a></li>
		<li class="paginItem more"><a href="javascript:;">...</a></li>
		<li class="paginItem"><a href="javascript:;">10</a></li>
		--%><s:if test="pageBean.hasNextPage">
			<li class="paginItem">
				<a href="javascript:void(0);" onclick="findPage('${pageUrl}','${pageBean.curentPage+1 }');">
					<span class="pagenxt"></span>
				</a>
			</li>
		</s:if>
	</ul>
</div>



<%--<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td width="33%"><div align="left"><span class="STYLE22">&nbsp;&nbsp;&nbsp;&nbsp;共有<strong> ${pageBean.allRow}</strong> 条记录，当前第<strong> ${pageBean.curentPage}</strong> 页，共 <strong>${pageBean.totalPage}</strong> 页</span></div></td>
    <td width="67%"><table width="312" border="0" align="right" cellpadding="0" cellspacing="0">
      <tr>
        <td width="49">
        	<div align="center">
        		<a href="javascript:void(0);" onclick="findPage('${pageUrl}',1);" >
        			<img src="<%=request.getContextPath() %>/images/first.gif" width="40" height="15" />
        		</a>
        	</div>
        </td>
        <s:if test="pageBean.hasPreviousPage">
	        <td width="49">
	        	<div align="center">
	        		<a href="javascript:void(0);" onclick="findPage('${pageUrl}','${pageBean.curentPage-1 }');">
	        			<img src="<%=request.getContextPath() %>/images/back.gif" width="45" height="15" />
	        		</a>
	        	</div>
	        </td>
        </s:if>
        <s:if test="pageBean.hasNextPage">
        <td width="49">
	        <div align="center">
		        <a href="javascript:void(0);" onclick="findPage('${pageUrl}','${pageBean.curentPage+1 }');">
		        	<img src="<%=request.getContextPath() %>/images/next.gif" width="45" height="15" />
		        </a>
	        </div>
        </td>
        </s:if>
        <td width="49">
	        <div align="center">
		        <a href="javascript:void(0);" onclick="findPage('${pageUrl}','${pageBean.totalPage }');">
		        	<img src="<%=request.getContextPath() %>/images/last.gif" width="40" height="15" />
		        </a>
	        </div>
        </td>
        <td width="37" class="STYLE22"><div align="center">转到</div></td>
        <td width="22"><div align="center">
          <input type="text"  id="pagetext"  style="width:20px; height:12px; font-size:12px; border:solid 1px #7aaebd;" onkeyup="this.value=this.value.replace(/\D/g,'')"  onafterpaste="this.value=this.value.replace(/\D/g,'')"/>
        </div></td>
        <td width="22" class="STYLE22"><div align="center">页</div></td>
        <td width="35">
        	<a href="javascript:void(0);" onclick="findPageToInput('${pageUrl}','${pageBean.totalPage }');">
        		<img src="<%=request.getContextPath() %>/images/go.gif" width="26" height="15" />
        	</a>
        </td>
      </tr>
    </table></td>
  </tr>
</table>
--%>
<script type="text/javascript">
function findPage(url,page){
	if(page==0){
		page=1;
	}
	if(url.indexOf("?")<0){
		location.href=url+"?curPage="+page;
	}else{
		location.href=url+"&curPage="+page;
	}
}
function findPageToInput(url,totalPage){
	var obj=$("#pagetext").get(0);
	var page=obj.value;
	if(page==""){
		page=1;
	}else{
		page=parseInt(page);
	}
	if(page<1){
		page=1;
		obj.value=1;
	}else if(page>totalPage){
		page=totalPage;
		obj.value=totalPage;
	}
	if(url.indexOf("?")<0){
		location.href=url+"?curPage="+page;
	}else{
		location.href=url+"&curPage="+page;
	}
}
</script>