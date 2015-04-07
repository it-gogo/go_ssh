/**
 * 返回
 */
function back(){
	location.href="carouselAction!findList.action";
}
/**
 * 删除图片删除
 * @param obj
 */
function deleteFile(obj){
	if($(".file-box").size()==1){
		CAlert("至少保留一张图片功能。");
		return false;
	}
	$(obj).parent().remove();
}
/**
 * 添加图片上传
 */
function addFile(){
	var html="<div class=\"file-box\" >图片地址：<input type=\"text\" class=\"input imgurl\"  readonly=\"readonly\"  name=\"\" value=\"\" style=\"width:60%;\" /> <input type=\"button\" class=\"button\" value=\"预览\" onclick=\"openFileSpace($(this).prev());\"  /> <input type=\"button\" class=\"button\" value=\"查看\" onclick=\"lookFileSpace($(this).prev().prev());\"  /> <input type=\"button\" class=\"button\" value=\"清空\" onclick=\"$(this).prev().prev().prev().val('');\"  />  </br>  连接地址：<input type=\"text\" class=\"input aurl\" name=\"\" value=\"\"  style=\"width:60%;\"  /> <input type=\"button\" class=\"btn button\" value=\"删除\" onclick=\"deleteFile(this);\"  /></div>";
	$("#moreFile").append(html);
}

/**
 * 保存
 */
function save(formid){
	var $obj=$(".requires");//必填项
	for(var i=0;i<$obj.size();i++){
		if($obj.eq(i).val()==""){
			if($obj.eq(i).hasClass("Wdate")){
				CAlert("请选择日期填写！");
			}else{
				$obj.eq(i).focus();
			}
			return false;
		}
	}
	if($(".check").size()!=0){
		return false;
	}
	
	var $obj=$(".file-box");//图片
	var array = new Array();
	for(var i=0;i<$obj.size();i++){
		var  queStr = new Object();
		var obj=$obj.eq(i);
		var imgurl=obj.find("input.imgurl").val();
		var aurl=obj.find("input.aurl").val();
		queStr["imgurl"] = imgurl;
	     queStr["aurl"] = aurl;
	     array[array.length] = queStr;
	}
	$("#content").val($.toJSON(array));
	
	if(typeof(formid)=="undefined" || formid==""){
		formid="pform";
	}
	initForm(formid);
	$("#"+formid).submit();
}

function checkCode(obj,length){
	if(strlen(obj.value)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		if(check(obj.value!="","此项为必填项！",obj)){
			var url="carouselAction!checkCode.action";
			var id=$("#ids").val();
			$.ajax({
				clearForm: false,
				url:url,
				type:"post",
				data:"vo.code="+obj.value+"&vo.id="+id,
				success:function(data){
					var json=eval("("+data+")");
					check(json.status==1,json.msg,obj);
		        }
			});
		}
	}
}