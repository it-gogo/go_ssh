  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <div id="alert" style="display:none;">
  	<div class="tip">
		<div class="tiptop">
			<span>提示信息</span>
			<a href="javascript:void(0);" title="点击关闭" onclick="hiddenAlert();"></a>
		</div>
		<div class="tipinfo">
			<span><img src="<%=request.getContextPath() %>/css/admin/images/ticon.png" />
			</span>
			<div class="tipright">
				<p id="alertText">是否确认对信息的修改 ？</p>
			</div>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure hiddenAlert" value="确定"  onclick="hiddenAlert();" />
		</div>
	</div>
    <%--<div class="pop-all">&nbsp;</div>
    <div class="pop" style="z-index: 100000;">
    	<h2><label>提示</label> <a href="javascript:void(0);" title="点击关闭" onclick="hiddenAlert();"></a></h2>
        <div class="popmain">
			<p class="center" id="alertText">
			</p>
			<div class="popbottm">
				<input name="" type="button" class="button hiddenAlert" value="确定" onclick="hiddenAlert();" />
			</div>
        </div>
    </div>
    --%><div class="modal_window">
	</div>
    </div>
<script type="text/javascript">
function CAlert(msg,success){
	var target=document.getElementById("alert");
     target.style.display="block";
     centreDiv("alert");
	$("#alertText").text(msg);
	if(typeof(success)=="function"){
		$(".hiddenAlert").click(function(){
			hiddenAlert();
			success();
		});
	}
	return;
}
function hiddenAlert(){
     var target=document.getElementById("alert");
     target.style.display="none";
    // back();
}
</script>