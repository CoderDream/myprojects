<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../resources/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../resources/js/jquery.js"></script>

<script type="text/javascript">
$(document).ready(function(){
  $(".click").click(function(){
  $(".tip").fadeIn(200);
  });
  
  $(".tiptop a").click(function(){
  $(".tip").fadeOut(200);
});

  $(".sure").click(function(){
  $(".tip").fadeOut(100);
});

  $(".cancel").click(function(){
  $(".tip").fadeOut(100);
});

});
</script>


</head>


<body>

<script type="text/javascript" src="../resources/js/category.js"></script>



<div class="operatemessage">
	<s:property value="message" />
</div>

<div class="place">
	<span><s:text name="place" /></span>
	<ul class="placeul">
		<li><a href="#"><s:text name="category_manage" /></a></li>
	</ul>
</div>
    
    <div class="rightinfo">
    
    <div class="tools">
    
    	<form name="addForm" id="addForm">
			<ul class="toolbar" onclick="add();">
				<li><span><img src="../resources/images/t01.png"></span> <s:text
						name="add" /></li>
			</ul>
		</form>
    
    </div>
    
    
    	<s:form id="categoryForm" action="remove" theme="simple">
		<!--列表表格-->
		<table class="tablelist">
			<thead>
				<tr>
					<th><s:text name="category_name" /></th>
					<th><s:text name="category_picture" /></th>
					<th width="8%"><s:text name="edit" /></th>
					<th width="8%"><s:text name="delete" /></th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="categoryvos">
					<tr>
						<td width="18%"><s:property value="name" /></td>
						<td class="imgtd"><img
							style="height: 64px; width: 64px; padding: 5px;"
							src='../resources/images<s:property value="picPath" />'></td>
						<td><a
							href='<s:url action="edit"><s:param name="id" value="id" /></s:url>'
							class="tablelink"><s:text name="edit" /></a></td>
						<td><a
							href='<s:url action="remove"> <s:param name="id" value="id" /></s:url>'
							class="tablelink"><s:text name="delete" /></a></td>
					</tr>
				</s:iterator>
			</tbody>
		</table>
	</s:form>
    
   
    	<!-- 分页信息 -->
	<div class="pagin">
		<div class="message">
			<s:text name="total" />
			&nbsp;&nbsp;<i class="blue"><s:property value="count" /></i>&nbsp;&nbsp;
			<s:text name="record_message" />
			&nbsp;&nbsp;<i class="blue"><s:property value="pageNow" />&nbsp;&nbsp;</i>
			<s:text name="page_total" />
			&nbsp;&nbsp;<i class="blue"><s:property value="pageTotal" />&nbsp;&nbsp;</i>
			<s:text name="page_end" />
		</div>
		<form name="pageForm" id="pageForm">
			<s:hidden id="pageNow" name="pageNow" />
			<s:hidden id="pageTotal" name="pageTotal" />
			<ul class="paginList">
				<li class="paginItem"><s:if test="pageNow == 1">
						<span class="pagepre01">&nbsp;&nbsp;</span>
					</s:if> <s:else>
						<span class="pagepre02"><a href="javascript:prePage();">&nbsp;&nbsp;</a></span>
					</s:else></li>
				<li class="paginItem"><label>&nbsp;&nbsp;<s:text name="no" />&nbsp;&nbsp;<s:property
							value="pageNow" />&nbsp;&nbsp;<s:text name="page" />&nbsp;&nbsp;
				</label></li>
				<li class="paginItem"><s:if test="pageNow == pageTotal">
						<span class="pagenxt01">&nbsp;&nbsp;</span>
					</s:if> <s:else>
						<span class="pagenxt02"><a href="javascript:nextPage();">&nbsp;&nbsp;</a></span>
					</s:else></li>
				<li class="paginItem"><span><input type="text" class="twoinput"
						id="pageInput" name="pageInput">&nbsp;<input name="" type="button"
						class="btn2" onclick="load();" value='<s:text name="confirm" />' /></span></li>
			</ul>
		</form>
	</div>
    
    
    <div class="tip">
    	<div class="tiptop"><span>提示信息</span><a></a></div>
        
      <div class="tipinfo">
        <span><img src="../resources/images/ticon.png" /></span>
        <div class="tipright">
        <p>是否确认对信息的修改 ？</p>
        <cite>如果是请点击确定按钮 ，否则请点取消。</cite>
        </div>
        </div>
        
        <div class="tipbtn">
        <input name="" type="button"  class="sure" value="确定" />&nbsp;
        <input name="" type="button"  class="cancel" value="取消" />
        </div>
    
    </div>
    
    
    
    
    </div>
    
    <script type="text/javascript">
	$('.tablelist tbody tr:odd').addClass('odd');
	</script>

</body>

</html>
