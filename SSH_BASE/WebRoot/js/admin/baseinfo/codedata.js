/**
 * 返回
 */
function back(){
	var typeid=$("#typeid").val();
	location.href="codedataAction!findList.action?typeid="+typeid;
}

//请求菜单树的URL
var treeurl = "codedataAction!getCodetypeTree.action";
//请求菜单树的参数
var treeopt = {};
//点击之前
var treebeforeClick = function(treeId, treeNode, clickFlag){
	var iframeObj = $("#dataFrame");
	var pId = treeNode.id;
	//alert(pId);
	if(treeNode.isParent){
		if(pId==0){
			pId="";
		}
		iframeObj.attr("src","codedataAction!searchList.action?typeid="+pId);
	}else{
		iframeObj.attr("src","codedataAction!searchList.action?typeid="+pId);
	}
};
//树点击事件
var treeOnClick = function(treeId, treeNode, clickFlag){
};

/**
 * 检测名称
 * @param obj
 * @param length
 */
function checkCname(obj,length,typecode){
	if(strlen(obj.value)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		if(check(obj.value!="","此项为必填项！",obj)){
			var url="codedataAction!checkCname.action";
			var id=$("#ids").val();
			$.ajax({
				clearForm: false,
				url:url,
				data:"vo.cname="+obj.value+"&vo.typecode="+typecode+"&vo.id="+id,
				type:"post",
				success:function(data){
					var json=eval("("+data+")");
					check(json.status==1,json.msg,obj);
		        }
			});
		}
	}
}
/**
 * 检测编码
 * @param obj
 * @param length
 */
function checkCode(obj,length,typecode){
	if(strlen(obj.value)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		if(obj.value!=""){
			var url="codedataAction!checkCode.action";
			var id=$("#ids").val();
			$.ajax({
				clearForm: false,
				url:url,
				data:"vo.code="+obj.value+"&vo.typecode="+typecode+"&vo.id="+id,
				type:"post",
				success:function(data){
					var json=eval("("+data+")");
					check(json.status==1,json.msg,obj);
		        }
			});
		}
	}
}
/**
 * 添加
 * @param typecode
 */
function addxx(typecode){
	if(typeof(typecode)=="undefined" || typecode==""){
		CAlert("请先选择数据类型。");
	}else{
		location.href="codedataAction!addxx.action?typecode="+typecode;
	}
}

