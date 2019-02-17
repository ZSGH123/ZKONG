/**
 * 作者：2671242147@qq.com
 * 时间：2019-01-06
 * 主播审核资料上传
 */
$(
	function() {
		$("#idCardfile").uploadify({
			//'debug' : true,
			//'buttonClass': 'btn', //按钮的css
			'buttonImage' : 'img/select-file.png',
			'buttonCursor' : 'hand',
			//'buttonText' : '请选择图片文件',
			'height' : 38,
			'width' : 38,
			'swf' : "misc/uploadify.swf",
			'uploader' : 'uploadfile.do',
			'cancelImg' : '/img/YYLive-max.png',
			'folder' : 'UploadFile', //上传到哪个文件夹
			'queueID' : 'fileQueue',
			'auto' : false,
			'multi' : true,
			'fileTypeDesc' : '请选择*.jpg;*.jpge;*.gif;*.png文件',
			'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
			'fileSizeLimit' : '3MB',
			'queueSizeLimit' : 5,
			'onQueueComplete' : function(queueData) {
				alert(queueData.uploadsSuccessful + ' 文件上传成功 ' +
					  queueData.uploadsErrored + ' 文件上传失败 ');
			},
			'onFallback' : function() {
				alert("您未安装FLASH控件，无法上传图片！请安装FLASH控件后再试。");
			},
			'onSelectError' : function(file, errorCode, errorMsg) {
				switch (errorCode) {
				case -100:
					alert("上传的文件数量已经超出系统限制的" + $('#idcardfile_upload').uploadify('settings', 'queueSizeLimit') + "个文件！");
					break;
				case -110:
					alert("文件 [" + file.name + "] 大小超出系统限制的" + $('#idcardfile_upload').uploadify('settings', 'fileSizeLimit') + "大小！");
					break;
				case -120:
					alert("文件 [" + file.name + "] 大小异常！");
					break;
				case -130:
					alert("文件 [" + file.name + "] 类型不正确！");
					break;
				}
			},
			'onUploadStart' : function(file) {
				//附加额外数据
				var json={'user' : '钟强', 'cover' : 'url','fileName':file.name,'fileSize':file.size,'fileType':file.type};
				$("#idCardfile").uploadify('settings','formData',json, true);//Json格式
			},
			'onUploadSuccess' : function(file, data, response) {
				alert('文件 ' + file.name + ' 已成功上传，响应消息为： ' + response + ':' + data);
			},
			'onUploadError' : function(file, errorCode, errorMsg, errorString) {
				alert('文件' + file.name + ' 上传失败，错误原因：' + errorString);
			},
		});
        //为上传按钮注册点击上传事件
		$("#uploadbtn").click(
			function() {
				$("#idCardfile").uploadify('upload', '*');
			});
	}
);