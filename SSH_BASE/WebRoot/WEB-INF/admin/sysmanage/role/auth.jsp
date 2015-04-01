  <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
  <script type="text/javascript" src="<%=request.getContextPath()%>/tree/jquery.ztree.core-3.5.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/tree/jquery.ztree.excheck-3.5.js"></script>
<link href="<%=request.getContextPath() %>/tree/zTreeStyle.css" rel="stylesheet" type="text/css" />
  <div id="auth" style="display:none;">
  	<div class="tip">
		<div class="tiptop">
			<span>权限设置</span>
			<a href="javascript:void(0);" title="点击关闭" onclick="hiddenDiv('auth');"></a>
		</div>
		<div class="tipinfo" style="">
			<ul id="tree" class="ztree" ></ul>
		</div>
		<div class="tipbtn">
			<input name="" type="button" class="sure hiddenAlert" value="确定"  onclick="saveAuth();"  />&nbsp; 
		</div>
	</div>
    <%--<div class="pop-all">&nbsp;</div>
    <div class="pop" style="z-index: 10000;width: 250px;left:45%;top:15%;">
    	<h2><label>权限设置</label> <a href="javascript:void(0);" title="点击关闭" onclick="hiddenDiv('auth');"></a></h2>
        <div class="popmain">
			<ul id="tree" class="ztree" ></ul>
			<div class="popbottm">
				<input name="" type="button" class="button hiddenAlert" value="确定" onclick="saveAuth();" />
			</div>
        </div>
    </div>
    --%><div class="modal_window">
	</div>
    </div>
<script type="text/javascript">
	var zNodes;
	var setting = {
		check: {
			enable: true
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	var roleid;
	function openAuth(id){
		var url="roleAction!openAuth.action";
		roleid=id;
		$.ajax({
			clearForm: false,
			url:url,
			data:"vo.id="+id,
			success:function(data){
				zNodes= eval("("+data+")");
				var t = $("#tree");
	      		t = $.fn.zTree.init(t, setting, zNodes);
	      		var target=document.getElementById("auth");
     			target.style.display="block";
	      		//centreDiv("auth");
	        }
		});
	}
	function saveAuth(){
		var zTree = $.fn.zTree.getZTreeObj("tree");
		var obj=zTree.getCheckedNodes(true);
		var ids="";
		for(var i=0;i<obj.length;i++){
			var o=obj[i];
			var id=o.ids;
			if(typeof(id)!="undefined" && id!=""){
				ids+=id+",";
			}
		}
		var url="roleAction!saveAuth.action";
		$.ajax({
			clearForm: false,
			url:url,
			data:"id="+ids+"&vo.id="+roleid,
			success:function(data){
				hiddenDiv("auth");
				var json = eval("("+data+")");
        		if(json.status==1){//1表示成功
        			CAlert(json.msg);
        		}
	        }
		});
	}
</script>