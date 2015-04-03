<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/resources/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//顶部导航切换
		$(".nav li a").click(function() {
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})
	})
</script>


</head>

<body style="background: url(<%=request.getContextPath()%>/resources/images/topbg.gif) repeat-x;">

	<div class="topleft">
		<a href="main.html" target="_parent"><img src="<%=request.getContextPath()%>/resources/images/logo.png"
			title="系统首页" /></a>
	</div>

	<ul class="nav">
		<li><a href="default.html" target="rightFrame" class="selected"><img
				src="<%=request.getContextPath()%>/resources/images/icon01.png" title="权限管理" />
				<h2>用户权限</h2></a></li>
		<li><a href="imgtable.html" target="rightFrame"><img
				src="<%=request.getContextPath()%>/resources/images/icon02.png" title="菜单菜品" />
				<h2>菜单菜品</h2></a></li>
		<li><a href="imglist.html" target="rightFrame"><img
				src="<%=request.getContextPath()%>/resources/images/icon03.png" title="收银流水" />
				<h2>收银流水</h2></a></li>
		<li><a href="tools.html" target="rightFrame"><img
				src="<%=request.getContextPath()%>/resources/images/icon04.png" title="会员管理" />
				<h2>会员管理</h2></a></li>
	</ul>

	<div class="topright">
		<ul>
			<li><span><img src="<%=request.getContextPath()%>/resources/images/help.png" title="帮助" class="helpimg" /></span><a
				href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
			<li><a href="<%=request.getContextPath()%>/login/login.action" target="_parent">退出</a></li>
		</ul>

		<div class="user">
			<span>admin</span> <i>消息</i> <b>5</b>
		</div>

	</div>

</body>
</html>
