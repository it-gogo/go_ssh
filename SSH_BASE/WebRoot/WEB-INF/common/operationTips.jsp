<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="/WEB-INF/client/common/head.jsp" >
   	<jsp:param value="跳转提示" name="name"/>
</jsp:include>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
}

body {
	background: #e9e9e9;
	font-family: '微软雅黑';
	color: #333;
	font-size: 16px;
}

.system-message {
	padding: 24px 48px;
	width: 550px;
	height: 300px;
	margin: 80px auto;
	position: relative;
}

.system-message h1 {
	font-size: 100px;
	font-weight: normal;
	line-height: 120px;
	margin-bottom: 12px;
}

.system-message .jump {
	width: 300px;
	margin-left: 240px;
	color: #999;
	font-size: 14px;
	font-weight: 700;
}

.system-message .jump a {
	color: #333;
}

.system-message .success,.system-message .error {
	line-height: 1.8em;
	font-size: 20px;
	width: 300px;
	font-weight: 700;
	padding: 120px 0 0 240px;
}

.system-message .detail {
	font-size: 12px;
	line-height: 20px;
	margin-top: 12px;
	display: none
}

.msg_ng {
	width: 550px;
	min-height: 220px;
	background: url(../client/main/images/msg_ng.jpg) no-repeat;
	position: relative;
	zoom: 1;
}

.msg_ok {
	width: 550px;
	min-height: 220px;
	background: url(../client/main/images/msg_ok.jpg) no-repeat;
	position: relative;
	zoom: 1;
}

#href {
	display: block;
	width: 72px;
	height: 28px;
	background: url(../client/main/images/jumpbg.jpg) no-repeat center;
	text-align: center;
	text-decoration: none;
	color: #3e412c;
	margin: 10px 0 0 240px;
	font-size: 14px;
	line-height: 28px;
}
.cf-hidden {
	display: none;
}

.cf-invisible {
	visibility: hidden;
}
</style>
</head>
<body>
	<div class="system-message">
		<div class="<c:if test="${operation.status==1 }">msg_ok</c:if><c:if test="${operation.status==0 }">msg_ng</c:if>" >
			<p class="success">${operation.msg }</p>
			<p class="jump">
				系统正在为您跳转，请稍候： <b id="wait">5</b>
			</p>
			<a id="href" href="${operation.href }">立即跳转</a>
		</div>
		<p class="detail"></p>
	</div>
	<script type="text/javascript">
		(function() {
			var wait = document.getElementById('wait'), href = $("#href").attr("href");
			var interval = setInterval(function() {
				var time = --wait.innerHTML;
				if (time == 0) {
					location.href = href;
					clearInterval(interval);
				}
				;
			}, 1000);
		})();
	</script>
	<!-- <div>
		<object id="ClCache" click="sendMsg" host="" width="0" height="0"></object>
	</div> -->
</body>
</html>