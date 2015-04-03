function add() {
	// 取得用户输入的分类
	var categoryId = $("#categoryId").val();

	// 如果没有输入，则不响应确认按钮事件
	if (null == categoryId || '' == categoryId) {
		$("#categoryId").val("1");
	}

	$("[name='addForm']").attr("action", "add.action");
	$("[name='addForm']").attr("method", "post");
	$("[name='addForm']").submit();
}

function prePage() {
	var pageNow = $("#pageNow").val();
	pageNow = parseInt(pageNow) - 1;
	$("#pageNow").val(pageNow);
	var categoryId = $("#categoryId").val();
	$("#categoryId").val(categoryId);

	$("[name='pageForm']").attr("action", "list.action");
	$("[name='pageForm']").attr("method", "post");
	$("[name='pageForm']").submit();
}

function nextPage() {
	var pageNow = $("#pageNow").val();
	pageNow = parseInt(pageNow) + 1;
	$("#pageNow").val(pageNow);
	var categoryId = $("#categoryId").val();
	$("#categoryId").val(categoryId);

	$("[name='pageForm']").attr("action", "list.action");
	$("[name='pageForm']").attr("method", "post");
	$("[name='pageForm']").submit();
}

function load() {
	// 取得用户输入的页数
	var pageNow = $("#pageInput").val();
	// 如果没有输入，则不响应确认按钮事件
	if ('' != pageNow) {
		$("[name='pageForm']").attr("action", "list.action");
		$("[name='pageForm']").attr("method", "post");
		$("[name='pageForm']").submit();
	}
}

// 查询
function query() {
	// 取得用户输入的分类
	var categoryId = $("#categoryId").val();

	// 如果没有输入，则不响应确认按钮事件
	if (null == categoryId || '' == categoryId) {
		$("#categoryId").val("1");
	}

	$("[name='queryForm']").attr("action", "list.action");
	$("[name='queryForm']").attr("method", "post");
	$("[name='queryForm']").submit();
}

// 上传
function openUploadPage() {
	// 接收父页面上传回的值
	var newFileName = window
			.showModalDialog("../upload/upload.action", null,
					"dialogWidth=800px;dialogHeight=600px;status=no;help=no;scrollbars=no");
	// newFileName = "" + newFileName;
	$("#picPath").val("/dish/" + newFileName);
	// 改变图片源，实时刷新图片
	$("#dishPic").attr("src", "../resources/images/dish/" + newFileName);
}

function save() {
	alert("save #1");
	// 取得用户输入的分类
	var categoryId = $("#categoryId").val();

	// 如果没有输入，则不响应确认按钮事件
	if (null == categoryId || '' == categoryId) {
		$("#categoryId").val("1");
	}
	alert("save #2");
	$("[name='saveForm']").attr("action", "save.action");
	$("[name='saveForm']").attr("method", "post");
	$("[name='saveForm']").submit();
}

function remove() {
	// 取得用户输入的分类
	var categoryId = $("#categoryId").val();

	// 如果没有输入，则不响应确认按钮事件
	if (null == categoryId || '' == categoryId) {
		$("#categoryId").val("1");
	}

	$("[name='saveForm']").attr("action", "remove.action");
	$("[name='saveForm']").attr("method", "post");
	$("[name='saveForm']").submit();
}

function update() {
	$("[name='updateForm']").attr("action", "update.action");
	$("[name='updateForm']").attr("method", "post");
	$("[name='updateForm']").submit();
}

function updateBack() {
	$("[name='updateForm']").attr("action", "list.action");
	$("[name='updateForm']").attr("method", "post");
	$("[name='updateForm']").submit();
}

function saveBack() {
	$("[name='saveForm']").attr("action", "list.action");
	$("[name='saveForm']").attr("method", "post");
	$("[name='saveForm']").submit();
}

$(function() {
	var categoryId = $("#categoryId").val();
	$("#dishSelect").each(function() {
		$(this).children("option").each(function() {
			if (categoryId == $(this).val()) {
				$(this).attr("selected", true);
				return;
			}
		});
	});

	// 下拉选单值变事件
	$('#dishSelect').change(function() {
		var categoryId = $(this).children('option:selected').val();
		$("#categoryId").val(categoryId);
	});
});