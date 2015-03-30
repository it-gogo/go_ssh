<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>树</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/tree/jquery.ztree.core-3.5.js"></script>
    <link href="<%=request.getContextPath() %>/tree/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <style type="text/css">
    	span{display:inline;}
    </style>
  </head>
  <body>
    	<ul id="tree" class="ztree" style="overflow-y:auto;overflow-x:auto;"></ul>
  </body>
</html>
<script type="text/javascript">
  var zTreeObj;
  
  var setting = {
       view: {
			dblClickExpand: false,
			showLine: true,
			selectedMulti: false
	   },
		
       data:{
          simpleData: {
				enable:true,
				idKey: "id",
				pIdKey: "pId",
				rootPId: ""
		  }

       
       },
       
       callback: {
				beforeClick: treebeforeClick,
				onClick: treeOnClick
		}
		
		
		
       
  
  
  };
  
  //初始化树
  var initTree = function(data){
      var treeObj = $("#tree");
      zTreeObj = $.fn.zTree.init(treeObj,setting,data);
     // zTreeObj.expandAll(true);
      
  };
  
  $(document).ready(function(){
     $.get(treeurl,treeopt,function(data){
         //alert(data);
         $("#tree").get(0).style.height="100%";
        var  json = eval('('+data+')');
         initTree(json);
     });
  
  });

  var reloadTree = function(){
       $.get(treeurl,treeopt,function(data){
         //alert(data);
        var  json = eval('('+data+')');
          zTreeObj.destroy();
          initTree(json);

       });
  }
</script>