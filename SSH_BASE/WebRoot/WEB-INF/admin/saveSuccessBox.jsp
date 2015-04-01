  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <div id="saveSuccess" style="display:none;">
  	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span>
			<a href="javascript:void(0);" title="点击关闭" onclick="hiddenSaveSuccess();"></a>
		</div>
		<div class="tipinfo">
			<span><img src="<%=request.getContextPath() %>/css/admin/images/ticon.png" />
			</span>
			<div class="tipright">
				<p id="saveSuccessText">是否确认对信息的修改 ？</p>
			</div>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure" value="确定"  onclick="hiddenSaveSuccess();"  />&nbsp; 
		</div>
	</div>
    <%--<div class="pop-all">&nbsp;</div>
    <div class="pop" style="z-index: 100000;">
    	<h2><label>提示</label> <a href="javascript:void(0);" title="点击关闭" onclick="hiddenSaveSuccess();"></a></h2>
        <div class="popmain">
			<p class="center">
				<img src="<%=request.getContextPath() %>/images/ok.gif" align="absmiddle"/> 
				<span id="saveSuccessText">
					保存成功
				</span>
			</p>
			<div class="popbottm">
				<input name="" type="button" class="button" value="确定" onclick="hiddenSaveSuccess();" />
			</div>
        </div>
    </div>
    --%><div class="modal_window">
	</div>
    </div>
<script type="text/javascript">
function hiddenSaveSuccess(){
	hiddenDiv("saveSuccess");
	back();
}
function saveSuccess(msg){
	showDiv("saveSuccess");
     centreDiv("saveSuccess");
     if(typeof(msg)=="undefined" || msg==""){
		msg="保存成功";
	}
	$("#saveSuccessText").text(msg);
	return;
}
</script>