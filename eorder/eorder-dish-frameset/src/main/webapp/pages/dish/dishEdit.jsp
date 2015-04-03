<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="<%=request.getContextPath()%>/resources/css/style.css"
	rel="stylesheet" type="text/css" />
<link href="<%=request.getContextPath()%>/resources/css/select.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.idTabs.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/select-ui.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/editor/kindeditor.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/dish.js"></script>

<script type="text/javascript">
	KE.show({
		id : 'content7',
		cssPath : './index.css'
	});
</script>

<script type="text/javascript">
	$(document).ready(function(e) {
		$(".select1").uedSelect({
			width : 345
		});
		$(".select2").uedSelect({
			width : 167
		});
		$(".select3").uedSelect({
			width : 100
		});
	});
</script>
</head>
<body>
	<s:if test="null == id">
		<div class="place">
			<span><s:text name="place" /></span>
			<ul class="placeul">
				<li><a href="dish.action"><s:text name="dish_manage" /></a></li>
				<li><s:text name="add_dish" /></li>
			</ul>
		</div>
		<div class="formbody">
			<div id="usual1" class="usual">
				<div id="tab1" class="tabson">
					<form name="saveForm" id="saveForm">
						<s:hidden id="categoryId" name="categoryId" />
						<s:hidden id="picPath" name="picPath" />
						<ul class="forminfo">
							<li><s:property value="message" />&nbsp;&nbsp;</li>
						</ul>
						<ul class="forminfo">
							<li><label><s:text name="dish_name" /></label><input id="name"
								name="name" value="${name}" type="text" class="dfinput" /></li>
							<li><label><s:text name="dish_price" /></label><input id="price"
								name="price" value="${price}" type="text" class="dfinput" /></li>
							<li><label><s:text name="upload" /></label><input name=""
								type="button" class="scbtn" onclick="openUploadPage();"
								value='<s:text name="upload" />' /></li>
							<li><label><s:text name="dish_picture" /></label><img id="dishPic"
								style="width: 240px; height: 240px; padding: 5px;"
								src='../resources/images${picPath}'></li>
							<li><label><s:text name="category_name" /></label>
								<div class="vocation">
									<select id="dishSelect" name="dishSelect" class="select1">
										<s:iterator value="categoryVOList" id="categoryVO">
											<option value='<s:property value="#categoryVO.id" />'><s:property
													value="#categoryVO.name" /></option>
										</s:iterator>
									</select>
								</div></li>
							<li><label>&nbsp;</label><input id="btnSave" name="btnSave"
								type="button" class="btn" onclick="saveBack();"
								value="<s:text name='back_to_preview' />" />&nbsp;&nbsp;&nbsp;&nbsp;<input
								name="" type="button" class="btn" onclick="save();"
								value="<s:text name='confirm_save' />" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</s:if>
	<s:else>
		<div class="place">
			<span><s:text name="place" /></span>
			<ul class="placeul">
				<li><a href="dish.action"><s:text name="dish_manage" /></a></li>
				<li><s:text name="edit_dish" /></li>
			</ul>
		</div>
		<div class="formbody">
			<div id="usual1" class="usual">
				<div id="tab1" class="tabson">
					<form name="updateForm">
						<s:hidden id="id" name="id" value="%{id}"></s:hidden>
						<s:hidden id="categoryId" name="categoryId" />
						<s:hidden id="picPath" name="picPath" />
						<ul class="forminfo">
							<li><s:property value="message" />&nbsp;&nbsp;</li>
						</ul>
						<ul class="forminfo">
							<li><label><s:text name="dish_name" /></label><input id="name"
								name="name" value="${name}" type="text" class="dfinput" /></li>
							<li><label><s:text name="dish_price" /></label><input id="price"
								name="price" value="${price}" type="text" class="dfinput" /></li>
							<li><label><s:text name="upload" /></label><input name=""
								type="button" class="scbtn" onclick="openUploadPage();"
								value='<s:text name="upload" />' /></li>
							<li><label><s:text name="dish_picture" /></label><img id="dishPic"
								style="width: 240px; height: 240px; padding: 5px;"
								src='../resources/images${picPath}'></li>
							<li><label><s:text name="category_name" /></label>
								<div class="vocation">
									<select id="dishSelect" name="dishSelect" class="select1">
										<s:iterator value="categoryVOList" id="categoryVO">
											<option value='<s:property value="#categoryVO.id" />'><s:property
													value="#categoryVO.name" /></option>
										</s:iterator>
									</select>
								</div></li>
							<li><label>&nbsp;&nbsp;</label><input id="btnSave" name="btnUpdate"
								type="button" class="btn" onclick="updateBack();"
								value="<s:text name='back_to_preview' />" />&nbsp;&nbsp;&nbsp;&nbsp;<input
								name="" type="button" class="btn" onclick="update();"
								value="<s:text name='confirm_save' />" /></li>
						</ul>
					</form>
				</div>
			</div>
		</div>
	</s:else>
</body>

</html>