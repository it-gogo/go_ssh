


/**
 * 初始化表单提交代码
 * @param formID
 * @returns
 */
var initForm = function(formID){
	$("#"+formID).submit(function() {
        $(this).ajaxSubmit({
        	//clearForm: false,
        	resetForm:true,
        	type:"POST",
        	cache: false,
        	success:function(data){
        		var json = eval("("+data+")");
        		if(json.status==1){//1表示成功
        			saveSuccess(json.msg);
//        			CAlert(json.msg);
        		}else if(json.status==0){//1表示失败
        			$("#"+formID).unbind("submit");
        			CAlert(json.msg);
        		}
        		//alert("保存成功！");
        		return false;
          	}
        }); 
        return false;
	}); 
};

function go(url){
	location.href=url;
}

/**
 \
 * 验证函数
 * @param boolean
 * @param str
 * @param obj
 * @returns {Boolean}
 */
function check(boolean,str,obj){
	$(obj).parent().find(".check").remove();
	if(boolean){
		$(obj).parent().find(".check").remove();
		return true;
	}else{
		if($(obj).parent().find(".check").size()==0){
			$(obj).parent().append("<span class='check' style='color:red;font-size:12px;line-height:24px;'>"+str+"</span>");
		}
		return false;
	}
}
/**
 * 计算文字个字符数
 */
function strlen(str) 
{
 var strlength = 0;
 for (var i=0; i < str.length; ++i)
 {
  if (isChinese(str.charAt(i)) == true)
   strlength = strlength + 2;//中文计算为二个字符
  else
   strlength = strlength + 1;
 }
 return strlength;
}
function isChinese(str)
{
   var lst = /[u00-uFF]/;
   return !lst.test(str);      
}
/**
 * 不能为空，且不能大于length个字符
 * @param obj
 * @param length
 */
function checkNotEmtry(obj,length){
	if(strlen(obj.value)>length){
		return check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		return check(obj.value!="","此项为必填项！",obj);
	}
}
/**
 * 可以为空，且不能大于length个字符
 * @param obj
 * @param length
 */
function checkEmtry(obj,length){
	var str=obj.value;
	if(strlen(str)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		check(str=="" || strlen(str)<=length,"",obj);
	}
}
/**
 * 检测是数字
 * @param obj
 * @param length
 */
function checkIsNumber(obj,length){
	var str=/^[\d]{0,}$/;
	if(strlen(obj.value)>length){
		check(false,"此项字符数不得大于"+length+"个！",obj);
	}else{
		check(str.test(obj.value),"请填写数字类型！",obj);
	}
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
	if(typeof(formid)=="undefined" || formid==""){
		formid="pform";
	}
	initForm(formid);
	$("#"+formid).submit();
}

/**
 * 保存
 */
function savexx(formid){
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
	if(typeof(formid)=="undefined" || formid==""){
		formid="pform";
	}
	$("#"+formid).submit();
}
/**
 * div屏幕居中
 * @param DivId
 */
function centreDiv(DivId) { 
	var div = $("#"+DivId).find(".pop");
	if(div.size()>0){
		Div=div.get(0);
		Div.style.top = ( (document.documentElement.clientHeight - Div.offsetHeight) / 2) + "px"; 
		Div.style.left = ( (document.documentElement.clientWidth - Div.offsetWidth) / 2) + "px"; 
		var w=$("#"+DivId).find(".modal_window");
		if(w.size()>0){
			w.get(0).style.height=document.documentElement.scrollHeight+ "px"; 
		}
	}
} 

function ajaxConfirm(msg,url){
	CConfirm(msg,function(){
		$.ajax({
			clearForm: false,
			url:url,
			type:"post",
			success:function(data){
				var json = eval("("+data+")");
	      		if(json.status==0){//操作失败
	      			
	      		}else if(json.status==1){//操作成功
	      			saveSuccess(json.msg);
	      		}
	        }
		});
	});
}

/**
 * 删除单个数据
 * @param id
 * @param url
 */
function deleteOne(id,url){
	CConfirm("确定删除记录！",function(){
		//var url="codetypeAction!deletexx.action";
		$.ajax({
			clearForm: false,
			url:url,
			data:"id="+id,
			success:function(data){
				var json = eval("("+data+")");
	      		if(json.status==0){//操作失败
	      			
	      		}else if(json.status==1){//操作成功
	      			saveSuccess(json.msg);
	      		}
	        }
		});
	});
}
/**
 * 删除多条记录
 * @param id
 * @param url
 */
function deleteAll(url){
	if($('input:checked').size()==0){
		CAlert("至少选择一条记录删除！");
		return;
	}
	var $obj=$('input:checked');
	var sns="";
	for(var i=0;i<$obj.size();i++){
		var obj=$obj.get(i);
		var id=obj.value;
		if(!(typeof(id)=='undenfed' || id=='')){
			if(i!=$obj.size()-1){
				sns+=id+",";
			}else{
				sns+=id;
			}
		}
	}
	deleteOne(sns,url);
}
/**
 * 修改状态
 * @param id
 * @param isactives
 * @param url
 */
function changeStatus(id,isactives,url){
	$.ajax({
		clearForm: false,
		url:url,
		data:"vo.id="+id+"&vo.isactives="+isactives,
		success:function(data){
			var json = eval("("+data+")");
      		if(json.status==0){//操作失败
      			
      		}else if(json.status==1){//操作成功
      			saveSuccess(json.msg);
      		}
        }
	});
}
/**
 * 全选
 * @param obj
 */
function checkAll(obj,formid){
	var $obj;
	if(typeof(formid)=="undefined" || formid==""){
		$obj=$("input[type='checkbox']");
	}else{
		$obj=$("input[type='checkbox']","#"+formid);
	}
	for(var i=0;i<$obj.size();i++){
		var o=$obj.get(i);
		o.checked = obj.checked;
	}
}
/**
 * 清空表单
 * @param formid
 */
function clearData(formid){
	if(typeof(formid)=="undefined" || formid==""){
		formid="formid";
	}
	var inp=$("input[type='text']","#"+formid);//输入框
	for(var i=0;i<inp.size();i++){
		inp.eq(i).val("");
	}
	var sel=$("select","#"+formid);//下拉框
	for(var i=0;i<sel.size();i++){
		var s=sel.get(i);
		if(s.options[0].value==""){
			s.options[0].selected=true;
		}
	}
}
/**
 * 上传文件
 * @param obj
 */
function selectFile(obj){
	var url=obj.value;
	$(obj).parent().find("input[type='text']").val(url);
}
/**
 * 查看图片
 * @param url
 */
function lookImg(url){
	url=url.replace(/\#/g,"%23");
	 url=url.replace(/\&/g,"%26");
	 url=url.replace(/\+/g,"%2B");
	window.open("../../../common/commonAction!lookImgByPage.action?imgurl="+url);
}

