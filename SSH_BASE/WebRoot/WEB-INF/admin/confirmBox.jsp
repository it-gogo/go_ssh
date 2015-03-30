  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div id="confirm" style="display:none;">
    <div class="tip">
		<div class="tiptop">
			<span>提示信息</span>
			<a href="javascript:void(0);" title="点击关闭" onclick="hiddenConfirm();"></a>
		</div>
		<div class="tipinfo">
			<span><img src="<%=request.getContextPath() %>/css/admin/images/ticon.png" />
			</span>
			<div class="tipright">
				<p id="confirmText">是否确认对信息的修改 ？</p>
				<cite>如果是请点击确定按钮 ，否则请点取消。</cite>
			</div>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure runningConfirm" value="确定" />&nbsp; 
			<input name="" type="button" class="cancel errorConfirm" value="取消" onclick="hiddenConfirm();" />
		</div>
	</div>
	<div class="modal_window">
	</div>
</div>
<script type="text/javascript">
function CConfirm(msg,success,error){
	$("#confirm").fadeIn(200);
	$("#confirmText").text(msg);
	$(".runningConfirm").click(function(){
		if(typeof(success)=="function"){
			success();
		}
		hiddenConfirm();
	});
	if(typeof(error)=="function"){
		$(".errorConfirm").click(function(){
			error();
			hiddenConfirm();
		});
	}
	return;
}
//隐藏confirm提示框
function hiddenConfirm(){
	$("#confirm").fadeOut(100);
	$("#confirmText").text("");
	$(".runningConfirm").unbind("click");
	$(".errorConfirm").unbind("click");
}

function runningConfirm(){
	$("#confirm").fadeOut(100);
	$("#confirmText").text("");
}
</script>