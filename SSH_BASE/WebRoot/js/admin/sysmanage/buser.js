/**
 * 返回
 */
function back(){
	location.href="buserAction!findList.action";
}
/**
 * 检测名称
 * @param obj
 * @param length
 */
function checkLname(obj,length){
	if(strlen(obj.value)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		if(check(obj.value!="","此项为必填项！",obj)){
			var url="buserAction!checkLname.action";
			var id=$("#ids").val();
			$.ajax({
				clearForm: false,
				url:url,
				type:"post",
				data:"vo.lname="+obj.value+"&vo.id="+id,
				success:function(data){
					var json=eval("("+data+")");
					check(json.status==1,json.msg,obj);
		        }
			});
		}
	}
}
