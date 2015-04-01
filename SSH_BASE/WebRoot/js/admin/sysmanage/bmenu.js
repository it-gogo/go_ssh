/**
 * 返回
 */
function back(){
	location.href="bmenuAction!findList.action";
}
//请求菜单树的URL
var treeurl = "bmenuAction!findTree.action";
//请求菜单树的参数
var treeopt = {};

var addxx = function(){
	var pmcode = $("#pmcode").val();
	location.href = "bmenuAction!addxx.action?vo.pmcode="+pmcode;
};


//点击之前
var treebeforeClick = function(treeId, treeNode, clickFlag){
	var iframeObj = $("#dataFrame");
	var pId = treeNode.id;
	//alert(pId);
	if(treeNode.isParent){
		if(pId==0){
			pId="";
		}
		iframeObj.attr("src","bmenuAction!searchList.action?pmcode_right="+pId+"&or_mcode_right="+pId);
	}else{
		iframeObj.attr("src","bmenuAction!searchList.action?pmcode_right="+pId+"&or_mcode_right="+pId);
	}
};
//树点击事件
var treeOnClick = function(treeId, treeNode, clickFlag){
};
