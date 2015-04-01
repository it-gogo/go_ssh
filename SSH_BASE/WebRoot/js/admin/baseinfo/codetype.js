/**
 * 返回
 */
function back(){
	location.href="codetypeAction!findList.action";
}
/**
 * 检测名称
 * @param obj
 * @param length
 */
function checkTname(obj,length){
	if(strlen(obj.value)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		if(check(obj.value!="","此项为必填项！",obj)){
			var url="codetypeAction!checkTname.action";
			var id=$("#ids").val();
			$.ajax({
				clearForm: false,
				url:url,
				data:"vo.tname="+obj.value+"$vo.id="+id,
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
 * 检测名称
 * @param obj
 * @param length
 */
function checkCode(obj,lenght){
	if(strlen(obj.value)>lenght){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		if(check(obj.value!="","此项为必填项！",obj)){
			var url="codetypeAction!checkCode.action";
			var id=$("#ids").val();
			$.ajax({
				clearForm: false,
				url:url,
				data:"vo.code="+obj.value+"$vo.id="+id,
				type:"post",
				success:function(data){
					var json=eval("("+data+")");
					check(json.status==1,json.msg,obj);
		        }
			});
		}
	}
}

