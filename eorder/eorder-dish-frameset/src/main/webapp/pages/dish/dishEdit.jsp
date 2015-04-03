<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<script type="text/javascript" src="../resources/js/dish.js"></script>
<s:if test="null == id">
	<div class="place">
		<span><s:text name="place" /></span>
		<ul class="placeul">
			<li><a href="dish.action"><s:text name="dish_manage" /></a></li>
			<li><s:text name="add_dish" /></li>
		</ul>
	</div>

	<div class="formbody">
		<div class="operatemessage">
			<s:property value="message" />
			&nbsp;&nbsp;&nbsp;&nbsp;
		</div>

		<div>
			<form name="saveForm" id="saveForm">
				<s:hidden id="categoryId" name="categoryId" />
				<s:hidden id="picPath" name="picPath" />
				<ul class="forminfo">
					<li><label><s:text name="dish_name" /></label><input id="name"
						name="name" value="${name}" type="text" class="dfinput" /></li>
					<li><label><s:text name="dish_price" /></label><input id="price"
						name="price" value="${price}" type="text" class="dfinput" /></li>
					<li><label><s:text name="upload" /></label><input name=""
						type="button" class="scbtn" onclick="openUploadPage();"
						value='<s:text name="upload" />' /></li>
					<li><label><s:text name="dish_picture" /></label><img id="dishPic"
						style="width: 348px; height: 348px; padding: 5px;"
						src='../resources/images${picPath}'></li>
					<li><label><s:text name="category_name" /></label> <select
						id="dishSelect" name="dishSelect" class="select3">
							<s:iterator value="categoryVOList" id="categoryVO">
								<option value='<s:property value="#categoryVO.id" />'><s:property
										value="#categoryVO.name" /></option>
							</s:iterator>
					</select></li>
					<li><label>&nbsp;&nbsp;</label><input id="btnSave" name="btnSave"
						type="button" class="btn" onclick="saveBack();"
						value="<s:text name='back_to_preview' />" />&nbsp;&nbsp;&nbsp;&nbsp;<input
						name="" type="button" class="btn" onclick="save();"
						value="<s:text name='confirm_save' />" /></li>


				</ul>
			</form>
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
		<div class="operatemessage">
			<s:property value="message" />
			&nbsp;&nbsp;&nbsp;&nbsp;
		</div>

		<div>
			<form name="updateForm">
				<s:hidden id="id" name="id" value="%{id}"></s:hidden>
				<s:hidden id="categoryId" name="categoryId" />
				<s:hidden id="picPath" name="picPath" />
				<ul class="forminfo">
					<li><label><s:text name="dish_name" /></label><input id="name"
						name="name" type="text" value='<s:property value="name" />'
						class="dfinput" /></li>
					<li><label><s:text name="dish_price" /></label><input id="price"
						name="price" type="text" value='<s:property value="price" />'
						class="dfinput" /></li>
					<li><label><s:text name="upload" /></label><input name=""
						type="button" class="scbtn" onclick="openUploadPage();"
						value='<s:text name="upload" />' /></li>
					<li><label><s:text name="dish_picture" /></label><img id="dishPic"
						style="width: 348px; height: 348px; padding: 5px;"
						src='../resources/images${picPath}'></li>
					<li><label><s:text name="category_name" /></label> <select
						id="dishSelect" name="dishSelect" class="select3">
							<s:iterator value="categoryVOList" id="categoryVO">
								<option value='<s:property value="#categoryVO.id" />'><s:property
										value="#categoryVO.name" /></option>
							</s:iterator>
					</select></li>
					<li><label>&nbsp;&nbsp;</label><input id="btnSave" name="btnUpdate"
						type="button" class="btn" onclick="updateBack();"
						value="<s:text name='back_to_preview' />" />&nbsp;&nbsp;&nbsp;&nbsp;<input
						name="" type="button" class="btn" onclick="update();"
						value="<s:text name='confirm_save' />" /></li>
				</ul>
			</form>
		</div>
	</div>
</s:else>