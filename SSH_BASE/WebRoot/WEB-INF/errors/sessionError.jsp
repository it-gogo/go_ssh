<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>孝感市食品药品监督管理局-行政审批系统</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<style type="text/css">
	/*过期提示*/
.expired{ width:100%;}
.expired h2{ text-align:center; font-size:16px; color:#226497;}
.expired h2 a{ color:#F41D17; font-size:16px;}
</style>
</head>

<body onload="startTimes();">
<div class="expired">
	<h2>
        <span>
        <img align="absmiddle" src="../css/images/expired.png">
        </span>
        登录已经过期，请重新登录！<span id="secondes">5</span>&nbsp;秒后将自动跳转登录页面,<a href="javascript:void(0)"  onclick="tologin()"> 请登录</a>
	</h2>
</div>
</body>
</html>
<script>
 
 function tologin(){
    top.location.href = "<%=request.getContextPath()%>/";
 }
 
  var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                   // history.go(-1);
                   tologin();
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    //history.go(-1);
                     tologin();
                }
            }
</script>