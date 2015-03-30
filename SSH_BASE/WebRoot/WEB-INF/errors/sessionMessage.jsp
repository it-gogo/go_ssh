<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<html>
  <head>
    <title>列表数据加载出错</title>
    <%@include file="../../common/includefile.jsp"%>	
  </head>
  <body class="easyui-layout">
      <div region="center">
      
	   <div  style="background:#F0F0F2;padding:5px;width:100%;height:30%"  align="center">
		   <br><br>
           <br>
           <font size="30" color="red">
		         SESSION已经过期，请重新登陆!<a href="<%=request.getContextPath()%>/admin" "> <font size="30" color="blue">请登陆</font></a>
           </font>
	    </div>
      </div>
 <script type="text/javascript">
   //var s = ;
   function tologin(s){
       if(self.frameElement.tagName=="IFRAME"){
         // alert(1);
          local
       }else{
          alert(2);
       }
       //alert(s);
      
   }
</script>
  </body>
</html>
